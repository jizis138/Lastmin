package ru.vsibi.presentation.screens.tours.purchase

import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.screens.tours.main.TourModel

class PurchaseFormViewModel : BaseViewModel<PurchaseFormState, PurchaseFormAction, PurchaseFormEvent>(){

    private var hotelsModel : TourModel? = null

    override fun obtainEvent(viewEvent: PurchaseFormEvent) {
        when(viewEvent){
            is PurchaseFormEvent.ConfigureArgs -> {
                configureArgs(viewEvent.data)
            }
        }
    }

    private fun configureArgs(data: TourModel) {
        this.hotelsModel = data
        viewState = PurchaseFormState.Loaded(data)
    }
}