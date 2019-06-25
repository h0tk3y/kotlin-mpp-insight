package com.h0tk3y.kotlin.mpp.insight

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

open class KotlinMppInsightPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.pluginManager.withPlugin("org.jetbrains.kotlin.multiplatform") {
            createGeneratorTasks(project)
        }
    }

    private fun createGeneratorTasks(project: Project) {
        project.tasks.register("generateSourceSetsReport", GernerateReportPage::class.java).configure {
            it.group = "documentation"
        }
    }
}

internal val Project.kotlinExtension
    get() = extensions.getByName("kotlin") as KotlinProjectExtension

internal val Project.multiplatformExtension
    get() = extensions.getByName("kotlin") as KotlinMultiplatformExtension