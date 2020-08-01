package com.example.android.service

import com.example.android.reponse.DepartmentResponse
import retrofit2.Call
import retrofit2.http.GET

interface DepartmentService {

    @GET("/api/departments/")
    fun getDepartments(): Call<DepartmentResponse>

}