pluginManagement {
    repositories {
        mavenLocal()
        maven("https://kotlin.bintray.com/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.h0tk3y.kotlin.mpp.insight") {
                useModule("com.h0tk3y.kotlin.mpp.insight:gradle-plugin:0.1")
            }
        }
    }
}

includeBuild("..") {
    dependencySubstitution {
        substitute(module("com.h0tk3y.kotlin.mpp.insight:gradle-plugin")).with(project(":gradle-plugin"))
    }
}