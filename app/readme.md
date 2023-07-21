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
