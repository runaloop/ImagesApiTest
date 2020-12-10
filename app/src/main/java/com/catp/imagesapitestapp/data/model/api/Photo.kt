package com.catp.imagesapitestapp.data.model.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class Photo(
    val id: String,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("promoted_at") val promotedAt: String,
    val width: Int,
    val height: Int,
    val color: String,
    @SerializedName("blur_hash") val blurHash: String,
    val description: String,
    @SerializedName("alt_description") val altDescription: String,
    val urls: Urls,
    val links: Links,
    val categories: List<String>,
    val likes: Int,
    @SerializedName("liked_by_user") val likedByUser: Boolean,
    @SerializedName("current_user_collections") val currentUserCollections: List<String>,
    val sponsorship: Sponsorship,
    val user: User
)