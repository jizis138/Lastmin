package ru.vsibi.presentation.screens.search.main

import android.os.Handler
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.models.SearchModel

class SearchViewModel : BaseViewModel<SearchViewState, SearchAction, SearchEvent>() {

    private var search = SearchModel()

    override fun obtainEvent(viewEvent: SearchEvent) {
        when(viewEvent){
            is SearchEvent.StartSearch -> {
                startSearch()
            }
            is SearchEvent.Default -> viewState = SearchViewState.Default()
            is SearchEvent.UpdateDate -> search.date = viewEvent.data
            is SearchEvent.UpdateCountry -> search.country = viewEvent.data
            is SearchEvent.UpdatePersonsDesc -> search.personsDesc = viewEvent.data
        }
    }

    private fun startSearch() {
        viewState = SearchViewState.Loading()
        Handler().postDelayed({
            viewState = SearchViewState.Loaded()
        }, 500)
    }

    fun getSearchModel() = search
}