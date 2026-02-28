
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

//    alias(libs.plugins.kotlin.serialization)

    kotlin("plugin.serialization") version "2.0.21"
    id("com.google.devtools.ksp") version "2.0.21-1.0.27"
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.gms.google.services)

}

android {
    namespace = "com.example.whatsappclone"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.whatsappclone"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:-deprecation")
    }



    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


    val nav_version = "2.8.5"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")
    // kotlin serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    // HILT
    implementation("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.7.0")


}