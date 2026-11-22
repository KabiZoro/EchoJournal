# EchoJournal 🎙️✨

EchoJournal is a modern, privacy-focused Android audio journaling application. It allows users to record voice notes ("Echoes"), attach moods and topic tags, visualize audio waveforms, and track their emotional journey through an intuitive, timeline-based interface.

All recordings and data remain **100% stored locally on-device**, ensuring complete privacy and security for your personal entries.

---

## 🌟 Core Features

- **🎙️ Voice Recording & Playback:**
  - High-quality audio recording with real-time amplitude tracking and wave visualization.
  - Interactive playback bar supporting variable speeds (1x, 1.5x, 2x) and scrub controls.
  - Reliable foreground and background playback handling.

- **🎭 Mood & Topic Tracking:**
  - Associate entries with distinct mood states (*Excited*, *Peaceful*, *Neutral*, *Sad*, *Stressed*).
  - Add hashtag topics to organize thoughts and journal entries.
  - Dynamically filter the feed by specific moods and topic tags.

- **📅 Timeline View:**
  - Dynamic daily timeline grouping all voice entries chronologically by date.
  - Expandable text descriptions and interactive audio cards.

- **📲 Home Screen App Widget:**
  - Built with **Jetpack Glance** for one-tap quick recording straight from the Android home screen.

- **⚙️ Customizable Settings:**
  - Configure default topic tags and mood preferences using Jetpack DataStore.

---

## 📸 Screenshots & Demo

| Echoes Feed | Create Echo | Settings | App Widget |
| :---: | :---: | :---: | :---: |
| <img src="docs/screenshots/feed.png" width="200" alt="Echoes Feed" /> | <img src="docs/screenshots/create_echo.png" width="200" alt="Create Echo" /> | <img src="docs/screenshots/settings.png" width="200" alt="Settings" /> | <img src="docs/screenshots/widget.png" width="200" alt="App Widget" /> |

*(Place your screenshot images inside `docs/screenshots/` as `feed.png`, `create_echo.png`, `settings.png`, and `widget.png`)*

---

## 🏗️ Architecture & Project Structure

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

---

## 💻 Technologies & Libraries

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3
- **Dependency Injection:** [Koin](https://insert-koin.io/)
- **Database:** [Room Database](https://developer.android.com/training/data-storage/room) with KSP
- **Asynchronous & Concurrency:** Kotlin Coroutines & Flow
- **Data Persistence:** [Jetpack DataStore](https://developer.android.com/topic/libraries/architecture/datastore)
- **App Widget:** [Jetpack Glance](https://developer.android.com/jetpack/compose/glance)
- **Navigation:** Type-safe Compose Navigation with Kotlinx Serialization
- **Media Handling:** Android `MediaRecorder` & `MediaPlayer` APIs
- **Compatibility:** Core Library Desugaring enabled for `java.time` APIs on legacy devices

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio:** Ladybug (2024.2+) or newer
- **JDK:** Java 17 or higher
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 36 (Android 16)

### Building the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/KabiZoro/EchoJournal.git
   cd EchoJournal
   ```

2. **Open in Android Studio:**
   - Select **Open an Existing Project** and choose the `EchoJournal` directory.
   - Allow Gradle to sync dependencies.

3. **Run the App:**
   - Select the `:app` run configuration and launch on an emulator or physical Android device.

---

## 🔒 Security & Privacy

- **100% On-Device Storage:** All voice notes, descriptions, and metadata are saved locally in the app's internal storage and Room Database.
- **Zero Cloud Tracking:** No voice data, personal metadata, or analytics are uploaded to external cloud servers.

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/my-new-feature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/my-new-feature`
5. Open a **Pull Request**.

---

## 📄 License

This project is open source and available under the MIT License.
