package ru.vsibi.presentation.screens.tours.info.flights.main

import ru.vsibi.presentation.base.BaseViewModel

class FlightsListViewModel : BaseViewModel<FlightsListState, FlightsListAction, FlightsListEvent>() {

    override fun obtainEvent(viewEvent: FlightsListEvent) {
        when(viewEvent){
            is FlightsListEvent.FetchData -> fetchHotels()
        }
    }

    private fun fetchHotels() {
        viewState = FlightsListState.Loaded(FlightsMockFactory.getMockFlights())
    }

}