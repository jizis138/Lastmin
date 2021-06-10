package ru.vsibi.presentation.screens.tours.purchase

import ru.vsibi.presentation.screens.tours.main.TourModel

sealed class PurchaseFormEvent {
    class ConfigureArgs(val data: TourModel) : PurchaseFormEvent()
}
