plugins {
    kotlin("multiplatform").version("1.3.50-dev-1478").apply(false)
    kotlin("plugin.serialization").version("1.3.50-dev-1478").apply(false)
}

allprojects {
    group = "com.h0tk3y.kotlin.mpp.insight"
    version = "0.1"

    repositories {
        jcenter()
        mavenLocal()
        maven("https://kotlin.bintray.com/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
    }
}