plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.firstapp"//when uploading to google play change
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.firstapp"
        minSdk = 24     // base version on which the app will run
        targetSdk = 36  // device target
        versionCode = 1  // G play to track application release
        versionName = "1.0" // change log: changes in each version

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // automated UI Test
    }

    buildTypes {
        release { // triggers when you sign the app
            isMinifyEnabled = false // removes unsed code.
            proguardFiles( // avoid reverse engineering ; hacking to APK
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            // by default app is in debug mode
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}