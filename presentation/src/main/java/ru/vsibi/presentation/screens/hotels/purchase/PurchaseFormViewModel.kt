package ru.vsibi.presentation.screens.hotels.purchase

import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

class PurchaseFormViewModel : BaseViewModel<PurchaseFormState, PurchaseFormAction, PurchaseFormEvent>(){

    private var hotelsModel : HotelsModel? = null

    override fun obtainEvent(viewEvent: PurchaseFormEvent) {
        when(viewEvent){
            is PurchaseFormEvent.ConfigureArgs -> {
                configureArgs(viewEvent.data)
            }
        }
    }

    private fun configureArgs(data: HotelsModel) {
        this.hotelsModel = data
        viewState = PurchaseFormState.Loaded(data)
    }
}