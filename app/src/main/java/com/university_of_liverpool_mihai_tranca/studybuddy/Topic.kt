package com.university_of_liverpool_mihai_tranca.studybuddy

data class Topic(
    val topicId: Int,
    val title: String,
    var isCompleted: Boolean = false
)