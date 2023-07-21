# Student Buddy

StudyBuddy is an educational mobile application designed to assist students in organizing and managing their academic progress effectively. The app aims to enhance the learning experience by providing a user-friendly platform to access and track course materials, lectures, and study progress.

## Future Features

1. **User Authentication and Profiles**: Implement user authentication using email and password or social media accounts. Allow users to create profiles and customize their study preferences.

2. **Topic Progress Tracking**: Enable users to track their progress on individual topics. Show completion percentage and provide visual indicators for completed topics.

3. **Reminder and Notifications**: Integrate a reminder system to notify users about upcoming lectures, study sessions, or assignment deadlines. Allow users to set custom reminders.

4. **User Ratings and Reviews**: Add a rating and review system for lectures and subjects. Users can rate lectures and leave feedback, helping others to find valuable study materials.

5. **Offline Mode**: Implement offline mode for lecture content and previously accessed topics. Users can access their study materials even without an internet connection.

6. **Study Planner**: Create a study planner that allows users to schedule their study sessions, set study goals, and track their study habits over time.

7. **Dark Mode Support**: Introduce a dark mode option for better user experience during night-time studying or to reduce battery consumption.

8. **Interactive Quiz Feature**: Add interactive quizzes related to lecture topics to reinforce learning. Provide instant feedback on quiz results.

9. **Study Groups and Collaboration**: Allow users to form study groups, collaborate on shared subjects, and organize group study sessions.

10. **Gamification and Rewards**: Introduce gamification elements, such as earning rewards or badges for completing lectures or achieving study goals.

11. **In-App Notes and Annotations**: Allow users to take notes and make annotations within the app, directly linked to specific lecture topics.

12. **Personalized Study Recommendations**: Implement an AI-based recommendation system that suggests relevant lectures and topics based on the user's study history and preferences.

13. **Multi-Language Support**: Localize the app to support multiple languages, enabling users from different regions to use the app in their preferred language.

14. **Data Analytics and Insights**: Provide data analytics and insights to users, such as study time tracking, most viewed lectures, and topic completion trends.

15. **Accessibility Features**: Enhance accessibility by implementing features like voice commands, screen reader compatibility, and customizable font sizes.

16. **Collaborative Note-Sharing**: Allow users to share lecture notes with others, fostering collaboration and knowledge exchange.

17. **Interactive Study Tools**: Introduce interactive study tools, such as flashcards, quizzes, and interactive diagrams, to make learning engaging and effective.

18. **Enhanced Data Visualization**: Improve data visualization within the app, providing users with clear graphical representations of their study progress and achievements.

# Table of Classes

## Data Classes

