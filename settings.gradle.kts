pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform")  version "2.3.0"
//        id("com.android.kotlin.multiplatform.library") version "8.13.2"
//        id("com.android.kotlin.multiplatform.library") version "9.0.0-alpha06"
        id("com.android.kotlin.multiplatform.library") version "9.0.0"
        id("com.android.library") version "9.0.0"
    }
}

include(":sub")
include(":sub:android")