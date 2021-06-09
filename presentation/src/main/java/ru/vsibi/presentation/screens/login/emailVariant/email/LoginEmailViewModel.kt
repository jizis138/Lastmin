package ru.vsibi.presentation.screens.login.emailVariant.email

import ru.vsibi.presentation.base.BaseViewModel

class LoginEmailViewModel : BaseViewModel<LoginEmailViewState, LoginEmailAction, LoginEmailEvent>() {

    override fun obtainEvent(viewEvent: LoginEmailEvent) {
        when(viewEvent){
            is LoginEmailEvent.ContinueWithEmail -> continueWithEmail(viewEvent.email)
        }
    }

    private fun continueWithEmail(email: String) {
        viewState = LoginEmailViewState.OnLoginEntered(email)
    }
}