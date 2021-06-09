package ru.vsibi.presentation.screens.login.emailVariant.password

sealed class LoginPasswordViewState {
    class Loaded(val data : String) : LoginPasswordViewState()
    class LoggedIn : LoginPasswordViewState()
}
