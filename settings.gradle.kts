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
include(":uikit")
include(":utils")
include(":core:navigation:api")
include(":core:navigation:impl")
include(":core:network")
include(":core:base")
include(":core:resources")
include(":common:api")
include(":common:impl")
include(":week:api")
include(":week:impl")
