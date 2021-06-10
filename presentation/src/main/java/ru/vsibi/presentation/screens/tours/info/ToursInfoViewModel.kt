package ru.vsibi.presentation.screens.tours.info

import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.screens.tours.main.TourModel

class ToursInfoViewModel : BaseViewModel<ToursInfoState, ToursInfoAction, ToursInfoEvent>() {

    var tour : TourModel? = null

    override fun obtainEvent(viewEvent: ToursInfoEvent) {
        when(viewEvent){
            is ToursInfoEvent.ConfigureArgs -> configureArgs(viewEvent.data)
        }
    }

    private fun configureArgs(data: TourModel) {
        this.tour = data
        viewState = ToursInfoState.Loaded(data)
    }
}