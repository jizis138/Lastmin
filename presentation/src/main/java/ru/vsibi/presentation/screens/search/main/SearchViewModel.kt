package ru.vsibi.presentation.screens.search.main

import android.os.Handler
import ru.vsibi.presentation.base.BaseViewModel

class SearchViewModel : BaseViewModel<SearchViewState, SearchAction, SearchEvent>() {

    override fun obtainEvent(viewEvent: SearchEvent) {
        when(viewEvent){
            is SearchEvent.StartSearch -> {
                startSearch()
            }
            is SearchEvent.Default -> viewState = SearchViewState.Default()
        }
    }

    private fun startSearch() {
        viewState = SearchViewState.Loading()
        Handler().postDelayed({
            viewState = SearchViewState.Loaded()
        }, 500)
    }
}