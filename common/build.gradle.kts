plugins {
    kotlin("multiplatform")
    id("com.android.library")
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
                implementation(project(":entities"))
//        implementation(Deps.Coroutines.common)
//        implementation(Deps.kotlinxDateTime)
//        implementation(Deps.koinCore)
//        implementation(Deps.kermit)
            }
        }

        val commonTest by getting {
            dependencies {

            }
        }

        val androidMain by getting {
            dependencies {
//        implementation(Deps.Coroutines.android)
            }
        }

        val androidTest by getting {
            dependencies {
            }
        }

        val iosMain by getting {
            dependencies {
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

