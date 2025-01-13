import org.gradle.api.JavaVersion.VERSION_11
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
    id("kotlin-parcelize")
}

publishing{
    publications {
        register<MavenPublication>("jitpack"){
            groupId = "com.github.BoldBlueTechnologies"
            artifactId = "SuperSegurosPartners"
            version = "0.1.10"
            artifact(tasks.register("myTask") {
                outputs.file(layout.buildDirectory.file("outputs/aar/SuperSegurosPartners-release.aar"))
            })
        }
    }
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
        sourceCompatibility = VERSION_11
        targetCompatibility = VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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