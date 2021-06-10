package ru.vsibi.presentation.screens.tours.info.flights.info

import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentFligthsInfoChildBinding

class FlightsInfoChildFragment : BaseFragment<FragmentFligthsInfoChildBinding>(FragmentFligthsInfoChildBinding::inflate, R.layout.fragment_fligths_info_child){

    companion object {
        const val KEY_FLIGHTS = "key_flights"
    }
}