package com.catp.imagesapitestapp.data.model.api

import com.google.gson.annotations.SerializedName


data class Sponsorship(
	@SerializedName("impression_urls") val impressionUrls: List<String>,
	val tagline: String,
	@SerializedName("tagline_url") val taglineUrl: String,
	val sponsor: Sponsor
)