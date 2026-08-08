import org.jetbrains.dokka.gradle.engine.parameters.KotlinPlatform
import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
}

val ver = "17-rc1"
version = ver
group = "com.github.aniyomiorg"

android {
    compileSdk = 37
    namespace = "eu.kanade.tachiyomi.animeextensions"

    defaultConfig {
        minSdk = 24
    }

    val javaVersion = JavaVersion.VERSION_17
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.okhttp)
    compileOnly(libs.jsoup)
    compileOnly(libs.nanohttpd)
    compileOnly(libs.injekt.core)
    compileOnly(libs.coroutines)
    compileOnly(libs.kotlin.json)
    compileOnly(libs.kotlin.json.okio)
}

dokka {
    dokkaPublications.html {
        moduleName.set("extensions-lib")
        moduleVersion.set(ver)
        basePublicationsDirectory.set(layout.buildDirectory.dir("docs"))
        dokkaSourceSets.configureEach {
            includes.from("Module.md")

            // Temporary workaround for https://github.com/Kotlin/dokka/issues/2876.
            analysisPlatform.set(KotlinPlatform.JVM)

            perPackageOption {
                matchingRegex.set("android.content")
                suppress.set(true)
            }

            documentedVisibilities(VisibilityModifier.Public, VisibilityModifier.Protected)

            externalDocumentationLinks {
                create("okhttp5") {
                    url("https://square.github.io/okhttp/5.x/")
                }

                create("jsoup") {
                    url("https://jsoup.org/apidocs/")
                    packageListUrl("https://jsoup.org/apidocs/element-list")
                }
            }

            val packageRoot = projectDir.resolve("src/main/java/eu/kanade/tachiyomi/")
            sourceLink {
                localDirectory.set(packageRoot.resolve("util/JsonExtensions.kt"))
                remoteUrl("https://github.com/aniyomiorg/extensions-lib/tree/main/library/src/main/java/eu/kanade/tachiyomi/util/JsonExtensions.kt")
                remoteLineSuffix.set("#L")
            }

            sourceLink {
                localDirectory.set(packageRoot.resolve("util/CoroutinesExtensions.kt"))
                remoteUrl("https://github.com/aniyomiorg/extensions-lib/tree/main/library/src/main/java/eu/kanade/tachiyomi/util/CoroutinesExtensions.kt")
                remoteLineSuffix.set("#L")
            }

            sourceLink {
                localDirectory.set(packageRoot.resolve("animesource/"))
                remoteUrl("https://github.com/aniyomiorg/aniyomi/tree/main/source-api/src/commonMain/kotlin/eu/kanade/tachiyomi/animesource/")
                // The line number is wrong, so we're not going to highlight it.
                remoteLineSuffix.set("#")
            }

            sourceLink {
                localDirectory.set(packageRoot.resolve("network/"))
                remoteUrl("https://github.com/aniyomiorg/aniyomi/tree/main/core/common/src/main/java/eu/kanade/tachiyomi/network/")
                remoteLineSuffix.set("#") // Same as before.
            }
        }
    }
}

mavenPublishing {
    coordinates("com.github.aniyomiorg", "extensions-lib", "17-rc1")
}
