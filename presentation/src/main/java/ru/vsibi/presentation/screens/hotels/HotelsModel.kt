package ru.vsibi.presentation.screens.hotels

data class HotelsModel(
    val image: String,
    val title: String,
    val description: String,
    val cost: Int,
    val currency : String,
    val dateStart: String,
    val dateEnd: String,
    val isFavorite: Boolean
)
