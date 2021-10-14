package ru.vsibi.presentation.screens.tours.info

import ru.vsibi.domain.network.response.ResponseSearch
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.screens.tours.main.TourModel

class ToursInfoViewModel : BaseViewModel<ToursInfoState, ToursInfoAction, ToursInfoEvent>() {

    var tour : ResponseSearch.Result? = null

    override fun obtainEvent(viewEvent: ToursInfoEvent) {
        when(viewEvent){
            is ToursInfoEvent.ConfigureArgs -> configureArgs(viewEvent.data)
        }
    }

    private fun configureArgs(data: ResponseSearch.Result) {
        this.tour = data
        viewState = ToursInfoState.Loaded(data)
    }
}