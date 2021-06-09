package ru.vsibi.presentation.screens.profile

import androidx.annotation.StringRes

sealed class ProfileAction {
    class ShowSnackBar(@StringRes val data : Int) : ProfileAction()
}
