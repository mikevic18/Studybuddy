package com.university_of_liverpool_mihai_tranca.studybuddy

data class StudentInfo(
    val studentId: Int,
    val topics: List<TopicCompletionStatus>
)