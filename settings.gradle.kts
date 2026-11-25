// The APK file names come from this (`swift-plugin-<abi>-release.apk`), which the release workflow expects.
rootProject.name = "swift-plugin"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // -PcodeassistSpiLocal=true resolves the plugin SPI from ~/.m2 first: in a CodeAssist checkout,
        // `JITPACK=true GROUP=com.github.tyron12233 ARTIFACT=CodeAssist VERSION=<tag> ./gradlew publishToMavenLocal`
        // publishes it under the same coordinates JitPack serves.
        if (providers.gradleProperty("codeassistSpiLocal").orNull == "true") {
            mavenLocal { content { includeGroup("com.github.tyron12233.CodeAssist") } }
        }
        mavenCentral()
        google()
        // The CodeAssist plugin SPI, built by JitPack from a CodeAssist release tag.
        maven("https://jitpack.io") {
            content { includeGroup("com.github.tyron12233.CodeAssist") }
        }
    }
}
