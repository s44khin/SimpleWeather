plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "dev.s44khin.simpleweather"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "dev.s44khin.simpleweather"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = libs.versions.version.code.get().toInt()
        versionName = libs.versions.version.name.get()
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.activity)
    implementation(libs.compose.foundation)
    implementation(libs.compose.navigation)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)

    // Project
    implementation(project(":common:api"))
    implementation(project(":common:impl"))
    implementation(project(":core:base"))
    implementation(project(":core:navigation:api"))
    implementation(project(":core:navigation:impl"))
    implementation(project(":core:network"))
    implementation(project(":settings:api"))
    implementation(project(":settings:impl"))
    implementation(project(":today:api"))
    implementation(project(":today:impl"))
    implementation(project(":uikit"))
    implementation(project(":utils"))
    implementation(project(":week:api"))
    implementation(project(":week:impl"))

    // Tests
    testImplementation(libs.koin.test)
    testImplementation(libs.ktor.client.android)
    testImplementation(libs.testng)
}