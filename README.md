# 🎬 Movie App – Android Assignment

This Android application is built using Kotlin and Jetpack Compose as part of the Atlys Android Engineer Assignment. The app fetches trending movies from the TMDB API, supports searching, and displays movie details based on user selection.

---

## 📱 Overview

- Displays a list of trending movies.
- Opens a detailed screen when a movie is selected.
- Includes search functionality for movie exploration.
- Uses TMDB API for movies and posters.
- Supports offline access by caching trending movies.
- Shows loading, empty, and error states.

---

## 🎯 Features

- Trending movies list (20 items)
- Search support
- Movie detail screen
- Offline caching support
- Image fetching from TMDB
- Compose Navigation
- Loading / Empty / Error states

---

## 🛠 Tech Stack

- Kotlin  
- Jetpack Compose  
- Compose Navigation  
- Retrofit / OkHttp  
- Coil (or any image loader)  
- Coroutines + Flow  
- Room / DataStore  

---

## 🚀 API Used

https://api.themoviedb.org/3/trending/movie/week?language=en-US&api_key=YOUR_KEY


TMDB Image Base URL:

https://image.tmdb.org/t/p/w500/


Register with TMDB to generate an API key.

---

## 🧱 Architecture

- MVVM + simple clean architecture
- Layers:
  - data → API + caching
  - domain → repository + use cases
  - presentation → ViewModel + UI

---

## 📂 Project Structure (Example)

app/
├─ data/
├─ domain/
├─ presentation/
├─ di/
└─ utils/

---

## 🎥 App Demo
https://github.com/user-attachments/assets/8d691216-00ac-4b58-ab7e-1565682ee45b

