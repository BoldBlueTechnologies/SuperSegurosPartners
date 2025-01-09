package com.app.boldblue.superseguros.partners.Services

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.app.boldblue.superseguros.partners.Adapters.AdapterAseguradoras_superapi
import com.app.boldblue.superseguros.partners.BuildConfig
import com.app.boldblue.superseguros.partners.Dialogs.helper_dialogs_superapi
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_coberturas
import com.app.boldblue.superseguros.partners.Main.coberturas.fragment_coverage_superapi
import com.app.boldblue.superseguros.partners.Methods.methods_interface_superapi
import com.app.boldblue.superseguros.partners.Methods.models_list_insurance_superapi
import com.app.boldblue.superseguros.partners.Methods.models_list_superapi
import com.app.boldblue.superseguros.partners.R
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_cinco_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_dos_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_iniciar_sesion_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_pago_poliza_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_registro_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_seis_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_siete_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_tres_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Formulario_vincula_superapi
import com.app.boldblue.superseguros.partners.SeguroAuto.Listados
import com.google.android.material.tabs.TabLayoutMediator
import okhttp3.OkHttpClient
import org.json.JSONArray
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



    fun vehicle(activity: Listados){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.vehicle(appKey = BuildConfig.tokenSuper)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("vehicle---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayAuto.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayAuto.add(models_list_superapi(
                                    jsonData.getJSONObject(vr).getString("TipoVehiculoBase"),
                                    jsonData.getJSONObject(vr).getString("Descripcion")
                                ))
                            }
                            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionvehicle---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailurevehicle---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun carModel(activity: Listados,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.carModel(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("carModel---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayAuto.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayAuto.add(models_list_superapi(
                                    jsonData.getJSONObject(vr).getString("Modelo"),
                                    jsonData.getJSONObject(vr).getString("Modelo")
                                ))
                            }
                            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptioncarModel---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailurecarModel---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun carBrands(activity: Listados,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.carBrands(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("carBrands---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayAuto.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayAuto.add(models_list_superapi(
                                    jsonData.getJSONObject(vr).getString("IdMarca"),
                                    jsonData.getJSONObject(vr).getString("Marca")
                                ))
                            }
                            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptioncarBrands---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailurecarBrands---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun carSubBrands(activity: Listados,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.carSubBrands(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("carSubBrands---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayAuto.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayAuto.add(models_list_superapi(
                                    jsonData.getJSONObject(vr).getString("IdProductorSubGrupo"),
                                    jsonData.getJSONObject(vr).getString("ProductorSubGrupo")
                                ))
                            }
                            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptioncarSubBrands---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailurecarSubBrands---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun descriptions(activity: Listados,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.descriptions(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("descriptions---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayAuto.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayAuto.add(models_list_superapi(
                                    jsonData.getJSONObject(vr).getString("ClaveInterna"),
                                    jsonData.getJSONObject(vr).getString("DescripcionAuto")
                                ))
                            }
                            activity.adapter.actualizarLista(ArrayList( activity.arrayAuto))
                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiondescriptions---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuredescriptions---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun getBasicQuotation(activity: Formulario_dos_superapi,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.getBasicQuotation(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("getBasicQuotation---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            activity.arrayInsurance.clear()
                            for(vr in 0 until jsonData.length()){
                                activity.arrayInsurance.add(
                                    models_list_insurance_superapi(
                                        jsonData.getJSONObject(vr).getString("aseguradora"),
                                        jsonData.getJSONObject(vr).getString("img"),
                                        jsonData.getJSONObject(vr).getString("monto")
                                    )
                                )
                            }
                            activity.recyclerAseguradoras_superapi.adapter = AdapterAseguradoras_superapi(activity.arrayInsurance,activity)
                        }
                        500 -> {
                            activity.cardClean_superapi.visibility=View.VISIBLE
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiongetBasicQuotation---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuregetBasicQuotation---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun getGeneralQuotation(activity: Formulario_tres_superapi,map: HashMap<String, Any>){
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.getGeneralQuotation(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("getGeneralQuotation---------${response.code()}")
                println("getGeneralQuotation---------${response.code()}")

                try {
                    when (response.code()) {
                        200 -> {
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONArray(jsonBody.getString("data"))
                            val listTitles: Array<String> = Array(jsonData.length()) { "" }

                            val tabFragment: Array<Fragment> = Array(jsonData.length()) {Fragment()}
                            for(vr in 0 until jsonData.length()){
                                listTitles[vr] = jsonData.getJSONObject(vr).getString("cotizacion")
                                val fragment = fragment_coberturas()  // Crea el fragmento
                                val bundle = Bundle()

                                bundle.putString("vehicleType", activity.modelsDataPolicySuperapi.vehicleType)
                                bundle.putString("description", activity.modelsDataPolicySuperapi.description)
                                bundle.putString("model", activity.modelsDataPolicySuperapi.model)
                                bundle.putString("nameBrand", activity.modelsDataPolicySuperapi.nameBrand)
                                bundle.putString("brand", activity.modelsDataPolicySuperapi.brand)
                                bundle.putString("nameSubBrand", activity.modelsDataPolicySuperapi.nameSubBrand)
                                bundle.putString("subBrand", activity.modelsDataPolicySuperapi.subBrand)
                                bundle.putString("internalKey", activity.modelsDataPolicySuperapi.internalKey)
                                bundle.putString("autoDescription", activity.modelsDataPolicySuperapi.autoDescription)
                                bundle.putString("insurance", activity.modelsDataPolicySuperapi.insurance)
                                bundle.putString("cotizacion", jsonData.getJSONObject(vr).getString("cotizacion"))
                                bundle.putString("ZIPCode",activity.modelsDataPolicySuperapi.ZIPCode)


                                val listFormaPago: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }
                                val listCoberturasAplicables: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }
                                val listNumeroCotizacion: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }
                                val listCostoTotal: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }
                                val listPrimerRecibo: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }
                                val listSubSecuentes: Array<String> = Array(jsonData.getJSONObject(vr).getJSONArray("coberturas").length()) { "" }

                                for(rv in 0 until jsonData.getJSONObject(vr).getJSONArray("coberturas").length()){
                                    listFormaPago[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getString("formaPago")
                                    listCoberturasAplicables[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getString("numeroCotizacion")
                                    listNumeroCotizacion[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getString("numeroCotizacion")
                                    listCostoTotal[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getJSONObject("costoTotal").getString("montoRedondeado")
                                    listPrimerRecibo[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getJSONObject("primerRecibo").getString("montoRedondeado")
                                    listSubSecuentes[rv] = jsonData.getJSONObject(vr).getJSONArray("coberturas").getJSONObject(rv).getJSONObject("subSecuentes").getString("montoRedondeado")
                                }

                                bundle.putStringArray("listFormaPago",listFormaPago)
                                bundle.putStringArray("listCoberturasAplicables",listCoberturasAplicables)
                                bundle.putStringArray("listNumeroCotizacion",listNumeroCotizacion)
                                bundle.putStringArray("listCostoTotal",listCostoTotal)
                                bundle.putStringArray("listPrimerRecibo",listPrimerRecibo)
                                bundle.putStringArray("listSubSecuentes",listSubSecuentes)

                                fragment.arguments = bundle
                                tabFragment[vr] = fragment
                            }
                            activity.mViewPager.adapter= fragment_coverage_superapi(activity, listTitles,tabFragment)
                            TabLayoutMediator(activity.mTablayout, activity.mViewPager) { tab, position -> tab.text = listTitles[position] }.attach()


                        }
                        500 -> {

                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiongetGeneralQuotation---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuregetGeneralQuotation---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun dataCar(activity: Formulario_cinco_superapi,map: HashMap<String, Any>){
        println("dataCar---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.dataCar(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("dataCar---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("dataCar---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONObject(jsonBody.getString("data"))
                            val intent = Intent(activity, Formulario_seis_superapi::class.java)
                            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)
                            intent.putExtra("ZIPCode",activity.modelsDataPolicySuperapi.ZIPCode)

                            intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                            intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                            intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                            intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                            intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                            intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                            intent.putExtra("licensePlate",map["licensePlate"].toString())
                            intent.putExtra("VIN",map["VIN"].toString())
                            intent.putExtra("engineNumber",map["engineNumber"].toString())

                            intent.putExtra("idCar",jsonData.getString("id_car"))

                            activity.startActivity(intent)
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiondataCar---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuredataCar---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun dataDriver(activity: Formulario_seis_superapi,map: HashMap<String, Any>){
        println("dataDriver---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.dataDriver(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("dataDriver---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("dataDriver---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONObject(jsonBody.getString("data"))
                            val intent = Intent(activity, Formulario_siete_superapi::class.java)
                            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)
                            intent.putExtra("ZIPCode",activity.modelsDataPolicySuperapi.ZIPCode)

                            intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                            intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                            intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                            intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                            intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                            intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                            intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                            intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                            intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                            intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                            intent.putExtra("name",map["name"].toString())
                            intent.putExtra("paternalSurname",map["paternalSurname"].toString())
                            intent.putExtra("maternalSurname",map["maternalSurname"].toString())
                            intent.putExtra("bornDate",map["bornDate"].toString())
                            intent.putExtra("idDriver",jsonData.getString("id_driver"))

                            activity.startActivity(intent)
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiondataDriver---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuredataDriver---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun dataAddress(activity: Formulario_siete_superapi,map: HashMap<String, Any>){
        println("dataAddress---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.dataAddress(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("dataAddress---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("dataAddress---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONObject(jsonBody.getString("data"))
                            val intent = Intent(activity, Formulario_vincula_superapi::class.java)
                            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)

                            intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                            intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                            intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                            intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                            intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                            intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                            intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                            intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                            intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                            intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                            intent.putExtra("name",activity.modelsDataPolicySuperapi.name)
                            intent.putExtra("paternalSurname",activity.modelsDataPolicySuperapi.paternalSurname)
                            intent.putExtra("maternalSurname",activity.modelsDataPolicySuperapi.maternalSurname)
                            intent.putExtra("bornDate",activity.modelsDataPolicySuperapi.bornDate)
                            intent.putExtra("idDriver",activity.modelsDataPolicySuperapi.idDriver)
                            intent.putExtra("street",activity.modelsDataPolicySuperapi.street)

                            intent.putExtra("id_Address",activity.modelsDataPolicySuperapi.id_Address)
                            intent.putExtra("streetNumber",activity.modelsDataPolicySuperapi.streetNumber)
                            intent.putExtra("apartmentNumber",activity.modelsDataPolicySuperapi.apartmentNumber)
                            intent.putExtra("state",activity.modelsDataPolicySuperapi.state)
                            intent.putExtra("city",activity.modelsDataPolicySuperapi.city)
                            intent.putExtra("neighborhood",activity.modelsDataPolicySuperapi.neighborhood)
                            activity.startActivity(intent)
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptiondataAddress---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailuredataAddress---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun verifyEmail(activity: Formulario_vincula_superapi,map: HashMap<String, Any>){
        println("verifyEmail---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.verifyEmail(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("verifyEmail---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("verifyEmail---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            val jsonData = JSONObject(jsonBody.getString("data"))
                            if(jsonData.getString("registrado")=="1"){
                                val intent = Intent(activity, Formulario_iniciar_sesion_superapi::class.java)
                                intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                                intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                                intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                                intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                                intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                                intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                                intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                                intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                                intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                                intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)

                                intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                                intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                                intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                                intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                                intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                                intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                                intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                                intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                                intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                                intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                                intent.putExtra("name",activity.modelsDataPolicySuperapi.name)
                                intent.putExtra("paternalSurname",activity.modelsDataPolicySuperapi.paternalSurname)
                                intent.putExtra("maternalSurname",activity.modelsDataPolicySuperapi.maternalSurname)
                                intent.putExtra("bornDate",activity.modelsDataPolicySuperapi.bornDate)
                                intent.putExtra("idDriver",activity.modelsDataPolicySuperapi.idDriver)

                                intent.putExtra("street",activity.modelsDataPolicySuperapi.street)
                                intent.putExtra("streetNumber",activity.modelsDataPolicySuperapi.streetNumber)
                                intent.putExtra("apartmentNumber",activity.modelsDataPolicySuperapi.apartmentNumber)
                                intent.putExtra("state",activity.modelsDataPolicySuperapi.state)
                                intent.putExtra("city",activity.modelsDataPolicySuperapi.city)
                                intent.putExtra("neighborhood",activity.modelsDataPolicySuperapi.neighborhood)
                                intent.putExtra("email",map["email"].toString())
                                activity.startActivity(intent)
                            }else{
                                val intent = Intent(activity, Formulario_registro_superapi::class.java)
                                intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                                intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                                intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                                intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                                intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                                intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                                intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                                intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                                intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                                intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)

                                intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                                intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                                intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                                intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                                intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                                intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                                intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                                intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                                intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                                intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                                intent.putExtra("name",activity.modelsDataPolicySuperapi.name)
                                intent.putExtra("paternalSurname",activity.modelsDataPolicySuperapi.paternalSurname)
                                intent.putExtra("maternalSurname",activity.modelsDataPolicySuperapi.maternalSurname)
                                intent.putExtra("bornDate",activity.modelsDataPolicySuperapi.bornDate)
                                intent.putExtra("idDriver",activity.modelsDataPolicySuperapi.idDriver)

                                intent.putExtra("street",activity.modelsDataPolicySuperapi.street)
                                intent.putExtra("streetNumber",activity.modelsDataPolicySuperapi.streetNumber)
                                intent.putExtra("apartmentNumber",activity.modelsDataPolicySuperapi.apartmentNumber)
                                intent.putExtra("state",activity.modelsDataPolicySuperapi.state)
                                intent.putExtra("city",activity.modelsDataPolicySuperapi.city)
                                intent.putExtra("neighborhood",activity.modelsDataPolicySuperapi.neighborhood)
                                intent.putExtra("email",map["email"].toString())
                                activity.startActivity(intent)
                            }

                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionverifyEmail---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailureverifyEmail---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun associateUser(activity: Formulario_iniciar_sesion_superapi,map: HashMap<String, Any>){
        println("associateUser---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.associateUser(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("associateUser---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("associateUser---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            //val jsonData = JSONObject(jsonBody.getString("data"))
                            val intent = Intent(activity, Formulario_pago_poliza_superapi::class.java)
                            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)

                            intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                            intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                            intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                            intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                            intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                            intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                            intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                            intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                            intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                            intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                            intent.putExtra("name",activity.modelsDataPolicySuperapi.name)
                            intent.putExtra("paternalSurname",activity.modelsDataPolicySuperapi.paternalSurname)
                            intent.putExtra("maternalSurname",activity.modelsDataPolicySuperapi.maternalSurname)
                            intent.putExtra("bornDate",activity.modelsDataPolicySuperapi.bornDate)
                            intent.putExtra("idDriver",activity.modelsDataPolicySuperapi.idDriver)
                            intent.putExtra("id_Address",activity.modelsDataPolicySuperapi.id_Address)

                            intent.putExtra("street",activity.modelsDataPolicySuperapi.street)
                            intent.putExtra("streetNumber",activity.modelsDataPolicySuperapi.streetNumber)
                            intent.putExtra("apartmentNumber",activity.modelsDataPolicySuperapi.apartmentNumber)
                            intent.putExtra("state",activity.modelsDataPolicySuperapi.state)
                            intent.putExtra("city",activity.modelsDataPolicySuperapi.city)
                            intent.putExtra("neighborhood",activity.modelsDataPolicySuperapi.neighborhood)

                            intent.putExtra("email",activity.modelsDataPolicySuperapi.email)
                            intent.putExtra("password",activity.modelsDataPolicySuperapi.password)

                            activity.startActivity(intent)
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionassociateUser---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailureassociateUser---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }

    fun registerUser(activity: Formulario_registro_superapi,map: HashMap<String, Any>){
        println("registerUser---------${map}")
        val helperDialogs = helper_dialogs_superapi(activity)
        helperDialogs.progressActivate(activity.resources.getString(R.string.cargando_superapi))
        val retrofit: Retrofit = Retrofit.Builder()
            .client(getokHttpclientPrincipalTime())
            .baseUrl(BuildConfig.apipartnersSuper)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: methods_interface_superapi = retrofit.create(methods_interface_superapi::class.java)
        val call: Call<String> = api.registerUser(appKey = BuildConfig.tokenSuper,map)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("registerUser---------${response.code()}")
                try {
                    when (response.code()) {
                        200 -> {
                            println("registerUser---------${response.body().toString()}")
                            val jsonBody = JSONObject(response.body().toString())
                            //val jsonData = JSONObject(jsonBody.getString("data"))
                            val intent = Intent(activity, Formulario_pago_poliza_superapi::class.java)
                            intent.putExtra("vehicleType",activity.modelsDataPolicySuperapi.vehicleType)
                            intent.putExtra("description",activity.modelsDataPolicySuperapi.description)
                            intent.putExtra("model",activity.modelsDataPolicySuperapi.model)
                            intent.putExtra("nameBrand",activity.modelsDataPolicySuperapi.nameBrand)
                            intent.putExtra("brand",activity.modelsDataPolicySuperapi.brand)
                            intent.putExtra("nameSubBrand",activity.modelsDataPolicySuperapi.nameSubBrand)
                            intent.putExtra("subBrand",activity.modelsDataPolicySuperapi.subBrand)
                            intent.putExtra("internalKey",activity.modelsDataPolicySuperapi.internalKey)
                            intent.putExtra("autoDescription",activity.modelsDataPolicySuperapi.autoDescription)
                            intent.putExtra("insurance",activity.modelsDataPolicySuperapi.insurance)

                            intent.putExtra("paymentForm", activity.modelsDataPolicySuperapi.paymentForm)
                            intent.putExtra("applicableCoverages",activity.modelsDataPolicySuperapi.applicableCoverages)
                            intent.putExtra("quoteNumber",activity.modelsDataPolicySuperapi.quoteNumber)
                            intent.putExtra("totalCost",activity.modelsDataPolicySuperapi.totalCost)
                            intent.putExtra("firstReceipt",activity.modelsDataPolicySuperapi.firstReceipt)
                            intent.putExtra("subsequents",activity.modelsDataPolicySuperapi.subsequents)

                            intent.putExtra("licensePlate",activity.modelsDataPolicySuperapi.licensePlate)
                            intent.putExtra("VIN",activity.modelsDataPolicySuperapi.VIN)
                            intent.putExtra("engineNumber",activity.modelsDataPolicySuperapi.engineNumber)

                            intent.putExtra("idCar",activity.modelsDataPolicySuperapi.idCar)

                            intent.putExtra("name",map["name"].toString())
                            intent.putExtra("paternalSurname",map["paternalSurname"].toString())
                            intent.putExtra("maternalSurname",map["maternalSurname"].toString())
                            intent.putExtra("bornDate",activity.modelsDataPolicySuperapi.bornDate)
                            intent.putExtra("idDriver",activity.modelsDataPolicySuperapi.idDriver)
                            intent.putExtra("id_Address",activity.modelsDataPolicySuperapi.id_Address)

                            intent.putExtra("street",activity.modelsDataPolicySuperapi.street)
                            intent.putExtra("streetNumber",activity.modelsDataPolicySuperapi.streetNumber)
                            intent.putExtra("apartmentNumber",activity.modelsDataPolicySuperapi.apartmentNumber)
                            intent.putExtra("state",activity.modelsDataPolicySuperapi.state)
                            intent.putExtra("city",activity.modelsDataPolicySuperapi.city)
                            intent.putExtra("neighborhood",activity.modelsDataPolicySuperapi.neighborhood)

                            intent.putExtra("email",map["email"].toString())
                            intent.putExtra("password",map["password"].toString())
                            intent.putExtra("phoneNumber",map["phoneNumber"].toString())

                            activity.startActivity(intent)
                        }
                        500 -> {
                        }
                        else -> {
                        }
                    }
                }catch (e: JSONException){
                    println("JSONExceptionregisterUser---------$e")
                }
                helperDialogs.progressDesactivate()
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                println("onFailureregisterUser---------$t")
                helperDialogs.progressDesactivate()
            }
        })
    }
}