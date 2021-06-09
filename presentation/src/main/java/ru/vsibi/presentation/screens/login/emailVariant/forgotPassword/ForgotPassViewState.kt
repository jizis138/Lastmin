package ru.vsibi.presentation.screens.login.emailVariant.forgotPassword

sealed class ForgotPassViewState {
    class OnSentLink() : ForgotPassViewState()
}
