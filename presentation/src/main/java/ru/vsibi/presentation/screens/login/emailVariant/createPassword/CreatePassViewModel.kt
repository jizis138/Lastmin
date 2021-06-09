package ru.vsibi.presentation.screens.login.emailVariant.createPassword

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.helpers.SharedPreferenceService
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordEvent
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordViewState
import javax.inject.Inject

@HiltViewModel
class CreatePassViewModel @Inject constructor(
    private val sharedPref: SharedPreferenceService
) : BaseViewModel<CreatePassState, CreatePassAction, CreatePassEvent>() {

    private var email: String? = null

    override fun obtainEvent(viewEvent: CreatePassEvent) {
        when (viewEvent) {
            is CreatePassEvent.ConfigureArgs -> configureArgs(viewEvent.data)
            is CreatePassEvent.SignIn -> signIn()
            is CreatePassEvent.Default -> viewState = CreatePassState.Default()
        }
    }

    private fun configureArgs(data: String) {
        this.email = data
        viewState = CreatePassState.Loaded(data)
    }

    private fun signIn() {
        sharedPref.setSpString(SharedPreferenceService.KEY_EMAIL, email)
        sharedPref.setSpBool(SharedPreferenceService.KEY_AUTH, true)
        viewState = CreatePassState.LoggedIn()
    }
}