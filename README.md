# EchoJournal 🎙️✨

EchoJournal is a modern, privacy-focused Android audio journaling application. It allows users to record voice notes ("Echoes"), attach moods and topic tags, visualize audio waveforms, and track their emotional journey through an intuitive, timeline-based interface.

---

## 🌟 Key Features

- **🎙️ Voice Recording & Playback:**
  - High-quality audio recording with real-time amplitude tracking and wave visualization.
  - Interactive playback bar with variable playback speeds (1x, 1.5x, 2x) and seek functionality.
  - Background & foreground audio handling.

- **🎭 Mood & Topic Tracking:**
  - Associate entries with distinct mood states (*Excited*, *Peaceful*, *Neutral*, *Sad*, *Stressed*).
  - Add hashtag topics to organize thoughts and journal entries.
  - Filter your feed dynamically by mood and topic tags.

- **📅 Timeline View:**
  - Dynamic daily timeline grouping all your voice entries by date.
  - Expandable transcripts/descriptions and interactive audio cards.

- **📲 Home Screen App Widget:**
  - Built with **Jetpack Glance** for one-tap quick recording straight from the home screen.

- **⚙️ Customizable Settings:**
  - Set default topics and default mood choices using Jetpack DataStore preferences.

---

## 🏗️ Architecture & Tech Stack

EchoJournal follows **Clean Architecture** principles and **Unidirectional Data Flow (UDF / MVI)**.

```
app/src/main/java/com/kabi/echojournal/
├── app/                      # App entry point, Koin DI setup, Navigation, Widget
│   ├── di/
│   ├── navigation/
│   └── widget/               # Glance App Widget (RecordEchoWidget)
├── core/                     # Shared core components
│   ├── database/             # Room DB, Entities, DAOs, Type Converters
│   └── presentation/         # Custom Material 3 Design System (Buttons, Chips, Theme)
└── echos/                    # Feature module
    ├── data/                 # Audio player/recorder impl, DataStore, Repositories
    ├── domain/               # Domain models, Interfaces, Business logic
    └── presentation/         # Jetpack Compose UI (Screens, ViewModels, States, Actions)
```

### 💻 Technologies & Libraries

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3
- **Dependency Injection:** [Koin](https://insert-koin.io/)
- **Database:** [Room Database](https://developer.android.com/training/data-storage/room) with KSP
- **Asynchronous & Concurrency:** Kotlin Coroutines & Flow
- **Data Persistence:** [Jetpack DataStore](https://developer.android.com/topic/libraries/architecture/datastore)
- **App Widget:** [Jetpack Glance](https://developer.android.com/jetpack/compose/glance)
- **Navigation:** Type-safe Compose Navigation with Kotlinx Serialization
- **Media:** Android MediaRecorder & MediaPlayer API integrations
- **Core Library Desugaring:** Enabled for backward-compatible `java.time` APIs

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio:** Ladybug (2024.2+) or newer.
- **JDK:** Java 11 or higher.
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 36 (Android 15)

### Building the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/KabiZoro/EchoJournal.git
   cd EchoJournal
   ```

2. **Open in Android Studio:**
   - Select **Open an Existing Project** and choose the `EchoJournal` directory.
   - Wait for Gradle sync to complete.

3. **Run the App:**
   - Select the `:app` configuration and launch on an emulator or physical Android device.

---

## 📸 Screen Overview

| Screen | Description |
| :--- | :--- |
| **Echoes Feed** | Main timeline listing all voice entries grouped by day with filtering chips. |
| **Create Echo** | Recording interface with live amplitude visualization, topic assignment, and mood selector. |
| **Settings** | Configure default topic tags and pre-selected mood states. |
| **App Widget** | Quick-action home screen widget for immediate voice recording. |

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/my-new-feature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/my-new-feature`
5. Open a **Pull Request**.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
