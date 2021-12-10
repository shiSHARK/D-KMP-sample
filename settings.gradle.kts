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
include(":featurecore")
include(":persistence")
include(":coreinterfaces")
include(":shared")
