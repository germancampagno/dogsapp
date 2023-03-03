package com.openpay.dogsapp.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", "RlRZT4mgK8gR5NO/+dcNUQ==DI6nj4qvhLw44YzJ")
            chain.proceed(request.build())
        }.build()
        return Retrofit.Builder().client(httpClient).baseUrl("https://api.api-ninjas.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}