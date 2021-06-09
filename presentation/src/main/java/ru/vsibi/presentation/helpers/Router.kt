package ru.vsibi.presentation.helpers

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.vsibi.presentation.screens.hotels.info.HotelsInfoFragmentDirections
import ru.vsibi.presentation.screens.hotels.main.HotelsFragmentDirections
import ru.vsibi.presentation.screens.hotels.main.HotelsModel
import ru.vsibi.presentation.screens.login.LoginFragmentDirections
import ru.vsibi.presentation.screens.login.email.LoginEmailFragmentDirections
import ru.vsibi.presentation.screens.main.MainFragmentDirections
import ru.vsibi.presentation.screens.search.main.SearchFragmentDirections

class Router {

    companion object {
        val instance = Router()
    }

    var parentNavController : NavController? = null
    var parentNavHostFragment : NavHostFragment? = null
    var childNavHostFragment : NavHostFragment? = null
    var childNavController : NavController? = null

    fun navigateToTravellers() {
        childNavController?.navigate(SearchFragmentDirections.actionSearchFragmentToTravellersFragment())
    }

    fun navigateToLogin() {
        parentNavController?.navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
    }

    fun navigateToHotelsInfo(hotelsModel: HotelsModel) {
        childNavController?.navigate(HotelsFragmentDirections.actionHotelsFragmentToHotelsInfoFragment(hotelsModel))
    }

    fun navigateHotels() {
        childNavController?.navigate(SearchFragmentDirections.actionSearchFragmentToHotelsFragment())
    }

    fun navigatePurchaseForm(hotelsModel: HotelsModel) {
        childNavController?.navigate(HotelsInfoFragmentDirections.actionHotelsInfoFragmentToPurchaseFormFragment(hotelsModel))
    }

    fun navigateToLoginWithEmail() {
        parentNavController?.navigate(LoginFragmentDirections.actionLoginFragmentToLoginEmailFragment())
    }

    fun navigateToLoginPassword() {
        parentNavController?.navigate(LoginEmailFragmentDirections.actionLoginEmailFragmentToLoginPasswordFragment())
    }

}