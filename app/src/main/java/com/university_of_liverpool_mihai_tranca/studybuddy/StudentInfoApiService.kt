package com.university_of_liverpool_mihai_tranca.studybuddy
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StudentInfoApiService {
    @GET("studentinfo/{studentId}")
    fun getStudentInfo(@Path("studentId") studentId: Int): Call<StudentInfo>

    @POST("studentinfo/{studentId}/update-topic")
    fun updateTopicStatus(@Path("studentId") studentId: Int, @Body topicStatus: TopicCompletionStatus): Call<Unit>
}
