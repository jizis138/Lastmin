package ru.vsibi.presentation.screens.search.main

sealed class SearchEvent {
    class StartSearch() : SearchEvent()
}
