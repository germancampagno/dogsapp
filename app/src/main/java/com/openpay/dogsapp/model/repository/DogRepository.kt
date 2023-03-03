package com.openpay.dogsapp.model.repository

import com.openpay.dogsapp.model.APIService
import com.openpay.dogsapp.model.RetrofitHelper

class DogRepository {

    // Here we're passing the 'energy' param as the API requires at least one query param to be used
    fun getDogs() = RetrofitHelper().getRetrofit().create(APIService::class.java).getDogs(5)

}