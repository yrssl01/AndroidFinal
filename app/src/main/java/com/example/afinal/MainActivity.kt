package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.afinal.model.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CountriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCountries()
    }

    private fun getCountries() {
        val countries = ApiService.countriesInstance.getCountries()
        countries.enqueue(object : Callback<Countries>{
            override fun onResponse(call: Call<Countries>, response: Response<Countries>) {
                val countries = response.body()
                if (countries != null) {
                    Log.d("Success", countries.toString())
                }
            }

            override fun onFailure(call: Call<Countries>, t: Throwable) {
                Log.d("Error", "Error")
            }
        })
    }

}