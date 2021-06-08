package ru.vsibi.presentation.screens.hotels.info

import ru.vsibi.presentation.screens.hotels.main.HotelsModel
import ru.vsibi.presentation.screens.hotels.main.HotelsViewState

sealed class HotelsInfoState{
    class Loaded(val data : HotelsModel) : HotelsInfoState()

}
