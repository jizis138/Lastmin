package ru.vsibi.presentation.screens.hotels.purchase

import ru.vsibi.presentation.screens.hotels.info.HotelsInfoEvent
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

sealed class PurchaseFormEvent {
    class ConfigureArgs(val data: HotelsModel) : PurchaseFormEvent()
}
