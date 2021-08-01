package ru.vsibi.presentation.screens.login

import androidx.lifecycle.viewModelScope
import com.facebook.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.vsibi.data.api.auth.AuthRepository
import ru.vsibi.helper.Status
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.helpers.SharedPreferenceService
import ru.vsibi.presentation.screens.login.emailVariant.createPassword.CreatePassViewState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val sharedPref : SharedPreferenceService
) : BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginWithFacebook -> loginWithFacebook(viewEvent.accessToken)
            is LoginEvent.LoginWithGoogle -> loginWithGoogle(viewEvent.accessToken)
        }
    }

    private fun loginWithFacebook(accessToken: String) {
        viewState = LoginViewState.Loading()
        viewModelScope.launchOnIO {
            val response = authRepository.authSocial(accessToken, "facebook")
            withContext(Dispatchers.Main) {
                when (response.status) {
                    Status.SUCCESS -> {
                        sharedPref.setSpString(SharedPreferenceService.KEY_AUTH, response.data?.body()?.result?.access_token)
                        viewState = LoginViewState.LoggedIn()
                    }
                    Status.ERROR -> {
                        viewState = LoginViewState.Error(response.error)
                    }
                }
            }
        }
    }

    private fun loginWithGoogle(accessToken: String) {
        viewState = LoginViewState.Loading()
        viewModelScope.launchOnIO {
            val response = authRepository.authSocial(accessToken, "google")
            withContext(Dispatchers.Main) {
                when (response.status) {
                    Status.SUCCESS -> {
                        sharedPref.setSpString(SharedPreferenceService.KEY_AUTH, response.data?.body()?.result?.access_token)
                        viewState = LoginViewState.LoggedIn()
                    }
                    Status.ERROR -> {
                        viewState = LoginViewState.Error(response.error)
                    }
                }
            }
        }
    }

}