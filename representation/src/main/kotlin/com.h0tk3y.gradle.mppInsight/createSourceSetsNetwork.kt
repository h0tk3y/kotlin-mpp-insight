package com.h0tk3y.gradle.mppInsight

import com.h0tk3y.kotlin.mpp.insight.model.CompilationModel
import com.h0tk3y.kotlin.mpp.insight.model.MppModel
import com.h0tk3y.kotlin.mpp.insight.model.SourceSetModel
import com.h0tk3y.kotlin.mpp.insight.model.VariantModel
import kotlinx.serialization.json.Json
import org.w3c.dom.HTMLElement
import vis.*
import kotlin.browser.document

private fun jsObject(f: dynamic.() -> Unit): Any = Any().also(f)

open class GraphNode(
    open val key: Any,
    private val label: String
) {
    open fun toVisNode(): Node = object : Node {}.also {
        it.id = visId
        it.label = label
    }

    open val visId: Any
        get() = key.toString()
}

class SourceSetNode(override val key: SourceSetModel) : GraphNode(key, key.name) {
    override val visId: Any
        get() = "(s)${key.name}"
}

class CompilationNode(override val key: CompilationModel) : GraphNode(
    key, key.id.targetName + "/" + key.id.compilationName
) {
    override fun toVisNode(): Node = super.toVisNode().apply {
        color = "#ffa07a"
        shape = "box"
        asDynamic().mass = 0.1
    }

    override val visId: Any
        get() = "(c)${key.id.targetName}/${key.id.compilationName}"
}

class VariantNode(override val key: VariantModel) : GraphNode(key, key.name) {
    override fun toVisNode(): Node = super.toVisNode().apply {
        shape = "box"
        color = "#69bc9e"
        asDynamic().mass = 0.1
    }

    override val visId: Any
        get() = "(v)${key.name}"
}

open class GraphEdge(
    open val from: GraphNode,
    open val to: GraphNode
) {
    open fun toVisEdge() = object : vis.Edge {}.also {
        it.from = from.visId
        it.to = to.visId
        it.id = visId
    }

    open val visId: String
        get() = "${from.visId}->${to.visId}"

    open val isStructural: Boolean
        get() = true
}

class DependsOnEdge(
    override val from: SourceSetNode,
    override val to: SourceSetNode
) : GraphEdge(from, to) {
    override val visId: String
        get() = "(dO)-" + super.visId
}

class InferredDependsOnEdge(
    override val from: SourceSetNode,
    override val to: SourceSetNode
) : GraphEdge(from, to) {
    override fun toVisEdge(): Edge = super.toVisEdge().apply {
        asDynamic().dashes = true
    }

    override val visId: String
        get() = "(iDO)-" + super.visId

//    override val isStructural: Boolean
//        get() = false
}

class VariantProducingCompilationEdge(
    override val from: VariantNode,
    override val to: CompilationNode
) : GraphEdge(from, to) {
    override fun toVisEdge(): Edge = super.toVisEdge().apply {
        asDynamic().dashes = true
    }

    override val visId: String
        get() = "(vPC)-" + super.visId
}

class DefaultSourceSetEdge(
    override val from: CompilationNode,
    override val to: SourceSetNode
) : GraphEdge(from, to) {
    override fun toVisEdge(): Edge = super.toVisEdge().apply {
        asDynamic().arrows = ""
    }

    override val visId: String
        get() = "(dSS)-" + super.visId
}

private fun <T> Iterable<T>.topologicalSort(neighbors: (T) -> Iterable<T>): List<T> {
    val result = mutableListOf<T>()
    val visited = mutableSetOf<T>()

    fun dfs(t: T) {
        visited += t
        for (n in neighbors(t)) {
            if (n !in visited) {
                dfs(n)
            }
        }
        result += t
    }

    for (t in this) {
        if (t !in visited)
            dfs(t)
    }

    return result.reversed()
}

private fun assignLevels(
    nodes: Iterable<GraphNode>,
    edges: Map<GraphNode, Iterable<GraphEdge>>
): MutableMap<GraphNode, Int> {
    fun neighbors(from: GraphNode) =
        (edges[from] ?: emptyList()).map { it.to }

    val topSortedByReverseDependsOn = nodes.topologicalSort { neighbors(it) }.reversed()

    val maxIncomingDepth = mutableMapOf<GraphNode, Int>()

    for (v in topSortedByReverseDependsOn) {
        maxIncomingDepth[v] = (neighbors(v).map { maxIncomingDepth.getValue(it) }.max() ?: -1) + 1
    }

    return maxIncomingDepth
}

private var existingNetwork: Network? = null

enum class DetailLevel {
    SOURCE_SETS_WITH_COMPILATIONS,
    SOURCE_SETS_WITH_COMPILATIONS_AND_VARIANTS
}

