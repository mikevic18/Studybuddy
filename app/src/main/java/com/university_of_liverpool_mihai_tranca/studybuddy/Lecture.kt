package com.university_of_liverpool_mihai_tranca.studybuddy


data class Lecture(
    val subjectId: Int,
    val title: String,
    val imageUrl: String,
    val duration: String,
    val topics: List<Topic>
)
