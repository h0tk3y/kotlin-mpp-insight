package com.h0tk3y.kotlin.mpp.insight.model

import kotlinx.serialization.Serializable

@Serializable
data class MppModel(
    val targets: List<TargetModel>,
    val sourceSets: List<SourceSetModel>
)

@Serializable
data class TargetModel(
    val name: String,
    val compilations: List<CompilationModel>,
    val variants: List<VariantModel>
)

@Serializable
data class CompilationId(
    val targetName: String,
    val compilationName: String
)

@Serializable
data class SourceSetModel(
    val name: String,
    val kotlinSrcDirs: List<String>,
    val resourcesSrcDirs: List<String>,
    var dependsOn: List<SourceSetModel>,
    val dependencies: Map<DependencyScope, List<ResolvedDependencyModel>>
)

@Serializable
data class CompilationModel(
    val id: CompilationId,
    val defaultSourceSetName: String
)

//region Dependencies

enum class DependencyScope {
    API, IMPLEMENTATION, COMPILE_ONLY, RUNTIME_ONLY
}

@Serializable
data class VariantModel(
    val name: String,
    val producingCompilation: CompilationModel
)

@Serializable
data class ResolvedDependencyModel(
    val group: String,
    val module: String,
    val version: String,
    val transitiveDependencies: List<ResolvedDependencyModel>
)

//endregion