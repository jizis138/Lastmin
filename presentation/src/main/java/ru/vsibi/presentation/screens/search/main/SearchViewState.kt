package ru.vsibi.presentation.screens.search.main

sealed class SearchViewState {
    class Loading() : SearchViewState()
    class Loaded() : SearchViewState()
    class Default() : SearchViewState()
}