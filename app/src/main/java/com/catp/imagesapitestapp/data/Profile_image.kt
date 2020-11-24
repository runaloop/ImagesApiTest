package com.catp.imagesapitestapp.data

import com.google.gson.annotations.SerializedName

data class Profile_image(

	@SerializedName("small") val small: String,
	@SerializedName("medium") val medium: String,
	@SerializedName("large") val large: String
)