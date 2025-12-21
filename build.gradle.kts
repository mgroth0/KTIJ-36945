@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins {
    kotlin("multiplatform")
    id("com.android.kotlin.multiplatform.library")
}

allprojects {
    plugins.apply("org.jetbrains.kotlin.multiplatform")
    plugins.apply("com.android.kotlin.multiplatform.library")
    repositories {
        mavenCentral()
        google()
    }

    plugins.withId("org.jetbrains.kotlin.multiplatform") {
        plugins.withId("com.android.kotlin.multiplatform.library") {
            kotlin {
                applyHierarchyTemplate {
                    common {
                        group("commonJvmAndroid") {
                            withJvm()
                            withCompilations {
                                /*
                                Used to check if instance is `KotlinAndroidTarget` back when we used `com.android.library`, but it no longer works with `com.android.kotlin.multiplatform.library`:
                                    `it is KotlinAndroidTarget`

                                    the replacement below is a best guess at what to do with the new plugin

                                 */
                                it.platformType == KotlinPlatformType.androidJvm
                                    || it.target.targetName == "android"
                            }
                        }
                    }
                }
                jvm()
                androidLibrary {
                    namespace = project.name
                    compileSdk = 36
                }
            }
        }
    }
}

kotlin {
    sourceSets.getByName("commonJvmAndroidMain") {
        dependencies {
            implementation(project(":sub"))
        }
    }
}
