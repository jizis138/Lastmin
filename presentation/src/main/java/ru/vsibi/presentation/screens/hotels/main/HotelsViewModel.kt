package ru.vsibi.presentation.screens.hotels.main

import ru.vsibi.presentation.base.BaseViewModel

class HotelsViewModel : BaseViewModel<HotelsViewState, HotelsAction, HotelsEvent>() {


    override fun obtainEvent(viewEvent: HotelsEvent) {
        when(viewEvent){
            is HotelsEvent.Default -> fetchHotels()
        }
    }

    private fun fetchHotels() {
        viewState = HotelsViewState.Loaded(HotelsMockFactory.getMockHotels())
    }

}