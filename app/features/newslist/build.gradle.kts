plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.news.newslist"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(project(mapOf("path" to Modules.network)))
    implementation(project(mapOf("path" to Modules.news)))
    implementation(project(mapOf("path" to Modules.utils)))
    implementation(project(mapOf("path" to Modules.ui)))
    implementation(project(mapOf("path" to Modules.models)))

    testImplementation(Tests.jUnitTests)
    testImplementation(Tests.jUnitExt)
    testImplementation(Tests.mockk)
    testImplementation(Tests.coroutinesTests)
    testImplementation(Tests.coreTesting)
    androidTestImplementation(platform(Compose.composePlatformBom))
    androidTestImplementation(Tests.jUnit4)
    debugImplementation(Compose.composeUiTooling)
    debugImplementation(Compose.composeUiTestManifest)
}