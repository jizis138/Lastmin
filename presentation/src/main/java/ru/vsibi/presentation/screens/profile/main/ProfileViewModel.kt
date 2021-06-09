package ru.vsibi.presentation.screens.profile.main

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.presentation.helpers.SharedPreferenceService
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val sharedPref: SharedPreferenceService
) : BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>() {

    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.LogOut -> signout()
        }
    }

    private fun signout() {
        sharedPref.clear()
        viewState = ProfileViewState.LoggedOut()
        viewAction = ProfileAction.ShowSnackBar(R.string.message_sign_out)
    }
}