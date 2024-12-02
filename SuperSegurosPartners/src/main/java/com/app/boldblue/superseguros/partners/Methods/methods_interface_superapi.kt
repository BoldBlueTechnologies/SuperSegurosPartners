package com.app.boldblue.superseguros.partners.Methods

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.HashMap

interface methods_interface_superapi {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String): Call<String>

    @GET("medical-records/pickers")
    fun picker(@Header("Authorization") token: String): Call<String>

    @GET("pharma/weeklyPromotion")
    fun pharmaweeklyPromotion (@Header("Authorization") token: String): Call<String>

}