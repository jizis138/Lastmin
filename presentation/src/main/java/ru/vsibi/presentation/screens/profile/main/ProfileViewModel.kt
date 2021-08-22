package ru.vsibi.presentation.screens.profile.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.vsibi.data.api.profile.ProfileRepository
import ru.vsibi.helper.Status
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseViewModel
import ru.vsibi.data.SharedPreferenceService
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val sharedPref: SharedPreferenceService,
    private val profileRepository: ProfileRepository
) : BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>() {

    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.LogOut -> signout()
            is ProfileEvent.FetchProfile -> fetchProfile()
        }
    }

    private fun fetchProfile() {
        viewState = ProfileViewState.Loading()
        viewModelScope.launchOnIO {
            val response = profileRepository.get()
            withContext(Dispatchers.Main) {
                when (response.status) {
                    Status.SUCCESS -> {
                        viewState = ProfileViewState.Loaded()
                    }
                    Status.ERROR -> {
                        viewState = ProfileViewState.Error(response.error)
                    }
                }
            }
        }
    }

    private fun signout() {
        sharedPref.clear()
        viewState = ProfileViewState.LoggedOut()
        viewAction = ProfileAction.ShowSnackBar(R.string.message_sign_out)
    }
}