package com.app.boldblue.superseguros.partners.Services

import android.view.View
import com.app.boldblue.superseguros.partners.Adapters.AdapterAseguradoras_superapi
import com.app.boldblue.superseguros.partners.BuildConfig
import com.app.boldblue.superseguros.partners.Main.Principal_superapi
import com.app.boldblue.superseguros.partners.Methods.methods_interface_superapi
import com.app.boldblue.superseguros.partners.Methods.models_aseguradoras_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_dos_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_uno_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Listados
import okhttp3.OkHttpClient
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class HelperConnectSuperApi {

    fun getokHttpclientPrincipalTime(): OkHttpClient {
        return  OkHttpClient().newBuilder()
            .followRedirects(false)
            .followSslRedirects(false)
            .connectTimeout(100000, TimeUnit.SECONDS)
            .readTimeout(100000, TimeUnit.SECONDS)
            .writeTimeout(100000, TimeUnit.SECONDS)
            .build()
    }



    fun login(map: HashMap<String,Any>, activity: Formulario_uno_superapi){
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.login(map["email"].toString(),map["password"].toString())
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("login---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonData = JSONObject(response.body().toString())
                            activity.tokenSuperApi = jsonData.getJSONObject("data").getString("token")
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionlogin---------$e")
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailurelogin---------$t")
            }
        })
    }

    fun pickerBrand(token: String, activity: Listados){
        if(activity.tipoSuperApi==0){
            for(vr in 0 until activity.resources.getString(R.string.tipoDeAuto_superapi).length){
                activity.arrayAuto.add(activity.resources.getString(R.string.tipoDeAuto_superapi)[vr].toString())
            }
            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
        }else{
            val retrofit: Retrofit = Retrofit.Builder()
                .client(getokHttpclientPrincipalTime())
                .baseUrl(BuildConfig.apipartnersSuper)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
            val call: Call<String> = api.picker(token = "Bearer "+token)
            call.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    println("picker---------${response.code()}")
                    try {
                        when (response.code()) {
                            200 -> {
                                val jsonBody = JSONObject(response.body().toString())
                                val jsonData = JSONObject(jsonBody.getString("data"))
                                val picker1 = jsonData.getJSONArray("PickerCatalogoAlcoholTiempoIngiriendo")
                                for(i in 0 until picker1.length()){
                                    activity.arrayAuto.add(picker1[i].toString())
                                }
                                activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                            }
                            500 -> {
                            }
                            else -> {
                            }
                        }
                    }catch (e: JSONException){
                        println("JSONExceptionpicker---------$e")
                    }
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    println("onFailurepicker---------$t")
                }
            })
        }

    }

    fun pharmaweeklyPromotion(token: String, activity: Formulario_dos_superapi){
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.pharmaweeklyPromotion(token = "Bearer "+token)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("pharmaweeklyPromotion---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            var arrayAseguradoras = ArrayList<models_aseguradoras_superapi>()
                            println("pharmaweeklyPromotion---------${response.body().toString()}")
                            val jsonData = JSONObject(response.body().toString())
                            if(jsonData.getJSONObject("data").getJSONArray("medicamentos").length()>0){
                                for(v in 0 until jsonData.getJSONObject("data").getJSONArray("medicamentos").length()){
                                    arrayAseguradoras.add(models_aseguradoras_superapi(
                                        jsonData.getJSONObject("data").getJSONArray("medicamentos").getJSONObject(v).getInt("id"),
                                        jsonData.getJSONObject("data").getJSONArray("medicamentos").getJSONObject(v).getString("imagen_medicamento"),
                                        jsonData.getJSONObject("data").getJSONArray("medicamentos").getJSONObject(v).getDouble("precio_venta_final")
                                    ))
                                }
                                activity.recyclerAseguradoras_superapi.adapter = AdapterAseguradoras_superapi(arrayAseguradoras,activity)
                            }else
                                activity.cardClean_superapi.visibility=View.VISIBLE
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionmodulesmyModules---------$e")
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuremodulesmyModules---------$t")
            }
        })
    }
}