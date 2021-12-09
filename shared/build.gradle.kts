import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

group = "com.fieldontrack.kmm"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android ()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlin.time.ExperimentalTime")
                useExperimentalAnnotation("com.russhwolf.settings.ExperimentalSettingsImplementation")            }
        }
        val commonMain by getting {
            dependencies {
                api(project(":entities"))
                implementation(project(":persistence"))
                api(project(":coreinterfaces"))
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
                implementation("io.ktor:ktor-client-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
                implementation("com.russhwolf:multiplatform-settings-no-arg:0.7.7")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("com.russhwolf:multiplatform-settings-test:0.7.7")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:${Versions.ktor}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
            }
        }
        val iosTest by getting
    }

    // Configure the framework which is generated internally by cocoapods plugin
    targets.withType<KotlinNativeTarget> {
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            isStatic = false // SwiftUI preview requires dynamic framework
            export(project(":entities"))
//            export(project(":persistence"))
            export(project(":coreinterfaces"))
//            export(project(":kmm:core:core-common"))
//            export(project(":kmm:core:core-ios"))
//            export(project(":kmm:todos:todos-list-api"))
//            export(project(":kmm:todos:todos-count-api"))
            transitiveExport = true
        }
    }
}

android {
    compileSdk = Versions.compile_sdk
    buildToolsVersion = Versions.build_tools
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)