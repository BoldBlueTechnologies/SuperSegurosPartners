package com.app.boldblue.superseguros.partners.Methods

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.HashMap

interface methods_interface_superapi {

    @GET("vehicle")
    fun vehicle(@Header("x-app-key") appKey: String): Call<String>

    @POST("carModel")
    fun carModel (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("carBrands")
    fun carBrands (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("carSubBrands")
    fun carSubBrands (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("descriptions")
    fun descriptions (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("getBasicQuotation")
    fun getBasicQuotation (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("getGeneralQuotation")
    fun getGeneralQuotation (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("dataCar")
    fun dataCar (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("dataDriver")
    fun dataDriver (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("dataAddress")
    fun dataAddress (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("verifyEmail")
    fun verifyEmail (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("associateUser")
    fun associateUser (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>

    @POST("registerUser")
    fun registerUser (@Header("x-app-key") appKey: String,@Body user: HashMap<String, Any>): Call<String>
}