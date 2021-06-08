package ru.vsibi.presentation.screens.hotels.main

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelsModel(
    val image: String,
    val title: String,
    val description: String,
    val location: String,
    val cost: Int,
    val currency : String,
    val dateStart: String,
    val dateEnd: String,
    val isFavorite: Boolean
) : Parcelable
