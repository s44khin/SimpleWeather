pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Simple Weather"
include(":app")
include(":common:api")
include(":common:impl")
include(":core:base")
include(":core:navigation:api")
include(":core:navigation:impl")
include(":core:network")
include(":core:resources")
include(":settings:api")
include(":settings:impl")
include(":today:api")
include(":today:impl")
include(":uikit")
include(":utils")
include(":week:api")
include(":week:impl")
