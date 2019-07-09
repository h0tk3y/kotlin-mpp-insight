package com.h0tk3y.kotlin.mpp.insight

import com.h0tk3y.kotlin.mpp.insight.model.*
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinTargetComponent
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.JointAndroidKotlinTargetComponent
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinMultiplatformPlugin
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinVariant

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
                val compilations = target.compilations.map {
                    CompilationModel(CompilationId(target.name, it.name), it.defaultSourceSet.name)
                }

                val variants = target.getTargetComponents().flatMap {
                    buildVariantModelFromKotlinTargetComponent(it, compilations)
                }

                TargetModel(target.name, compilations, variants)
            }

    fun buildSourceSetsModel(project: Project): List<SourceSetModel> {
        val modelMap = project.kotlinExtension.sourceSets.associate { sourceSet ->
            sourceSet.name to SourceSetModel(
                sourceSet.name,
                sourceSet.kotlin.srcDirs.map { it.path },
                sourceSet.resources.srcDirs.map { it.path },
                // todo
                emptyList(), // modified below
                emptyMap() // todo
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

    private fun buildVariantModelFromKotlinTargetComponent(
        component: KotlinTargetComponent, compilations:
        Iterable<CompilationModel>
    ):
        List<VariantModel> {
        val usages = when (component) {
            is KotlinVariant -> component.usages
            is JointAndroidKotlinTargetComponent -> component.usages
            else -> emptySet()
        }
        return usages.map { usage ->
            VariantModel(
                usage.name,
                compilations.single { it.id.compilationName == usage.compilation.name }
            )
        }
    }

}