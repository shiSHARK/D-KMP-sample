
group = "com.fieldontrack.kmm"
version = "1.0-SNAPSHOT"

plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
//    implementation(project(":composables"))
    implementation(project(":shared"))
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.lifecycle:lifecycle-process:2.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")


//    implementation(compose.runtime)
    implementation("androidx.compose.foundation:foundation:${Versions.compose}")
//    implementation(compose.ui)
    implementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.compose.material:material-icons-core:${Versions.compose}")
}

android {
    compileSdk = Versions.compile_sdk
    buildToolsVersion = Versions.build_tools
    defaultConfig {
        applicationId = "com.fieldontrack.kmm"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            // Enables code shrinking, obfuscation, and optimization for only
            // your project's release build type.
            isMinifyEnabled = true
            // Enables resource shrinking, which is performed by the
            // Android Gradle plugin.
            isShrinkResources = true
            // Includes the default ProGuard rules files that are packaged with
            // the Android Gradle plugin. To learn more, go to the section about
            // R8 configuration files. */
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}