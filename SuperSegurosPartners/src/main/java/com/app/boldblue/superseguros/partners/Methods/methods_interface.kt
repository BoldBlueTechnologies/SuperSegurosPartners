package com.app.boldblue.superseguros.partners.Methods

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface methods_interface {

    @GET("user/getData")
    fun usergetData(@Header("Authorization") token: String): Call<String>
}