package ru.vsibi.presentation.screens.hotels.purchase

import ru.vsibi.presentation.screens.hotels.info.HotelsInfoState
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

sealed class PurchaseFormState {
    class Loaded(val data : HotelsModel) : PurchaseFormState()
}