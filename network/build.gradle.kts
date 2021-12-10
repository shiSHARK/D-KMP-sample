plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
}

android {
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }

    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

version = "1.0"

kotlin {
    android()
    // Revert to just ios() when gradle plugin can properly resolve it
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    version = "1.1"
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(project(":entities"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
                implementation("io.ktor:ktor-client-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
//        implementation(Deps.Coroutines.common)
//        implementation(Deps.kotlinxDateTime)
//        implementation(Deps.koinCore)
//        implementation(Deps.kermit)
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
            }
        }

        val commonTest by getting {
            dependencies {

            }
        }

        val androidMain by getting {
            dependencies {
//        implementation(Deps.Coroutines.android)
                implementation("io.ktor:ktor-client-android:${Versions.ktor}")
            }
        }

        val androidTest by getting {
            dependencies {
            }
        }

        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
//        implementation(Deps.Coroutines.common) {
//            version {
//                strictly(Versions.coroutines)
//            }
//        }
            }
        }

        val iosTest by getting
    }
}

