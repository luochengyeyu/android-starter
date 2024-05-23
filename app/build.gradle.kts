plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.kapt)
    //alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.zy.starter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zy.starter"
        minSdk = 23
        targetSdk = 34
        // 1_02_01 => v1.2.1
        // 1_10_12 => v1.10.12
        // 10_01_01 => v10.1.1
        versionCode = 10000
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
        buildConfig = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    // 官方库
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.okhttp)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // 依赖注入库 https://dagger.dev/hilt/
    implementation(libs.hilt.android)
    implementation(libs.xui)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    kapt(libs.hilt.compiler)
    //ksp(libs.hilt.compiler)
    // 三方库
    // https://dylancaicoding.github.io/ViewBindingKTX
    //implementation(libs.viewbinding.ktx)
    implementation(libs.viewbinding.base)
    // 状态布局 https://dylancaicoding.github.io/LoadingStateView
    implementation(libs.loadingstateview.ktx)
    // Kotlin工具库 https://dylancaicoding.github.io/Longan
    implementation(libs.longan)
    // 图片加载库 https://github.com/coil-kt/coil
    implementation(libs.coil)
    // 沉浸式状态栏 https://github.com/Zackratos/UltimateBarX
    implementation(libs.ultimatebarx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}