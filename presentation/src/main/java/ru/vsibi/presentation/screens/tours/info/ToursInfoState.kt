package ru.vsibi.presentation.screens.tours.info

import ru.vsibi.presentation.screens.tours.main.TourModel

sealed class ToursInfoState{
    class Loaded(val data : TourModel) : ToursInfoState()

}
