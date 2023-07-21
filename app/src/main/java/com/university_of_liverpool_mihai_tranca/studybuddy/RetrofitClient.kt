package com.university_of_liverpool_mihai_tranca.studybuddy

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://studentapiuoltest.azurewebsites.net/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val lecturesApi: LecturesApi by lazy {
        retrofit.create(LecturesApi::class.java)
    }
    val studentInfoApi: StudentInfoApiService by lazy {
        retrofit.create(StudentInfoApiService::class.java)
    }
}
fun fetchStudentInfo(studentId: Int, callback: (StudentInfo?) -> Unit) {
    val call = RetrofitClient.studentInfoApi.getStudentInfo(studentId)
    call.enqueue(object : Callback<StudentInfo> {
        override fun onResponse(call: Call<StudentInfo>, response: Response<StudentInfo>) {
            if (response.isSuccessful) {
                callback(response.body())
            } else {
                callback(null)
            }
        }

        override fun onFailure(call: Call<StudentInfo>, t: Throwable) {
            callback(null)
        }
    })
}

fun updateTopicStatus(studentId: Int, topicStatus: TopicCompletionStatus, callback: (Boolean) -> Unit) {
    val call = RetrofitClient.studentInfoApi.updateTopicStatus(studentId, topicStatus)
    call.enqueue(object : Callback<Unit> {
        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            callback(response.isSuccessful)
        }

        override fun onFailure(call: Call<Unit>, t: Throwable) {
            callback(false)
        }
    })
}
fun fetchLectures(callback: (List<Lecture>?) -> Unit) {
    val call = RetrofitClient.lecturesApi.getLectures()
    call.enqueue(object : Callback<List<Lecture>> {
        override fun onResponse(call: Call<List<Lecture>>, response: Response<List<Lecture>>) {
            if (response.isSuccessful) {
                callback(response.body())
            } else {
                callback(null)
            }
        }

        override fun onFailure(call: Call<List<Lecture>>, t: Throwable) {
            callback(null)
        }
    })
}
