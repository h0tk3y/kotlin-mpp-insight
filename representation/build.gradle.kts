//@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")
// fixme remove this suppression

plugins {
    kotlin("js")
    kotlin("plugin.serialization")
}

kotlin.target {
    browser({ webpackTask { this.inputs.files(kotlin.target.compilations["main"].output.allOutputs) } })

    compilations.getByName("main") {
        kotlinOptions.sourceMapEmbedSources = "always"
    }
}

kotlin.sourceSets.getByName("main") {
    dependencies {
        implementation(project(":model"))

        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains:kotlin-styled:1.0.0-pre.73-kotlin-1.3.40")
        implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.11.1")
        implementation(npm("vis", "4.21.0"))
//        implementation(npm("@types/vis", "4.19.0"))
    }
}