package com.example.afinal

import com.example.afinal.model.Countries
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.covid19api.com"

interface ApiInterface {
    @GET("/countries")
    fun getCountries():Call<Countries>
}

object ApiService {
    val countriesInstance: ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        countriesInstance = retrofit.create(ApiInterface::class.java)
    }
}


