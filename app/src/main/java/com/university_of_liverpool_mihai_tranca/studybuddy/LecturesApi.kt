package com.university_of_liverpool_mihai_tranca.studybuddy

import retrofit2.Call
import retrofit2.http.GET

interface LecturesApi {
    @GET("lectures")
    fun getLectures(): Call<List<Lecture>>
}
