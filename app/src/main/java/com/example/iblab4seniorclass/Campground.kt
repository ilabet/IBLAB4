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
data class Campground(
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("latLong")
    val latLong: String?,
    @SerialName("images")
    val images: List<CampgroundImage>?
) : java.io.Serializable {
    val imageUrl: String
        get() {
            val string = CampgroundImage.Companion.getUrl() ?: ""
            return string as String
        }
}

annotation class CampgroundImage {
    companion object {
        fun getUrl(): Any {
            return TODO("Provide the return value")
        }
    }
}
