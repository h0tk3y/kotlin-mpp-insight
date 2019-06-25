pluginManagement {
    repositories {
        mavenLocal()
        maven("https://kotlin.bintray.com/kotlin-dev")

        @Suppress("UnstableApiUsage")
        gradlePluginPortal()
    }
}

rootProject.name = "kotlin-mpp-insight"

include("model", "representation", "gradle-plugin")

enableFeaturePreview("GRADLE_METADATA")