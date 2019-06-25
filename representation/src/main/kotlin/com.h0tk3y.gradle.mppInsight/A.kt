package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.kotlin.mpp.insight.model.MppModel
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.w3c.dom.HTMLElement
import vis.*
import kotlin.browser.document
import kotlin.browser.window

@UnstableDefault
fun main() {
    window.onload = {
        val model: MppModel = extractMppModelFromDocument()
        println(Json(JsonConfiguration(prettyPrint = true)).stringify(MppModel.serializer(), model))

        val container: dynamic = document.createElement("div").also { document.body!!.appendChild(it) }

        createSourceSetsNetwork(container, model)
        Unit
    }
}

fun createSourceSetsNetwork(container: HTMLElement, model: MppModel): Network {
    fun node(id: Any, label: String, isCompilationNode: Boolean) = object : vis.Node {}.also {
        it.id = id
        it.label = label
        if (isCompilationNode) it.color = "#ffa07a"
    }

    fun edge(from: Any, to: Any) = object : vis.Edge {}.also {
        it.from = from
        it.to = to
        it.id = "${from}_$to"
    }

    val defaultSourceSets = model.targets.flatMap { it.compilations }.map { it.defaultSourceSetName }.toSet()

    // create an array with nodes
    val nodes = model.sourceSets.map {
        node(it.name, it.name, it.name in defaultSourceSets)
    }.toTypedArray()

    // create an array with edges
    val edges = model.sourceSets.flatMap { from ->
        from.dependsOn.map { to -> edge(from.name, to.name) }
    }.toTypedArray()

    val data = object : vis.Data {
        override var nodes: dynamic = nodes
        override var edges: dynamic = edges
    }

    // create a network

    val options = object : Options {}.also {
        it.nodes = object : NodeOptions {}.apply {
            shape = "dot"
            font = "14px monospace black"
        }
        it.edges = object : EdgeOptions {}.apply {
            arrows = "to"
        }
        it.physics = object : Any() {}.apply {
            asDynamic().barnesHut = Any().apply {
                asDynamic().springConstant = 0.02
                asDynamic().gravitationalConstant = -10000
                asDynamic().centralGravity = 0.1
            }
        }
    }

    return Network(container, data, options)
}

fun extractMppModelFromDocument(): MppModel =
    Json.parse(
        MppModel.serializer(),
        document.getElementById("data-project-model")!!.getAttribute("data-project-model")!!)