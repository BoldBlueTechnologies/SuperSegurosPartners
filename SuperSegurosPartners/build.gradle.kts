import org.gradle.api.JavaVersion.VERSION_1_8
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

val ApiPropertiesFile = rootProject.file("apikey.properties")
val apiProperties = Properties()
apiProperties.load(FileInputStream(ApiPropertiesFile))

android {
    namespace = "com.app.boldblue.superseguros.partners"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            buildConfigField("String", "apipartnersSuper", "\"${apiProperties["apipartnersSuper"]}\"")
            buildConfigField("String", "photosSuper", "\"${apiProperties["photosSuper"]}\"")
            buildConfigField("String", "tokenSuper", "\"${apiProperties["tokenSuper"]}\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "apipartnersSuper", "\"${apiProperties["apipartnersSuperDev"]}\"")
            buildConfigField("String", "photosSuper", "\"${apiProperties["photosSuperDev"]}\"")
            buildConfigField("String", "tokenSuper", "\"${apiProperties["tokenSuperDev"]}\"")

            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        buildConfig = true
    }
}

dependencies {
    implementation (libs.picasso)
    implementation (libs.converter.gson)
    implementation (libs.retrofit)
    implementation (libs.converter.scalars)
    implementation (libs.android.async.http)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}