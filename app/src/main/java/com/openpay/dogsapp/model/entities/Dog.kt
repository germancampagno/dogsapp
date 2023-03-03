package com.openpay.dogsapp.model.entities

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("name") val dogName: String,
    @SerializedName("image_link") val url: String,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_height_male") val maxHeight: Double,
    @SerializedName("min_height_male") val minHeight: Double,
)