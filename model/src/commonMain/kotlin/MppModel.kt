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
    val compilations: List<CompilationModel>
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
    val participatesInCompilations: List<CompilationId>,
    var dependsOn: List<SourceSetModel>
)

@Serializable
data class CompilationModel(
    val id: CompilationId,
    val defaultSourceSetName: String
)