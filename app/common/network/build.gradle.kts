plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.news.network"
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
}

dependencies {
    implementation(Retrofit.retrofitLib)
    implementation(Retrofit.retrofitConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.interceptor)
    implementation(Koin.koinAndroid)
    implementation(project(mapOf("path" to Modules.models)))

    testImplementation(Tests.jUnitTests)
    testImplementation(Tests.jUnitExt)
    testImplementation(Tests.mockk)
    testImplementation(Tests.coreTesting)
    androidTestImplementation(Tests.jUnit4)
    testImplementation(Tests.koinTest)
}