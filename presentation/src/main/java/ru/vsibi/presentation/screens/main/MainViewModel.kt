package ru.vsibi.presentation.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vsibi.data.SharedPreferenceService
import ru.vsibi.data.SharedPreferenceService.Companion.KEY_AUTH
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val sharedPref: SharedPreferenceService
) : ViewModel() {

    var isAuth = sharedPref.getSpString(KEY_AUTH) != null
}