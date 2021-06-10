package ru.vsibi.presentation.screens.tours.info.flights.main

sealed class FlightsListState {
    class Loaded(val data : List<FlightsModel>) : FlightsListState()
}
