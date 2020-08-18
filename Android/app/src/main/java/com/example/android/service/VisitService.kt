package com.example.android.service

import com.example.android.model.RecordModel
import com.example.android.model.ResidentModel
import com.example.android.model.VisitModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface VisitService {

    @GET("visits")
    fun getVisits(): Call<ArrayList<VisitModel>>

    @GET("visits/{search}")
    fun searchByRut(@Path("search") rut: String): Call<ArrayList<VisitModel>>

    @GET("visits/{search}/resident")
    fun searchByResident(@Path("search") rut: String): Call<ArrayList<VisitModel>>

    @GET("visits/{search}/department")
    fun searchByDepartment(@Path("search") number: String): Call<ArrayList<VisitModel>>

    @POST("/api/records/")
    fun createRecord(@Query("name") name: String,
                     @Query("rut") rut: String,
                     @Query("admitted") admitted: String): Call<VisitModel>

}

