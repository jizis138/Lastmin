package ru.vsibi.presentation.screens.profile.main

import ru.vsibi.helper.IError
import ru.vsibi.presentation.screens.login.LoginViewState

sealed class ProfileViewState {
    class LoggedOut() : ProfileViewState()
    class Loading() : ProfileViewState()
    class Loaded() : ProfileViewState()
    class Error(val error: IError?) : ProfileViewState()
}
