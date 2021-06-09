package ru.vsibi.presentation.screens.login.emailVariant.createPassword

sealed class CreatePassState {
    class Loaded(val data: String) : CreatePassState()
    class LoggedIn : CreatePassState()
    class Default : CreatePassState()
}
