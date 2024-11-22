plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pokemon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokemon"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
}

dependencies {
    // Dependencias de Android y Material Design
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Dependencias de pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Glide para manejar imágenes
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // Dependencias para LiveData y ViewModel (Jetpack)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // Última versión
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // Última versión
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Coroutines (si decides usarlas en el futuro con ViewModel)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
