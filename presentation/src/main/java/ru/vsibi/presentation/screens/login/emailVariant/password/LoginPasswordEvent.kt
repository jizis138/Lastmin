package ru.vsibi.presentation.screens.login.emailVariant.password

sealed class LoginPasswordEvent {
    class ConfigureArgs(val data : String) : LoginPasswordEvent()
    class SignIn : LoginPasswordEvent()
}
