package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.kotlin.mpp.insight.model.*
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinMultiplatformPlugin

class ModelBuilder {
    fun buildMppModel(project: Project): MppModel {
        val sourceSets = buildSourceSetsModel(project)
        val targets = buildTargetsModel(project)
        return MppModel(targets, sourceSets)
    }

    private fun buildTargetsModel(project: Project): List<TargetModel> =
        project.multiplatformExtension.targets
            .filter { it.name != KotlinMultiplatformPlugin.METADATA_TARGET_NAME }
            .map { target ->
                TargetModel(target.name, target.compilations.map {
                    CompilationModel(CompilationId(target.name, it.name), it.defaultSourceSet.name)
                })
            }

    fun buildSourceSetsModel(project: Project): List<SourceSetModel> {
        val modelMap = project.kotlinExtension.sourceSets.associate { sourceSet ->
            sourceSet.name to SourceSetModel(
                sourceSet.name,
                sourceSet.kotlin.srcDirs.map { it.path },
                sourceSet.resources.srcDirs.map { it.path },
                emptyList(), // todo
                emptyList() // modified below
            )
        }

        project.kotlinExtension.sourceSets.forEach { sourceSet ->
            val model = modelMap.getValue(sourceSet.name)
            val dependencies = sourceSet.dependsOn.map { dependency ->
                modelMap.getValue(dependency.name)
            }
            model.dependsOn = dependencies
        }

        return modelMap.values.toList()
    }
}