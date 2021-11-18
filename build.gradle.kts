plugins {
    kotlin("multiplatform") version("1.6.0")
    id("io.kotest.multiplatform") version("5.0.0.6")
}

repositories {
    mavenCentral()
}

kotlin {
    targets {
        linuxX64()

        mingwX64()

        macosX64()
        macosArm64()
    }

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("io.kotest:kotest-assertions-core:5.0.0.RC")
                implementation("io.kotest:kotest-framework-api:5.0.0.RC")
                implementation("io.kotest:kotest-framework-engine:5.0.0.RC")
            }
        }

        val nativeTest by creating {
            dependsOn(commonTest)
        }

        val macosX64Test by getting {
            dependsOn(nativeTest)
        }

        val macosArm64Test by getting {
            dependsOn(nativeTest)
        }

        val mingwX64Test by getting {
            dependsOn(nativeTest)
        }

        val linuxX64Test by getting {
            dependsOn(nativeTest)
        }
    }
}
