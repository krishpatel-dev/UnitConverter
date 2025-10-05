🧮 Unit Converter

A **simple, intuitive, and accurate Unit Converter app** that allows users to convert between various units of measurement such as **Length, Weight, Temperature, Volume, and more**.  
Built to be fast, lightweight, and beginner-friendly — perfect for learning unit conversion logic and app development basics.


✨ Features

- 🔢 **Multiple Conversion Categories**
  - Length (Meter ↔ Feet, Kilometer ↔ Mile, etc.)
  - Weight (Kilogram ↔ Pound, Gram ↔ Ounce, etc.)
  - Temperature (Celsius ↔ Fahrenheit ↔ Kelvin)
  - Volume (Liter ↔ Milliliter ↔ Gallon)
  - Time (Seconds ↔ Minutes ↔ Hours)

- ⚡ **Instant Conversion**
  - Converts values in real-time as you type.

- 🧭 **User-Friendly Interface**
  - Simple dropdowns and input fields.
  - Clean layout with minimal design.

- 💾 **Lightweight and Offline**
  - Runs without internet access once built.
  - No unnecessary dependencies.

- 🔧 **Easily Extendable**
  - Add new units or categories with just a few lines of code.

🛠 Tech Stack
```
| Component | Technology Used |
|------------|-----------------|
| **Language** | Kotlin |
| **Platform** | Android |
| **UI Design** | XML Layouts / Material Design 3 |
| **Logic** | Custom Conversion Formulas |
| **IDE** | Android Studio |
| **Gradle** | Kotlin DSL (build.gradle.kts) |
```

📂 Project Structure

```
📁 UnitConverter
│
├── 📁 app # Main Android app module
│ ├── 📁 src
│ │ ├── 📁 main
│ │ │ ├── 📁 java/... # Kotlin source files (activities, adapters, logic)
│ │ │ ├── 📁 res # Layouts, drawables, values, themes
│ │ │ └── 📄 AndroidManifest.xml
│ │ └── 📁 test # Unit test classes
│ │
│ └── 📄 build.gradle.kts # App-level Gradle configuration
│
├── 📁 gradle # Gradle wrapper files
│ └── 📄 wrapper.properties
│
├── 📄 build.gradle.kts # Project-level Gradle configuration
├── 📄 settings.gradle.kts # Gradle settings file
├── 📄 gradlew # Gradle wrapper (Unix)
├── 📄 gradlew.bat # Gradle wrapper (Windows)
└── 📄 README.md # Project documentation
```


🚀 Getting Started

1. Clone the Repository
Use Git to clone the project locally:
```bash```
git clone https://github.com/krishpatel-dev/UnitConverter.git

2. Open in Android Studio

Launch Android Studio
Click on “Open an existing project”
Select the cloned folder
Wait for Gradle to sync (it may take a few moments)

3. Build and Run

Connect your Android device or start an emulator
Click Run ▶ to build and install the app
The Unit Converter will launch automatically

🧠 How It Works

User selects the unit type (e.g., Length, Weight, Temperature).
Enters the value to convert.
Chooses From and To units from dropdown menus.
The app calculates the converted result instantly using the relevant formula.
Example (Temperature Conversion): 
Fahrenheit = (Celsius × 9/5) + 32
Kelvin = Celsius + 273.15

You can easily add new conversions by defining new conversion logic inside the respective category file.

🧩 Adding a New Conversion Type

Go to your logic file (e.g. ConverterUtils.kt).

Create a new function like:
```
fun convertSpeed(value: Double, fromUnit: String, toUnit: String): Double {
    return when (fromUnit to toUnit) {
        "m/s" to "km/h" -> value * 3.6
        "km/h" to "m/s" -> value / 3.6
        else -> value
    }
}
```

Add the new category to your dropdown spinner in the UI.

Done — your app now supports speed conversion!

🧪 Testing

You can write test cases in src/test using JUnit.

Example test snippet:
```
@Test
fun testCelsiusToFahrenheit() {
    val result = convertTemperature(0.0, "Celsius", "Fahrenheit")
    assertEquals(32.0, result, 0.001)
}
```
