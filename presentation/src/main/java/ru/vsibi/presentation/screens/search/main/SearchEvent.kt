package ru.vsibi.presentation.screens.search.main

sealed class SearchEvent {
    class StartSearch() : SearchEvent()
    class UpdatePersonsDesc(val data : String) : SearchEvent()
    class UpdateDate(val data : String) : SearchEvent()
    class UpdateCountry(val data : String) : SearchEvent()
    class Default() : SearchEvent()
}
