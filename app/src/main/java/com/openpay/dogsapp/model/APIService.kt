package com.openpay.dogsapp.model

import com.openpay.dogsapp.model.entities.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v1/dogs")
    fun getDogs(@Query("energy") energy: Int): Call<List<Dog>>
}