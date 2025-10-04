plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.storyidea2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.storyidea2"
        // runtergesetzt: ab Android 5.0 (API 21) läuft es
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // falls du VectorDrawables in ImageViews nutzt
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
