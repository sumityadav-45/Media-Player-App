# Simple Media Player Android Application

A lightweight and clean Android Media Player application built using **Kotlin** and **XML**. The app demonstrates basic audio playback functionalities like playing, pausing, and navigating through a playlist, along with dynamic UI updates for song titles and album art.

##  Features
* **Play / Pause Functionality:** Toggle seamlessly between audio playback and pause states.
* **Track Navigation:** Easily switch to the next or previous track with automated boundary handling (looping playlist).
* **Dynamic UI Updates:** Real-time updates of song titles and corresponding album artwork during state changes.
* **Efficient Memory Management:** Properly releases the `MediaPlayer` resources on activity destruction (`onDestroy`) to prevent memory leaks.

##  Tech Stack & Architecture
* **Language:** Kotlin
* **UI Design:** XML Layouts (`LinearLayout`, `ImageButton`, `ImageView`)
* **Components:** Android `MediaPlayer` API
* **Design Pattern:** Simple Event-Driven Architecture

##  Application Preview
* **Background:** Deep Aesthetic Brown Theme (`#4B3621`)
* **Controls:** Standard Android Media Control Drawables for Next, Previous, and Play/Pause.

---
Developed as a foundational Android practice project by **Sumit Kumar**.
