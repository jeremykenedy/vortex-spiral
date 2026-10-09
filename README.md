<p align="center">
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="art/banner-dark.svg">
        <source media="(prefers-color-scheme: light)" srcset="art/banner-light.svg">
        <img src="art/banner-light.svg" alt="Vortex Spiral animated TV screensaver" width="800">
    </picture>
</p>

<p align="center">Flowing luminous spiral ribbons for Fire TV, Android TV, and Google TV.</p>

<p align="center">
    <a href="https://github.com/jeremykenedy/vortex-spiral/releases"><img src="https://img.shields.io/github/downloads/jeremykenedy/vortex-spiral/total" alt="GitHub release downloads"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/releases"><img src="https://img.shields.io/github/v/release/jeremykenedy/vortex-spiral?label=latest%20release" alt="Latest release"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/ci.yml"><img src="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/ci.yml/badge.svg" alt="Build, tests, and coverage"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/style.yml"><img src="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/style.yml/badge.svg" alt="Code style"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/docs.yml"><img src="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/docs.yml/badge.svg" alt="Documentation checks"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/security.yml"><img src="https://github.com/jeremykenedy/vortex-spiral/actions/workflows/security.yml/badge.svg" alt="Security checks"></a>
    <a href="LICENSE"><img src="https://img.shields.io/badge/License-Apache--2.0-blue.svg" alt="Apache-2.0 license"></a>
    <a href="https://github.com/jeremykenedy"><img src="https://img.shields.io/github/followers/jeremykenedy?label=Follow&style=social" alt="Follow Jeremy Kenedy on GitHub"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral" title="Open the repository and click Star"><img src="https://img.shields.io/badge/Star-this%20repo-yellow?logo=github&style=social" alt="Star this repo"></a>
    <a href="https://github.com/jeremykenedy/vortex-spiral/stargazers"><img src="https://img.shields.io/github/stars/jeremykenedy/vortex-spiral?style=social" alt="Star Vortex Spiral on GitHub"></a>
    <a href="https://github.com/sponsors/jeremykenedy"><img src="https://img.shields.io/badge/Sponsor-jeremykenedy-EA4AAA?logo=githubsponsors&logoColor=white" alt="Sponsor Jeremy Kenedy"></a>
</p>

<p align="center">Show some love by starring this repository on GitHub.</p>

## Table of contents

- [Privacy](#privacy)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Screenshots](#screenshots)
- [Building and testing](#building-and-testing)
- [Documentation](#documentation)
- [Release notes](#release-notes)
- [License](#license)

## Privacy

The app does not request network permission and contains no ads, analytics, telemetry, crash reporting, or tracking code. The spiral ribbons and stars are rendered locally from Canvas primitives. The standalone installer contacts GitHub only after you start an install or update to fetch the current release APK and its checksum; it does not send device or usage data.

## Features

- Continuously turning spiral ribbons with a gently drifting center and twinkling stars.
- Glacial blue, synthwave, neon green, and solar gold color palettes.
- A few, handful, many, or a ton of spiral arms; slow, natural, or fast movement; dim, balanced, or bright glow.
- Tight or open spiral winding, with random selection for each setting or all settings at startup.
- D-pad-friendly settings and a documented settings provider for host applications.
- Native Android DreamService for compatible TV screensaver managers.

## Requirements

- Android 6.0 (API 23) or later.
- A device with Android DreamService screensaver support.
- Android SDK platform 36 and build-tools 36.0.0 for source builds.

Device compatibility statements are limited to the checks in [verification](docs/VERIFICATION.md).

## Installation

Connect the TV with ADB, then run `python3 install.py --serial TV_IP:5555`. The installer downloads the latest signed release, checks its SHA-256, and installs or updates the app. Choose Vortex Spiral in the TV's screensaver settings. For manual install, local builds, removal, and troubleshooting, see [installation](docs/INSTALLATION.md).

## Configuration

Open Vortex Spiral from the TV launcher to change its settings. Options are saved locally and can be read or changed by an authorized host app through the versioned provider. See [configuration](docs/CONFIGURATION.md) for defaults and provider details.

## Screenshots

<p align="center">
    <img src="art/screenshots/vortex-spiral-preview.png" alt="Glacial-blue spiral ribbons winding into a dark center" width="100%">
</p>

<p align="center"><img src="art/screenshots/settings-android-tv.png" alt="Remote-friendly Vortex Spiral settings" width="100%"></p>

This 1920 by 1080 screenshot was captured from the running Vortex Spiral preview activity on an Android TV emulator. The in-app DreamService preview image is generated from the same running scene.

## Building and testing

```bash
bash build.sh
bash test.sh
bash scripts/test-python-coverage.sh
bash scripts/test-coverage.sh
```

The build uses the Android SDK and JDK. It generates a local signing key on the first build; keep the key and password outside the repository for future signed updates. See [building](docs/BUILDING.md), [testing](docs/TESTING.md), and [architecture](docs/ARCHITECTURE.md).

## Documentation

- [Installation, update, and removal](docs/INSTALLATION.md)
- [Configuration and settings provider](docs/CONFIGURATION.md)
- [Building from source](docs/BUILDING.md)
- [Architecture](docs/ARCHITECTURE.md)
- [Testing and coverage](docs/TESTING.md)
- [Device verification](docs/VERIFICATION.md)
- [CI](docs/CI.md)
- [Troubleshooting](docs/TROUBLESHOOTING.md)
- [Release process](docs/RELEASING.md)
- [Changelog](CHANGELOG.md)
- [Contribution guidelines](CONTRIBUTING.md)
- [Security policy](SECURITY.md)

## Release notes

- [Version 1.0.0](docs/releases/v1.0.0.md)

Show some love by starring this repository on GitHub: [Star Vortex Spiral](https://github.com/jeremykenedy/vortex-spiral/stargazers).

## License

Vortex Spiral is licensed under the [Apache License, Version 2.0](LICENSE). See [NOTICE](NOTICE) for project notices.
