package ru.vsibi.presentation.screens.login.emailVariant.password

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.vsibi.data.api.auth.AuthRepository
import ru.vsibi.domain.network.post.PostLogin
import ru.vsibi.domain.network.post.PostSignup
import ru.vsibi.helper.Status
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.helpers.SharedPreferenceService
import ru.vsibi.presentation.helpers.SharedPreferenceService.Companion.KEY_AUTH
import ru.vsibi.presentation.helpers.SharedPreferenceService.Companion.KEY_EMAIL
import ru.vsibi.presentation.screens.login.emailVariant.createPassword.CreatePassViewState
import javax.inject.Inject

@HiltViewModel
class LoginPasswordViewModel @Inject constructor(
    private val sharedPref: SharedPreferenceService,
    private val authRepository : AuthRepository
) : BaseViewModel<LoginPasswordViewState, LoginPasswordAction, LoginPasswordEvent>() {

    private var email: String? = null

    override fun obtainEvent(viewEvent: LoginPasswordEvent) {
        when (viewEvent) {
            is LoginPasswordEvent.ConfigureArgs -> configureArgs(viewEvent.data)
            is LoginPasswordEvent.SignIn -> signIn(viewEvent.password)
            is LoginPasswordEvent.Default -> viewState = LoginPasswordViewState.Default()
        }
    }

    private fun configureArgs(data: String) {
        this.email = data
        viewState = LoginPasswordViewState.Loaded(data)
    }

    private fun signIn(password: String) {
        if (email == null) return
        if(password.isEmpty()) {
            viewAction = LoginPasswordAction.PasswordEmpty()
            return
        }
        viewState = LoginPasswordViewState.Loading()
        sharedPref.setSpString(KEY_EMAIL, email)
        viewModelScope.launchOnIO {
            val postAuth = PostLogin(email!!, password)
            val response = authRepository.login(postAuth)
            withContext(Dispatchers.Main) {
                when (response.status) {
                    Status.SUCCESS -> {
                        sharedPref.setSpString(KEY_AUTH, response.data?.body()?.result?.access_token)
                        viewState = LoginPasswordViewState.LoggedIn()
                    }
                    Status.ERROR -> {
                        viewState = LoginPasswordViewState.Error(response.error)
                    }
                }
            }
        }
    }
}