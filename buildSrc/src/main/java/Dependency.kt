object Versions {
    const val androidXCore = "1.12.0"
    const val androidXLifecycle = "2.6.2"
    const val androidXActivityCompose = "1.8.2"
    const val coilCompose = "2.5.0"
    const val androidXComposePlatform = "2023.03.00"
    const val androidNavigation = "2.7.6"
    const val koin = "3.5.0"
    const val jUnit = "4.13.2"
    const val jUnitExt = "1.1.5"
    const val retrofit = "2.9.0"
    const val okHttp = "4.12.0"
    const val mockk = "1.13.5"
    const val coroutines = "1.6.4"
    const val coreTesting = "2.2.0"
}


object AndroidX {
    const val core = "androidx.core:core-ktx:${Versions.androidXCore}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidXLifecycle}"
    const val activity = "androidx.activity:activity-compose:${Versions.androidXActivityCompose}"
    const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.androidNavigation}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.androidNavigation}"
}

object Compose {
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composePlatformBom = "androidx.compose:compose-bom:${Versions.androidXComposePlatform}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}

object Tests {
    const val jUnitTests = "junit:junit:${Versions.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val jUnit4 = "androidx.compose.ui:ui-test-junit4"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val coroutinesTests = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
}

object Retrofit {
    const val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

}

object Modules {
    const val newsDetails = ":app:features:newsdetails"
    const val newsList = ":app:features:newslist"
    const val network = ":app:common:network"
    const val news = ":app:data:news"
    const val models = ":app:common:models"
    const val utils = ":app:common:utils"
    const val ui = ":app:common:ui"
}
