# Device verification

This record distinguishes emulator checks from physical device behavior. An emulator launch does not establish vendor screensaver selection, idle activation, physical display composition, or sustained performance.

| Platform | Device and OS | Result |
| --- | --- | --- |
| Android TV emulator | `sdk_google_atv64_arm64`, Android 12/API 31, emulator-5570, 1920 x 1080 | APK installed; preview and settings activities launched; D-pad opened and navigated the density menu; provider schema queried and an external color update was written and read back. Maximum density ran without a visible crash. Install and same-signer update succeeded through the standalone CLI. Two captures 28 seconds apart differed across 64% of pixels, confirming visible animation. |
| Physical Android TV | No device available | Not verified. We are looking for an Android TV owner to test and report model, OS/API, resolution, behavior, and results in the [issue tracker](https://github.com/jeremykenedy/vortex-spiral/issues). |
| Fire TV | Not tested for this release | Not verified. We are looking for a Fire TV owner to test installation, screensaver selection and activation, and remote settings, then report the device model, Fire OS/API, resolution, and results in the [issue tracker](https://github.com/jeremykenedy/vortex-spiral/issues). |
| Google TV | Not tested | Not verified. We are looking for a Google TV owner to run the same checks and report the device model, OS/API, resolution, and results in the [issue tracker](https://github.com/jeremykenedy/vortex-spiral/issues). |

The screenshots at [vortex-spiral-preview.png](screenshots/vortex-spiral-preview.png) and [settings-android-tv.png](screenshots/settings-android-tv.png) are captured from the running emulator activities and opened for visual inspection before publication. The in-app preview is a 384 by 216 derivative of the full scene capture.

Native 4K composition, sustained frame pacing, power use, thermal behavior, and system DreamService activation remain unverified. No physical Fire TV, Android TV, or Google TV hardware was available. We are looking for owners of those devices to test and report model, OS/API, resolution, installation, activation, remote settings, and results in the issue tracker.
