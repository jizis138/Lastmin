package ru.vsibi.presentation.screens.hotels

sealed class HotelsViewState {
    class Loaded(val data : List<HotelsModel>) : HotelsViewState()
}