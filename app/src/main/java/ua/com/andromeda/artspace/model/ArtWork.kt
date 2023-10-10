package ua.com.andromeda.artspace.model

import androidx.annotation.DrawableRes

data class ArtWork(
    @DrawableRes val id: Int,
    val title: String,
    val author: String,
    val year: Int
)