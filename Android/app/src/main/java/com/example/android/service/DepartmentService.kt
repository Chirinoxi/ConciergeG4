package com.example.android.service

import com.example.android.model.DepartmentModel
import retrofit2.Call
import retrofit2.http.*

interface DepartmentService {
    @GET("departments/")
    @Headers("Accept: application/json")
    fun getDepartments(@Header("Authorization") auth:String):Call<ArrayList<DepartmentModel>>

    @GET("departments/{search}/")
    fun searchByNumber(@Header("Authorization") auth:String,
                       @Path("search") number: String) : Call<ArrayList<DepartmentModel>>

    @GET("departments/{search}/resident/")
    fun searchByResident(@Header("Authorization") auth:String,
                         @Path("search") rut: String): Call<ArrayList<DepartmentModel>>

    @GET("departments/{search}/visit/")
    fun searchByVisit(@Header("Authorization") auth:String,
                      @Path("search") rut: String): Call<ArrayList<DepartmentModel>>

    @POST("/api/departments/")
    fun createDepartment(@Header("Authorization") auth:String,
                         @Query("number") number: Int,
                         @Query("floor") floor: Int?,
                         @Query("block") block: Char?): Call<DepartmentModel>
}