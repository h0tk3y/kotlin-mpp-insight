plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    `maven-publish`
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(kotlin("stdlib-common"))
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.11.1")
        }
    }

    jvm {
        compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
            }
        }
    }

    js {
        browser()

        compilations["main"].apply {
            defaultSourceSet.dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.11.1")
            }
        }
    }
}

publishing {
    repositories {
        maven("$rootDir/build/repo") {
            name = "temp"
        }
    }
}