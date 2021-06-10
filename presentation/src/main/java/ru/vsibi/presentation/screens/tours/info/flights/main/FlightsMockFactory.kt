package ru.vsibi.presentation.screens.tours.info.flights.main

object FlightsMockFactory {

    fun getMockFlights(): List<FlightsModel> {
        val flights = mutableListOf<FlightsModel>()
        flights.add(FlightsModel())
        flights.add(FlightsModel())
        return flights
    }
}