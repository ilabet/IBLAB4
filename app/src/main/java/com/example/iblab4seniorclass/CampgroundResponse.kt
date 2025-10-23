package com.example.iblab4seniorclass


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private val annotation: Any
    get() {
        TODO()
    }

@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("data")
    val data: List<Campground>?
)
