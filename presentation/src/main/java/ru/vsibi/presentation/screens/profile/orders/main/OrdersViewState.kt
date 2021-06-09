package ru.vsibi.presentation.screens.profile.orders.main

import ru.vsibi.presentation.screens.hotels.main.HotelsModel

sealed class OrdersViewState {
    class Loaded(val data : List<HotelsModel>) : OrdersViewState()
}