-   [Lecture Data Class](#lecture-data-class)
-   [StudentInfo](#studentinfo)
-   [Subject](#subject)
-   [Topic](#topic)
-   [TopicCompletionStatus](#topiccompletionstatus)

## Interfaces

-   [LecturesApi](#lecturesapikt)
-   [StudentInfoApiService](#studentinfoapiservicekt)

## Adapters

-   [LectureAdapter.kt](#lectureadapterkt)
-   [TopicAdapter.kt](#topicadapterkt)

## Fragments

-   [LecturesFragment.kt](#lecturesfragmentkt)
-   [TopicsFragment.kt](#topicsfragmentkt)

## Singleton Objects

-   [RetrofitClient.kt](#retrofitclientkt)

## MainActivity

-   [MainActivity.kt](#mainactivitykt)

</br>
</br>
</br>
</br>

# Classes

## Lecture Data Class

This file contains the definition of the `Lecture` data class, which is an essential part of the StudyBuddy Android app. The `Lecture` class represents a single lecture and contains information related to it.

### Class Description

The `Lecture` data class holds the following properties:

1. `subjectId`: An integer value representing the unique identifier of the subject associated with the lecture.

2. `title`: A string value representing the title or name of the lecture.

3. `imageUrl`: A string value representing the URL of the lecture's image. This image is displayed as a visual representation of the lecture.

4. `duration`: A string value representing the duration or length of the lecture. This can be in any human-readable time format, such as "1 hour 30 minutes."

5. `topics`: A list of `Topic` objects that contain information about the various topics covered in the lecture.

### Class Structure

```kotlin
data class Lecture(
    val subjectId: Int,
    val title: String,
    val imageUrl: String,
    val duration: String,
    val topics: List<Topic>

)
```

### Constructors

The `Lecture` data class has a primary constructor that takes five parameters:

-   `subjectId`: The unique identifier of the subject associated with the lecture.

-   `title`: The title or name of the lecture.

-   `imageUrl`: The URL of the lecture's image.

-   `duration`: The duration or length of the lecture.

-   `topics`: A list of `Topic` objects representing the topics covered in the lecture.

### Usage

The `Lecture` data class is used to represent individual lectures within the StudyBuddy app. It allows the app to store and access information about different lectures efficiently.

For example, when the app retrieves a list of lectures for a particular subject, it will create instances of the `Lecture` class, populating them with data such as the lecture's title, image URL, duration, and a list of topics. This information can then be displayed to the user in a user-friendly manner.

## LectureAdapter.kt

This file contains the `LectureAdapter` class, which is a RecyclerView Adapter responsible for displaying a list of lectures in the Study Buddy Android app.

### Design Methodology

1. **RecyclerView Adapter:**
   The `LectureAdapter` class extends `RecyclerView.Adapter<LectureAdapter.LectureViewHolder>`, adhering to the best practice of using RecyclerView to efficiently manage and display lists of data. This allows for optimized view recycling and smoother scrolling performance, especially for larger datasets.

2. **View Binding:**
   View binding is used within the `LectureViewHolder` to efficiently access and update the views of each lecture item. This is achieved through `findViewById`, which reduces the need for repetitive `findViewById` calls and improves code readability.

3. **Event Handling:**
   The `onItemClickListener` is a callback function provided to the `LectureAdapter` constructor. It allows the parent component (such as an Activity or Fragment) to respond to click events on individual lecture items in the RecyclerView. This promotes separation of concerns and enables the parent component to handle click events in a more structured manner.

4. **Data Update and Refresh:**
   The `updateData(newLectures: List<Lecture>)` method allows the adapter's underlying dataset to be updated with new lecture data. After updating the data, `notifyDataSetChanged()` is called, which informs the RecyclerView to refresh its view to reflect the changes. This ensures that any new or updated lectures are immediately displayed on the screen.

5. **Image Loading with Glide:**
   The `Glide` library is utilized to efficiently load lecture images from their respective URLs into the `lectureImage` ImageView. Using Glide simplifies the process of image loading, caching, and handling image resizing for display. This approach contributes to improved app performance and responsiveness when dealing with potentially large images.

6. **Separation of Concerns:**
   The `LectureAdapter` and `LectureViewHolder` classes have clear responsibilities, separating the RecyclerView adapter logic from the ViewHolder that handles individual lecture item view binding and display. This promotes code maintainability and readability.

## LecturesApi.kt

This file contains the `LecturesApi` interface, which defines the API endpoints for fetching lectures data from the backend server. The `LecturesApi` interface is responsible for making HTTP requests using Retrofit, a widely used library for handling RESTful API communication in Android apps.

### Design Methodology

1. **Interface Definition:**
   The `LecturesApi` interface follows the standard design for defining API endpoints in Retrofit. It declares abstract functions corresponding to the HTTP methods (e.g., `@GET`, `@POST`, etc.) and their respective paths on the server.

2. **HTTP GET Request:**
   The `getLectures()` function is annotated with `@GET("lectures")`, which specifies that it makes an HTTP GET request to the `lectures` endpoint on the server. This function is expected to return a list of lectures wrapped in a Retrofit `Call` object.

3. **Asynchronous Communication:**
   Retrofit's `Call` object enables asynchronous communication with the server. When a request is made, the server responds with the data, and the response can be handled in the form of a callback using Retrofit's `enqueue()` method.

4. **Data Model:**
   The `getLectures()` function is defined to return a `Call<List<Lecture>>`, which means it expects the server to respond with a list of `Lecture` objects. The data model (`Lecture` data class) used here is the same as the one defined in the first file.

## LecturesFragment.kt

This file contains the `LecturesFragment` class, which represents a fragment in the Study Buddy Android app. The `LecturesFragment` is responsible for displaying a list of lectures using a RecyclerView, fetching the lectures data from the backend server, and handling user interactions.

### Design Methodology

1. **Fragment:**
   The `LecturesFragment` is a subclass of `Fragment`, which is a fundamental component in Android for building dynamic and modular user interfaces. Fragments allow for reusability and modularity in UI components.

2. **Layout Inflation:**
   In the `onCreateView()` method, the layout for the `LecturesFragment` is inflated using the `LayoutInflater` from the provided `container`. The layout file is specified as `R.layout.fragment_lectures`.

3. **RecyclerView Initialization:**
   In the `onViewCreated()` method, the `RecyclerView` and its associated `LectureAdapter` are initialized. The `LectureAdapter` is instantiated with an empty list of lectures, and an `onItemClickListener` is provided to handle clicks on individual lectures.

4. **ProgressBar Visibility:**
   A `ProgressBar` with the ID `R.id.progressBar` is defined in the fragment layout. Initially, it is set to `View.VISIBLE` to indicate that data is being loaded. Once the lectures are fetched and the RecyclerView is populated, the ProgressBar's visibility is set to `View.GONE`.

5. **Data Fetching:**
   In the `onViewCreated()` method, the `fetchLectures` function is called to retrieve the list of lectures from the server. The fetched lectures are then passed to the `lecturesAdapter` for display in the RecyclerView. If the data fetching fails, an error message is displayed using a `Toast`.

6. **RecyclerView and LinearLayoutManager:**
   The RecyclerView is initialized with a `LinearLayoutManager` that arranges items in a vertical list. This ensures that the lectures are displayed in a scrollable list.

7. **Updating Data in the Adapter:**
   The `lecturesAdapter.updateData(lectures)` method is called to update the RecyclerView's data with the fetched list of lectures. The `updateData` function in the adapter notifies the RecyclerView about the changes using `notifyDataSetChanged()`.

8. **Fragment Transaction:**
   The `openTopicsFragment(lecture: Lecture)` function is responsible for opening a new `TopicsFragment` and passing the selected lecture to it. A `FragmentManager` transaction is used to replace the current fragment with the new one, allowing the user to navigate back to the previous fragment.

## MainActivity.kt

This file contains the `MainActivity` class, which serves as the main entry point for the Study Buddy Android app. The `MainActivity` manages the app's navigation using a DrawerLayout, where users can access different fragments, such as the lectures and settings.

### Design Methodology

1. **Navigation Drawer:**
   The `MainActivity` implements a navigation drawer using `DrawerLayout` and `NavigationView`. The navigation drawer provides easy access to different sections of the app.

2. **Fragment Transactions:**
   The `MainActivity` uses `FragmentManager` to perform fragment transactions. It includes a `replaceFragment()` function that replaces the current fragment with a new one. Additionally, when navigating from the navigation drawer, the `replaceFragment()` function is called with the corresponding fragment to show its content.

3. **Fragment Lifecycle Handling:**
   In the `onCreate()` method of `MainActivity`, a check is made using `savedInstanceState == null` to determine if the app is launching for the first time or being recreated. This helps prevent fragment duplication when the app is restored from a previous state.

4. **Back Button Handling:**
   The `MainActivity` overrides the `onBackPressed()` method to handle the back button press. If the navigation drawer is open, it closes it; otherwise, it behaves like the default back button functionality.

5. **ActionBarDrawerToggle:**
   The `ActionBarDrawerToggle` is used to synchronize the state of the navigation drawer icon with its open/close status. This ensures that the drawer icon animates properly when the drawer is opened or closed.

### Usage

In this implementation, the app launches with the `LecturesFragment` displayed as the initial fragment. The navigation drawer allows users to navigate to the "Home," "Lectures," and "Settings" sections of the app.

When a user selects the "Lectures" option from the navigation drawer, the `openLecturesFragment()` function is called to replace the current fragment with the `LecturesFragment`. Similarly, if the user selects "Home" or "Settings," the corresponding fragments are opened or actions are taken.

## RetrofitClient.kt

This file contains the `RetrofitClient` singleton object along with three functions for making API calls using Retrofit. The `RetrofitClient` object is responsible for creating a single instance of the Retrofit client with a specific base URL, and it provides access to two different API interfaces (`LecturesApi` and `StudentInfoApiService`).

### Design Methodology

1. **Singleton Pattern:**
   The `RetrofitClient` is implemented as a singleton object. Singleton pattern ensures that there is only one instance of the `Retrofit` client throughout the app's lifecycle, promoting efficiency and resource management.

2. **Lazy Initialization:**
   The Retrofit client and API interfaces are initialized lazily using `by lazy` to ensure that they are only created when accessed for the first time. This optimization prevents unnecessary initialization if the APIs are not used in the app.

3. **Base URL:**
   The `BASE_URL` constant is the base URL for the backend server's API. It is used when building the Retrofit instance to define the starting point for all API requests.

4. **Gson Converter:**
   The Retrofit client is configured with GsonConverterFactory to automatically convert JSON responses to Kotlin data objects (e.g., `List<Lecture>`, `StudentInfo`, etc.). Gson is a popular JSON parsing library in the Android ecosystem.

5. **API Functions:**
   The `fetchStudentInfo`, `updateTopicStatus`, and `fetchLectures` functions make API calls using the respective API interfaces (`StudentInfoApiService` and `LecturesApi`). Each function uses Retrofit's `enqueue()` method for asynchronous communication with the server.

6. **Callback Handling:**
   The API functions use Retrofit's `Callback` interface to handle the responses and errors from the server. The callback functions invoke the provided callback passed as an argument with the relevant data or `null` in case of errors.

## StudentInfo.kt

This file contains the `StudentInfo` data class, which represents information about a student in the Study Buddy Android app. The `StudentInfo` data class includes the student's ID and a list of `TopicCompletionStatus` objects, representing the completion status of various topics for the student.

### Design Methodology

1. **Data Class:**
   The `StudentInfo` class is defined as a data class in Kotlin. Data classes automatically provide implementations for common methods such as `toString()`, `equals()`, and `hashCode()`, making it easier to work with and manage data.

2. **Structured Representation:**
   The `StudentInfo` data class combines related properties into a single class, providing a structured representation of student information. By using this data class, it is easy to access and manage a student's ID and topic completion status together.

##  StudentInfoApiService.kt

This file contains the `StudentInfoApiService` interface, which defines the API endpoints related to student information and topic status updates in the Study Buddy Android app. The interface is responsible for making HTTP requests using Retrofit to fetch student information and update the completion status of topics.

### Design Methodology

1. **Interface Definition:**
   The `StudentInfoApiService` interface follows the standard design for defining API endpoints in Retrofit. It declares abstract functions corresponding to the HTTP methods (e.g., `@GET`, `@POST`, etc.) and their respective paths on the server.

2. **HTTP GET Request:**
   The `getStudentInfo()` function is annotated with `@GET("studentinfo/{studentId}")`, which specifies that it makes an HTTP GET request to the `studentinfo/{studentId}` endpoint on the server. The `studentId` is a path parameter that is dynamically replaced with the actual student ID when the request is made.

3. **HTTP POST Request:**
   The `updateTopicStatus()` function is annotated with `@POST("studentinfo/{studentId}/update-topic")`, which specifies that it makes an HTTP POST request to the `studentinfo/{studentId}/update-topic` endpoint on the server. The `studentId` is a path parameter, and the `TopicCompletionStatus` object is sent in the request body.

4. **Path Parameter:**
   The `@Path("studentId")` annotation in both functions specifies that the `studentId` variable will be replaced with the actual student ID provided as an argument to the functions.

5. **Request Body:**
   The `@Body` annotation is used to pass the `TopicCompletionStatus` object as the request body in the `updateTopicStatus()` function.

## Subject.kt

This file contains the data class `Subject`, which represents a subject within the Study Buddy Android app. The `Subject` data class is responsible for storing information about a specific subject, such as its subject ID, title, image URL, duration, and a list of topics associated with the subject.

### Design Methodology

1. **Data Class:**
   Similar to other data classes in the project, the `Subject` class is defined as a data class in Kotlin. Data classes automatically provide implementations for common methods such as `toString()`, `equals()`, and `hashCode()`, making it easier to work with and manage data.

2. **Data Encapsulation:**
   The properties of the `Subject` class are declared as read-only `val` properties. This promotes immutability, ensuring that once a `Subject` object is created, its state cannot be changed, leading to more predictable and reliable behavior.

3. **Structured Representation:**
   The `Subject` class uses a structured representation of data, combining related properties into a single data class. This promotes clarity and maintains data integrity within the app.

## Topic.kt

This file contains the data class `Topic`, which represents a single topic within the Study Buddy Android app. The `Topic` data class is responsible for storing information about a specific topic, such as its ID, title, and completion status.

### Design Methodology

1. **Data Class:**
   The `Topic` class is defined as a data class in Kotlin. Data classes automatically provide implementations for common methods such as `toString()`, `equals()`, and `hashCode()`, making it easier to work with and manage data.

2. **Immutability:**
   All properties of the `Topic` class are declared as read-only `val` properties except for the `isCompleted` property. This promotes immutability for most of the properties, ensuring that the essential data cannot be changed once a `Topic` object is created. However, the `isCompleted` property is mutable, allowing its value to change based on the user's progress.

3. **Default Parameter:**
   The `isCompleted` property is assigned a default value of `false`, indicating that a `Topic` is not completed by default. This default value simplifies object creation and allows for flexibility when initializing `Topic` instances.

4. **Topic Completion Status:**
   The `isCompleted` property is used to track the completion status of a topic. When the user completes a topic, the value of this property can be set to `true`, indicating that the topic is finished. This approach allows for easy tracking and management of the user's progress.

5. **Encapsulation:**
   By making the properties private and using constructor parameters, the `Topic` class encapsulates its data, preventing direct modification from outside the class. Access to the properties is provided through getter methods, which improves data integrity and ensures better control over data access.

6. **Customization:**
   The `Topic` class can be easily extended in the future to include additional properties or methods to accommodate changes in the app's requirements or features.

## TopicAdapter.kt

This file contains the `TopicAdapter` class, which serves as an adapter for populating a RecyclerView with a list of topics in the Study Buddy Android app.

### Design Methodology

1. **RecyclerView.Adapter:**
   The `TopicAdapter` class extends `RecyclerView.Adapter<TopicAdapter.TopicViewHolder>`, adhering to the standard design for creating an adapter for RecyclerView. This enables efficient rendering of the list of topics.

2. **ViewHolder Pattern:**
   The adapter uses the ViewHolder pattern by defining an inner class `TopicViewHolder` that holds references to the individual views in the RecyclerView item layout. This pattern enhances the performance of the RecyclerView by reusing view references as the user scrolls through the list.

3. **Checkbox for Topic Completion:**
   The `TopicAdapter` uses checkboxes to represent the completion status of each topic. When a checkbox is checked or unchecked, the completion status of the corresponding `Topic` object is updated, and the provided `onCheckedChangeListener` is called to handle the topic completion status change.

4. **Listener for Checkbox Changes:**
   The `TopicAdapter` receives an `onCheckedChangeListener` as a constructor parameter. This listener allows external components to respond to changes in the topic completion status through the `onCheckedChangeListener(topic)` function.

5. **Layout Inflation:**
   In the `onCreateViewHolder` method, the layout for individual topic items (`item_topic`) is inflated using the `LayoutInflater` from the parent context. This ensures that each item in the RecyclerView has the appropriate layout.

6. **View Recycling:**
   The `onBindViewHolder` method is responsible for binding data to the ViewHolder. It reuses the existing ViewHolder by passing in the data for the specific position in the `topics` list. This recycling mechanism significantly improves performance as the RecyclerView can reuse views instead of creating new ones for every item.

##  TopicCompletionStatus.kt

This file contains the data class `TopicCompletionStatus`, which represents the completion status of a single topic in the Study Buddy Android app.

### Design Methodology

1. **Data Class:**
   The `TopicCompletionStatus` class is defined as a data class in Kotlin. Data classes automatically provide implementations for common methods such as `toString()`, `equals()`, and `hashCode()`, making it easier to work with and manage data.

2. **Encapsulation:**
   The properties `topicId` and `isComplete` are declared as read-only `val` properties. This promotes immutability and ensures that once a `TopicCompletionStatus` object is created, its state cannot be changed, leading to more predictable and reliable behavior.

## TopicsFragment.kt

This file contains the `TopicsFragment` class, which represents a Fragment in the Study Buddy Android app. The `TopicsFragment` is responsible for displaying a list of topics within a specific lecture and updating the completion status of the topics.

### Design Methodology

1. **Fragment Implementation:**
   The `TopicsFragment` class extends `Fragment`, which is the standard practice for creating a fragment in Android.

2. **Lateinit Initialization:**
   Properties such as `lecture`, `topicsAdapter`, and `loadingProgressBar` are declared with the `lateinit` keyword, indicating that they will be initialized later in the code. This is because these properties require a non-null value, but their values are set in the `onViewCreated()` method.

3. **TopicAdapter Usage:**
   The `TopicsFragment` uses the `TopicAdapter` to display the list of topics associated with the lecture. The `topicsAdapter` is initialized with the topics of the lecture, and a listener is set to update the topic status when the checkbox is clicked.

4. **Network Calls:**
   The `fetchStudentInfo()` function is used to retrieve the student's topic completion status from the backend server. It updates the topics with the completion status obtained from the server and notifies the adapter to refresh the list.

5. **Update Topic Status:**
   The `updateTopicStatus()` function is called when the user checks/unchecks a topic checkbox. It updates the topic status locally and sends the updated status to the backend server through the `updateTopicStatus()` function in the `StudentInfoApiService`.

6. **Toast Messages:**
   The app displays toast messages to notify the user about the success or failure of updating the topic status.

7. **Setting Lecture Data:**
   The `setLecture(lecture: Lecture)` function is used to pass the lecture data to the fragment before its view is created. This ensures that the lecture data is available when the fragment's view is being set up.
