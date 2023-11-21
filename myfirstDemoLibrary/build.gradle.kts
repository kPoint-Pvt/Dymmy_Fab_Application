plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "io.github.myfirstdemolibrary"
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

//    namespace 'io.github.geofriendtech.appdatamanager' // Profide final artifact id
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
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
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.example.myfirstdemolibrary"
            artifactId = "myfirstdemolibrary"
            version = "1.0"
            artifact("$buildDir/outputs/aar/myProject.aar")
        }
    }

    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/kPoint-Pvt/Dymmy_Fab_Application")
        }
    }
}


/*publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.example.myfirstdemolibrary"
            artifactId = "myfirstdemolibrary"
            version = "1.0"
//            artifact("$buildDir/outputs/aar/myfirstdemolibrary-release.aar")
            artifact("$buildDir/outputs/aar/myfirstdemolibrary-release.aar")
        }
    }

    repositories {
        maven {
            name = "kPoint-Pvt"
            url = uri("https://maven.pkg.github.com/kPoint-Pvt/Dymmy_Fab_Application")
            credentials {
                username = "kPoint-Pvt"
                password ="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"
            }
        }
    }

}*/
dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
// import publish-package.gradle
apply {
    from("$rootDir/app/publish-package.gradle")
}
