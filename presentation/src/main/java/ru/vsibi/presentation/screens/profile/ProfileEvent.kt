package ru.vsibi.presentation.screens.profile

sealed class ProfileEvent {
    class LogOut() : ProfileEvent()
}
