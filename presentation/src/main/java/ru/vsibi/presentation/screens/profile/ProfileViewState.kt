package ru.vsibi.presentation.screens.profile

sealed class ProfileViewState {
    class LoggedOut() : ProfileViewState()
}
