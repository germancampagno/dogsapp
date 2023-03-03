package com.openpay.dogsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel() : ViewModel() {
    // Adding the `mutable` extension so we don't need to create custom LiveData getters in the view models
    protected val <T> LiveData<T>.mutable: MutableLiveData<T>
        get() = this as MutableLiveData<T>
}