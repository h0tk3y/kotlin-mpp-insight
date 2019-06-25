@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

// fixme remove this suppression

plugins {
    kotlin("js")
    kotlin("plugin.serialization")
}

repositories {
    maven("$rootDir/build/repo")
}

kotlin.target {
    browser({ webpackTask { this.inputs.files(kotlin.target.compilations["main"].output.allOutputs) } })
}

kotlin.sourceSets.getByName("main") {
    dependencies {
        implementation(project(":model"))

        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.11.1")
        implementation(npm("vis", "4.21.0"))
        implementation(npm("@types/vis", "4.21.0"))
    }
}

/*
val webpackOutput by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = false

    val browserWebpack by tasks.withType<KotlinWebpack>()
    project.artifacts.add(name, project.provider { browserWebpack.outputPath.listFiles().single() }) {
        builtBy(browserWebpack)
    }
}

*/
