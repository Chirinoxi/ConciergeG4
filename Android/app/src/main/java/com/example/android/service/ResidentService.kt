package com.example.android.service

import com.example.android.model.ResidentModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ResidentService {

    @GET("residents")
    fun getResidents(): Call<ArrayList<ResidentModel>>

    @POST("residents")
    fun createResident(@Query("rut") rut: String?, @Query("name") name: String?,
                        @Query("email") email: String?, @Query("phone") phone: Int,
                        @Query("department_number") department_id: Int): Call<ResidentModel>
}