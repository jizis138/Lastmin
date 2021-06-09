package ru.vsibi.presentation.screens.login.emailVariant.password

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.helpers.SharedPreferenceService
import ru.vsibi.presentation.helpers.SharedPreferenceService.Companion.KEY_AUTH
import ru.vsibi.presentation.helpers.SharedPreferenceService.Companion.KEY_EMAIL
import javax.inject.Inject

@HiltViewModel
class LoginPasswordViewModel @Inject constructor(
    private val sharedPref: SharedPreferenceService
) : BaseViewModel<LoginPasswordViewState, LoginPasswordAction, LoginPasswordEvent>() {

    private var email: String? = null

    override fun obtainEvent(viewEvent: LoginPasswordEvent) {
        when (viewEvent) {
            is LoginPasswordEvent.ConfigureArgs -> configureArgs(viewEvent.data)
            is LoginPasswordEvent.SignIn -> signIn()
            is LoginPasswordEvent.Default -> viewState = LoginPasswordViewState.Default()
        }
    }

    private fun configureArgs(data: String) {
        this.email = data
        viewState = LoginPasswordViewState.Loaded(data)
    }

    private fun signIn() {
        sharedPref.setSpString(KEY_EMAIL, email)
        sharedPref.setSpBool(KEY_AUTH, true)
        viewState = LoginPasswordViewState.LoggedIn()
    }
}