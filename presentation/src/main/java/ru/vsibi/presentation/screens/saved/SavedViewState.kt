package ru.vsibi.presentation.screens.saved

import ru.vsibi.presentation.screens.hotels.main.HotelsModel

sealed class SavedViewState {
    class Loaded(val data : List<HotelsModel>) : SavedViewState()
}
