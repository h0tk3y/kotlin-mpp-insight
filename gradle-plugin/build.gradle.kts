import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `java-gradle-plugin`
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly(gradleApi())
    compileOnly(kotlin("gradle-plugin", "1.3-SNAPSHOT"))

    implementation(project(":model"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.6.12")
    implementation("org.jetbrains:kotlin-css-jvm:1.0.0-pre.71-kotlin-1.3.31")
}

sourceSets.main {
    resources.srcDir(files(Callable {
        val browserWebpack by project(":representation").tasks.withType(KotlinWebpack::class)
        val outputDir = browserWebpack.outputPath
        println(outputDir)
        files(outputDir).builtBy(browserWebpack)
    }))
}

group = "com.h0tk3y.kotlin.mpp.insight"
version = "1.0-SNAPSHOT"

gradlePlugin {
    val kotlinMppInsight by plugins.creating {
        id = "$group"
        implementationClass = "${id}.KotlinMppInsightPlugin"
    }
}