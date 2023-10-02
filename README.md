# Fetch Android Project

This is a sample project for displaying items grouped by list ID in an expandable list. Each item can be expanded to view its contents.

## Prerequisites

- Android Studio
- Kotlin plugin for Android Studio

## How to Run

**1. Clone the Repository:**
   ```shell
   git clone https://github.com/catchashu10/FetchAndroidProject.git
  ```
**2. Open the Project in Android Studio:**
    Start Android Studio
    Select “Open an existing Android Studio project”
    Navigate to the cloned project directory and select it.

**3. Run the Application:**
    Run Gradle Sync.
    After the project is opened and indexed, press the green triangular "Run" button at the top of Android Studio, or use the Shift + F10 shortcut to run the project on an emulator or connected Android device.

**4. Build the APK:**
    Go to Build menu
    Select Build Bundle(s) / APK(s)
    Select Build APK(s)


## Features
1. Displays items grouped by list ID in an expandable list.
2. Fetches data from a remote server asynchronously.
3. Filters out items with null or empty names.
4. Sorts the items in ascending order based on their names within each list ID group.
