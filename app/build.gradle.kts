plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.news.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.news.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(AndroidX.core)
    implementation(AndroidX.lifecycle)
    implementation(AndroidX.activity)

    implementation(Compose.composeUi)
    implementation(Compose.composeUiGraphics)
    implementation(Compose.composeUiToolingPreview)
    implementation(Compose.composeMaterial3)

    implementation(platform(Compose.composePlatformBom))
    implementation(AndroidX.navigationRuntime)
    implementation(AndroidX.navigation)

    implementation(Koin.koinCore)
    implementation(Koin.koinAndroid)
    implementation(Koin.koinCompose)

    implementation(project(mapOf("path" to Modules.newsDetails)))
    implementation(project(mapOf("path" to Modules.newsList)))
    implementation(project(mapOf("path" to Modules.network)))
    implementation(project(mapOf("path" to Modules.news)))

    testImplementation(Tests.jUnitTests)
    testImplementation(Tests.jUnitExt)
    androidTestImplementation(platform(Compose.composePlatformBom))
    androidTestImplementation(Tests.jUnit4)
    debugImplementation(Compose.composeUiTooling)
    debugImplementation(Compose.composeUiTestManifest)
}