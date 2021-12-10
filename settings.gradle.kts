pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "fieldontrack-multiplatform-mobile"

include(":androidApp")
include(":entities")
include(":featureCore")
include(":persistence")
include(":common")
include(":network")
include(":navigation")
include(":sampleFeature")
include(":shared")
