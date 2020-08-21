package com.example.android.service

import com.example.android.reponse.LoginResponse
import com.example.android.reponse.LogoutResponse
import com.example.android.reponse.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Api connections for users
 */
interface AuthService {

    /**
     * Post operation for a new user
     */
    @FormUrlEncoded
    @POST("register")
    @Headers("Accept: application/json")
    fun register(@Field ("name") name : String,
                 @Field ("email") email: String,
                 @Field("password") password : String,
                 @Field("password_confirmation") password_confirmation: String
                ) : Call<RegisterResponse>

    /**
     * login operation
     */
    @FormUrlEncoded
    @POST("login")
    @Headers("Accept: application/json")
    fun login(@Field("email") email : String,
              @Field("password") password : String
             ): Call<LoginResponse>

    /**
     * logout operation
     */
    @POST("logout")
    @Headers("Accept: application/json")
    fun logout(@Header("Authorization") auth:String): Call<LogoutResponse>


}