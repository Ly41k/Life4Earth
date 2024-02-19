rootProject.name = "Life4Earth"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")
include(":common:auth:api")
include(":common:auth:compose")
include(":common:auth:data")
include(":common:auth:domain")
include(":common:auth:presentation")
include(":common:core")
include(":common:umbrella")
include(":common:splash:compose")
include(":common:onboarding:compose")
include(":common:onboarding:presentation")
include(":common:discover:compose")
include(":common:discover:presentation")
include(":common:main:compose")
include(":common:messages:compose")
include(":common:messages:presentation")