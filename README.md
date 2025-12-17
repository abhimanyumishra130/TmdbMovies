🎬 Movie App – Android Assignment

This is an Android movie browsing app built using Kotlin and Jetpack Compose as part of the Atlys Android Engineer Assignment.

📱 Overview
The app allows users to:
View a list of trending movies \n
Search movies\n
Open a detailed screen for any selected movie\n
View movie posters + info using TMDB\n
Access cached movies offline
Experience loading, error and empty UI states

🎯 Features

Trending movies list (20 items)
Search support
Movie details screen
Cached offline support
Image loading from TMDB
Compose Navigation
Proper app states:
Loading
Error
Empty

🛠 Tech Stack

Kotlin
Jetpack Compose
Compose Navigation
Retrofit / OkHttp (or preferred networking)
Coil / Glide for images
Room / DataStore for caching
Coroutines + Flow
Clean Architecture (simple)

🚀 API Used

Trending Movies API
https://api.themoviedb.org/3/trending/movie/week?language=en-US&api_key=YOUR_KEY

Image Fetching

https://image.tmdb.org/t/p/w500/<image_path>


You must generate an API Key from TMDB.

🧱 Architecture

MVVM + Clean-ish architecture

Layers:

data → API + cache
domain → repository + use cases
presentation → ViewModel + UI

📂 Project Structure (example)
app/
 ├─ data/
 ├─ domain/
 ├─ presentation/
 ├─ core/

🧪 Screens Implemented

Movie List Screen
Search UI
Detail Screen
Loading
Error
Empty
Offline cached view

🎥 Demo Recording

https://github.com/user-attachments/assets/8d691216-00ac-4b58-ab7e-1565682ee45b

