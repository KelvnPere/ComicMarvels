# ComicsMarvels

Welcome 👋 

This is an Android Application that fetches a list of comics from the Marvels API and displays them beautifully in a Master List, and when clicked displays more information about the selected item.

Below is more information about the flow, architecture and libraries used for the project.

* [Kotlin](https://kotlinlang.org/)
* Android Support Libraries
* [Corutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Retrofit](https://square.github.io/retrofit/)
* ReyclerView
* ViewBinding
* Navigation Components

# Flow of the Application

The user clicks on the app from the launcher which then allows the Android Operating System to execute the application. The 
user waits for a short time as a progress bar is shown informing the users that some form of data is being loaded and will 
be displayed soon.  After data has been loaded from the Marvels Api it then displays some information:

* A list of Comics which all appears to be displayed in an ImageView. 


# Requirements

* JavaVersion.VERSION_1_8
* Latest Android Studio 4.0 above
* Latest Android SDK and Build Tools


# Architecture

Rather than implement everything in a Single Activity or Fragment though its a single view application. There were many 
options to follow, I decided on building the app using the MVVM Design Pattern which helps in separation of concerns.

M = Model
V = View
VM = ViewModel


