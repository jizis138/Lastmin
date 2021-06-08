package ru.vsibi.presentation.screens.hotels.main

sealed class HotelsViewState {
    class Loaded(val data : List<HotelsModel>) : HotelsViewState()
}