package com.openpay.dogsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.openpay.dogsapp.model.entities.Dog
import com.openpay.dogsapp.model.repository.DogRepository
import retrofit2.Call
import retrofit2.Response

class DogViewModel constructor(private val repository: DogRepository) : BaseViewModel() {

    val dogList: LiveData<List<Dog>> = MutableLiveData()
    val errorMessage: LiveData<String> = MutableLiveData()

    fun getDogs() {
        val response = repository.getDogs()
        response.enqueue(object : retrofit2.Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                dogList.mutable.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                errorMessage.mutable.postValue(t.message)
            }
        })
    }
}