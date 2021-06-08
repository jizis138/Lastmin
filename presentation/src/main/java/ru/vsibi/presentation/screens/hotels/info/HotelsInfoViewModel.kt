package ru.vsibi.presentation.screens.hotels.info

import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

class HotelsInfoViewModel : BaseViewModel<HotelsInfoState, HotelsInfoAction, HotelsInfoEvent>() {

    private var hotel : HotelsModel? = null

    override fun obtainEvent(viewEvent: HotelsInfoEvent) {
        when(viewEvent){
            is HotelsInfoEvent.ConfigureArgs -> configureArgs(viewEvent.data)
        }
    }

    private fun configureArgs(data: HotelsModel) {
        this.hotel = data
        viewState = HotelsInfoState.Loaded(data)
    }
}