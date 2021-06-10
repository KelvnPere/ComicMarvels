# ComicsMarvels

Welcome 👋 

This is an Android Application that fetches a list of comics from the Marvels API and displays them beautifully in a Master List, and when clicked displays more information about the selected item.

<p float="left">
  <img src=https://user-images.githubusercontent.com/36895007/121485517-29fcaf00-c9c8-11eb-8578-bd18109e9e83.png width = 35%
 >
 <img src=https://user-images.githubusercontent.com/36895007/121485530-2c5f0900-c9c8-11eb-9a27-da73caf80d0b.png width= 35%>
</p>

<p float="left">
<img src=https://user-images.githubusercontent.com/36895007/121485539-2ec16300-c9c8-11eb-997d-ccfd7a32243f.png width= 30%>
<img src=https://user-images.githubusercontent.com/36895007/121485550-2ff29000-c9c8-11eb-93b9-413c232c1265.png width= 30%>
<img src=https://user-images.githubusercontent.com/36895007/121485557-3123bd00-c9c8-11eb-89a1-cd26bdb6a061.png width=30%>  
</p>

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

![Animated GIF-downsized_large](https://user-images.githubusercontent.com/36895007/121493494-cb3b3380-c9cf-11eb-9698-00b311632feb.gif)

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

# Improvement

No project is perfect, it always need something to make it efficient. Below are some :

* Implement Dependency Injection using Dagger Hilt to pass in various dependency.
* Implement Single Source of Truth for Implementing Offline Option using Room Database.
* Write Unit and UI test to verify the behaviour
* And more :)


M = Model
V = View
VM = ViewModel

