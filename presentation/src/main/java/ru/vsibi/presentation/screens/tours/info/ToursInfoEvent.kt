package ru.vsibi.presentation.screens.tours.info

import ru.vsibi.presentation.screens.tours.main.TourModel

sealed class ToursInfoEvent {
    class ConfigureArgs(val data: TourModel) : ToursInfoEvent()
}
