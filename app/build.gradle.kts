import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.ai.assistance.quro"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ai.assistance.quro"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15" // 兼容 Kotlin 2.0.21
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/DEPENDENCIES"
            excludes += "/META-INF/LICENSE"
            excludes += "/META-INF/LICENSE.txt"
            excludes += "/META-INF/NOTICE"
            excludes += "/META-INF/NOTICE.txt"
        }
    }

    androidResources {
        noCompress += listOf("onnx", "txt", "ncnn", "param", "bin", "gz", "crt", "so")
    }
}

dependencies {
    // 核心模块依赖 (根据原项目结构推断)
    implementation(project(":aidl-aci-core"))
    implementation(project(":aidl-aci-browser"))
    implementation(project(":lib_aci"))
    implementation(project(":terminal-core"))
    implementation(project(":cap_main"))
    implementation(project(":llama"))
    implementation(project(":mnn"))
    implementation(project(":mini-app-sdk"))
    implementation(project(":plugin-contract"))
    implementation(project(":plugin-engine"))
    implementation(project(":plugin-devkit"))
    implementation(project(":genuiagent-sdk"))
    implementation(project(":kaleidobox"))

    // AndroidX 基础
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.documentfile)
    implementation(libs.material)

    // 生命周期与 Compose
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.material.icons.extended)
    debugImplementation(libs.compose.ui.tooling)

    // 网络与协程
    implementation(libs.okhttp)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // 数据库与序列化
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.org.json)

    // 其他依赖
    implementation(libs.zxing.core)
    implementation(libs.eclipse.jgit)
    implementation(libs.bouncycastle.bcpkix)
    implementation(libs.bouncycastle.bcprov)
    implementation(libs.shizuku.api)
    implementation(libs.shizuku.provider)
    implementation(libs.androidx.webkit)
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.facebook.yoga)
    implementation(libs.androidsvg)
    implementation(libs.coil.compose)
    implementation(libs.markwon.core)
    implementation(libs.markwon.ext.tables)
    implementation(libs.markwon.ext.strikethrough)
    implementation(libs.kaml)
}
