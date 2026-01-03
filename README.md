# Cloudstream Extensions Repository

This is a template repository for building Cloudstream 3 extensions.

## Getting Started

1.  **Clone this repository** to your local machine.
2.  **Open in Android Studio** or VS Code.
3.  **Explore the ExampleProvider**: Check `ExampleProvider/src/main/kotlin/com/example/exampleprovider/ExampleProvider.kt`.

## Building

To build your extensions manually:

```bash
# Windows
.\gradlew.bat make

# Linux/Mac
./gradlew make
```

This will generate `.cs3` files in the build output.

## Adding a New Provider

1.  Copy the `ExampleProvider` folder and rename it (e.g., `MyNewProvider`).
2.  Rename the `src/main/kotlin` package path to match your new provider (e.g., `com.example.mynewprovider`).
3.  Edit `build.gradle.kts` in the new folder to update the description and name.
4.  Implement your provider logic in the Kotlin file.
5.  Cloudstream's Gradle plugin will automatically detect the new module (thanks to `settings.gradle.kts`).

## Deploying to Cloudstream

To use these extensions in the Cloudstream app:

1.  **Push to GitHub**: Push this repository to a new GitHub repo.
2.  **Enable Actions**: Go to Settings > Actions > General and verify actions are enabled.
3.  **Check Builds**: The provided `.github/workflows/build.yml` will run on push.
    *   *Note*: The current workflow uploads artifacts. To host a repository properly, you usually need a workflow that commits the generated `plugins.json` and `.cs3` files to a specific branch (like `builds`), or use a release system.
    *   See [Cloudstream Documentation](https://recloudstream.github.io/csdocs/) for advanced deployment details.

## Testing Locally

You can deploy directly to your device if ADB is connected:

```bash
.\gradlew.bat :ExampleProvider:deployWithAdb
```
