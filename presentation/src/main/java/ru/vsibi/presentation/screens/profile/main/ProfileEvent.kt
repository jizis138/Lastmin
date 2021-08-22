package ru.vsibi.presentation.screens.profile.main

sealed class ProfileEvent {
    class LogOut() : ProfileEvent()
    class FetchProfile() : ProfileEvent()
}
