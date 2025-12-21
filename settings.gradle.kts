pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform")  version "2.3.0"
        id("com.android.kotlin.multiplatform.library") version "8.12.2"
    }
}

include(":sub")