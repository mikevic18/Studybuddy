package com.university_of_liverpool_mihai_tranca.studybuddy
data class Subject(
    val subjectId: Int,
    val title: String,
    val imageUrl: String,
    val duration: String,
    val topics: List<Topic>
)
