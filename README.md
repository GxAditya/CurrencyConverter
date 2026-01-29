# Currency Converter

A simple and efficient Android application for converting between different currencies in real-time using the ExchangeRate-API.

## Description

Currency Converter is an Android application built with Kotlin that allows users to convert amounts between various world currencies. The app features a clean and intuitive user interface with support for over 160 different currencies worldwide.

## Features

- Real-time currency conversion using live exchange rates
- Support for 160+ world currencies
- Simple and intuitive user interface
- Dropdown selection for base and target currencies
- Instant conversion results
- Network-based API integration

## Technologies Used

- **Language**: Kotlin
- **Platform**: Android
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34
- **Architecture**: Android SDK
- **Libraries**:
  - AndroidX Core KTX
  - AndroidX AppCompat
  - Material Design Components
  - Retrofit 2 (for API calls)
  - Gson Converter (for JSON parsing)
  - Lifecycle Runtime KTX

## Prerequisites

- Android Studio (latest version recommended)
- Android SDK API 24 or higher
- Internet connection (for API calls)
- Gradle 8.0 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/GxAditya/CurrencyConverter.git
   ```

2. Open the project in Android Studio:
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned repository folder
   - Click "OK"

3. Wait for Gradle to sync and download dependencies

4. Build the project:
   - Click on "Build" in the menu
   - Select "Make Project" or press Ctrl+F9 (Cmd+F9 on Mac)

5. Run the application:
   - Connect an Android device or start an emulator
   - Click the "Run" button or press Shift+F10 (Ctrl+R on Mac)

## Usage

1. Launch the Currency Converter app on your Android device
2. Enter the amount you want to convert in the input field
3. Select your base currency from the first dropdown menu
4. Select your target currency from the second dropdown menu
5. Tap the "Convert" button
6. View the converted amount displayed on the screen

## API Information

This application uses the [ExchangeRate-API](https://www.exchangerate-api.com/) to fetch real-time exchange rates. The API provides accurate and up-to-date currency conversion rates for over 160 currencies.

**Note**: The API key is currently embedded in the source code. For production use, it is recommended to:
- Store API keys securely
- Use environment variables or a secure configuration file
- Implement proper API key management

## Supported Currencies

The app supports major world currencies including but not limited to:
- USD (US Dollar)
- EUR (Euro)
- GBP (British Pound)
- JPY (Japanese Yen)
- CNY (Chinese Yuan)
- INR (Indian Rupee)
- AUD (Australian Dollar)
- CAD (Canadian Dollar)
- And 150+ more currencies

## Project Structure

```
CurrencyConverter/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/currencyconverter/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── CurrencyApiService.kt
│   │   │   │   └── ConversionResponce.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── values/
│   │   │   │   └── ...
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Building for Release

To create a release build:

1. Open the project in Android Studio
2. Navigate to "Build" > "Generate Signed Bundle / APK"
3. Select "APK" or "Android App Bundle"
4. Follow the wizard to sign your app
5. Choose "release" as the build variant
6. Click "Finish" to generate the release build

## Contributing

Contributions are welcome! If you'd like to contribute to this project:

1. Fork the repository
2. Create a new branch for your feature
3. Make your changes
4. Test thoroughly
5. Submit a pull request with a clear description of your changes

## License

This project is available for educational and personal use. Please check with the repository owner for specific licensing terms.

## Contact

For questions or feedback, please open an issue on the GitHub repository.

## Acknowledgments

- ExchangeRate-API for providing the currency conversion data
- Android development community for the excellent libraries and tools
