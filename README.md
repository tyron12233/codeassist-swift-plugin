# CodeAssist Swift plugin

A plugin for [CodeAssist](https://github.com/tyron12233/CodeAssist), shipped as its own Android app. Install it
next to CodeAssist and the IDE picks it up (Plugins > Get plugins lists the released builds).

It compiles against the CodeAssist plugin SPI, which [JitPack](https://jitpack.io/#tyron12233/CodeAssist) builds from
a CodeAssist release tag (`codeassistSpi` in `gradle/libs.versions.toml`).

## Build

```
./gradlew assembleDebug
```

The toolchain the plugin carries is built or fetched by the scripts in `tools/` (see the README there). Without it
the APK still builds and installs, and reports that it has no toolchain for the device.

## Release

Publishing a GitHub release tagged `v<version>` runs the release workflow in `.github/workflows`, which builds a
signed APK per ABI and attaches it to that release.

History before the move lives in the CodeAssist repository under `samples/swift-plugin`.