fun createSourceSetsNetwork(container: HTMLElement, model: MppModel, onlyPublished: Boolean, detailLevel: DetailLevel) {
    existingNetwork?.destroy()

    val sourceSetByName = model.sourceSets.associateBy { it.name }
    val commonMain = sourceSetByName.getValue("commonMain")
    val commonTest = sourceSetByName.getValue("commonTest")

    val sourceSetsToDraw = if (!onlyPublished) model.sourceSets else
        model.targets.flatMapTo(mutableSetOf<SourceSetModel>()) {
            it.variants.flatMap {
                val defaultSourceSet = sourceSetByName.getValue(it.producingCompilation.defaultSourceSetName)
                defaultSourceSet.dependsOnClosure()
            }
        }

    val edges = mutableListOf<GraphEdge>()

    val sourceSetNodes = sourceSetsToDraw.associateWith { SourceSetNode(it) }

    sourceSetsToDraw.forEach { from ->
        from.sanitizedDependsOn.toSet().forEach { to ->
            if (to in sourceSetsToDraw) {
                edges += DependsOnEdge(sourceSetNodes.getValue(from), sourceSetNodes.getValue(to))
            }
        }
    }

    val compilationNodes =
        model.targets.flatMap { target ->
            target.compilations
                .filter { sourceSetByName.getValue(it.defaultSourceSetName) in sourceSetsToDraw }
                .map { it to CompilationNode(it) }
        }.toMap()

    compilationNodes.forEach { (id, node) ->
        edges += DefaultSourceSetEdge(
            node,
            sourceSetNodes.getValue(sourceSetByName.getValue(id.defaultSourceSetName))
        )
    }

    val variantNodes: MutableMap<VariantModel, VariantNode> = mutableMapOf()

    if (detailLevel == DetailLevel.SOURCE_SETS_WITH_COMPILATIONS_AND_VARIANTS) {
        model.targets.forEach { target ->
            target.variants.forEach { variant ->
                variantNodes[variant] = VariantNode(variant)
            }
        }

        variantNodes.forEach { (id, node) ->
            edges += VariantProducingCompilationEdge(node, compilationNodes.getValue(id.producingCompilation))
        }
    }

    // TODO properly match main/test if needed
    sourceSetsToDraw.forEach { sourceSet ->
        if (sourceSet.name.endsWith("Test")) {
            val main = model.sourceSets.find { it.name == sourceSet.name.removeSuffix("Test") + "Main" }
            if (main != null) {
                edges += InferredDependsOnEdge(sourceSetNodes.getValue(sourceSet), sourceSetNodes.getValue(main))
            }
        }
    }

    val allNodes = sourceSetNodes.plus(compilationNodes).plus(variantNodes)
    val visNodes = allNodes.values.associateWith { it.toVisNode() }

    val levels = assignLevels(allNodes.values, edges.filter { it.isStructural }.groupBy { it.from })
    val maxSourceSetLevel = levels.filterKeys { it.key is SourceSetModel }.values.max() ?: 0
    levels.forEach { (node, level) ->
        visNodes.getValue(node).asDynamic().level =
            when (node.key) {
                is CompilationModel -> maxSourceSetLevel + 1
                is VariantModel -> maxSourceSetLevel + 2 // fixme
                else -> level
            }
    }

    val data = object : Data {
        override var nodes: dynamic = visNodes.values.toTypedArray()
        override var edges: dynamic = edges.map { it.toVisEdge().also { println(it.id) } }.toTypedArray()
    }

    // create a network

    val options = object : Options {}.also {
        it.nodes = object : NodeOptions {}.apply {
            shape = "ellipse"
            font = jsObject {
                face = "monospace"
            }
        }
        it.edges = object : EdgeOptions {}.apply {
            smooth = true
            arrows = "to"
        }
        it.layout = jsObject {
            hierarchical = jsObject {
                direction = "LR"
                levelSeparation = "250"
                sortMethod = "directed"
                blockShifting = false
                edgeMinimization = false
                parentCentralization = false
            }
        }
    }

    val result = Network(container, data, options)

    result.hackPhysicsLayout()

    existingNetwork = result
}

fun Network.hackPhysicsLayout() {
    setOptions(object : Options {}.apply {
        physics = jsObject {
            hierarchicalRepulsion = jsObject {
                nodeDistance = 400.0
                damping = 0.3
                springLength = 5.0
                springConstant = 8.0
            }
        }
    })

    val phase2: (Any?) -> Unit = {
        val newOptions = object : Options {}.also {
            it.physics = false
        }
        println("phase2")
        setOptions(newOptions)
    }

    var phase1: ((Any?) -> Unit)? = null

    phase1 = {
        val newOptions = object : Options {}.also {
            it.physics = jsObject {
                hierarchicalRepulsion = jsObject {
                    nodeDistance = 150.0
                    springLength = 100.0
                    springConstant = 0.01
                }
            }
        }
        println("phase1")
        setOptions(newOptions)
        off("stabilizationIterationsDone", phase1)
        on("stabilizationIterationsDone", phase2)
        stabilize(500)
    }

    on("stabilizationIterationsDone", phase1)
    stabilize(500)
}

fun extractMppModelFromDocument(): MppModel =
    Json.parse(
        MppModel.serializer(),
        document.getElementById("data-project-model")!!.getAttribute("data-project-model")!!
    )

private fun SourceSetModel.dependsOnClosure(): Set<SourceSetModel> {
    val result = mutableSetOf<SourceSetModel>()

    fun visit(sourceSet: SourceSetModel) {
        if (result.add(sourceSet)) {
            sourceSet.dependsOn.forEach { visit(it) }
        }
    }

    visit(this)
    return result
}

private val SourceSetModel.sanitizedDependsOn: Iterable<SourceSetModel>
    get() =
        if (dependsOn.size > 1)
            dependsOn.filter { it.name != "commonMain" && it.name != "commonTest" }
        else
            dependsOn