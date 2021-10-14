package ru.vsibi.presentation.screens.tours.info

import ru.vsibi.domain.network.response.ResponseSearch
import ru.vsibi.presentation.screens.tours.main.TourModel

sealed class ToursInfoState{
    class Loaded(val data : ResponseSearch.Result) : ToursInfoState()

}
