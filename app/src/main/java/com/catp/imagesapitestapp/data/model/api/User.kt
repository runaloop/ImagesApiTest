package com.catp.imagesapitestapp.data.model.api

import com.google.gson.annotations.SerializedName


data class User(
    val id: String,
    @SerializedName("updated_at") val updatedAt: String,
    val username: String,
    val name: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("twitter_username") val twitterUsername: String,
    @SerializedName("portfolio_url") val portfolioUrl: String,
    val bio: String,
    val location: String,
    val links: Links,
    @SerializedName("profile_image") val profileImage: ProfileImage,
    @SerializedName("instagram_username") val instagramUsername: String,
    @SerializedName("total_collections") val totalCollections: Int,
    @SerializedName("total_likes") val totalLikes: Int,
    @SerializedName("total_photos") val totalPhotos: Int,
    @SerializedName("accepted_tos") val acceptedTos: Boolean
)