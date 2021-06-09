package ru.vsibi.presentation.screens.profile.main

sealed class ProfileViewState {
    class LoggedOut() : ProfileViewState()
}
