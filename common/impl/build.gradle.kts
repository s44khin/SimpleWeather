plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.s44khin.simpleweather.common"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.navigation)

    // Ktor
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization.kotlinx.json)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)

    // Project
    implementation(project(":common:api"))
    implementation(project(":core:base"))
    implementation(project(":core:navigation:api"))
    implementation(project(":core:network"))
    implementation(project(":uikit"))
    implementation(project(":utils"))
}