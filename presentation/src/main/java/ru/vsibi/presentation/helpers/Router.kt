package ru.vsibi.presentation.helpers

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.vsibi.presentation.screens.hotels.info.HotelsInfoFragmentDirections
import ru.vsibi.presentation.screens.hotels.main.HotelsFragmentDirections
import ru.vsibi.presentation.screens.hotels.main.HotelsModel
import ru.vsibi.presentation.screens.login.LoginFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.createPassword.CreatePassFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.email.LoginEmailFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.forgotPassword.ForgotPassFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordFragmentDirections
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

    fun navigateToLoginPassword(data: String) {
        parentNavController?.navigate(LoginEmailFragmentDirections.actionLoginEmailFragmentToLoginPasswordFragment(data))
    }

    fun navigateToMainFromEmailLogin() {
        parentNavController?.navigate(LoginPasswordFragmentDirections.actionLoginPasswordFragmentToMainFragment())
    }

    fun reopenApp() {
        parentNavController?.navigate(MainFragmentDirections.actionMainFragmentSelf())
    }

    fun navigateToCreatePassFromForgot() {
        parentNavController?.navigate(ForgotPassFragmentDirections.actionForgotPassFragmentToCreatePassFragment())
    }

    fun navigateForgotPass(email : String) {
        parentNavController?.navigate(LoginPasswordFragmentDirections.actionLoginPasswordFragmentToForgotPassFragment(email))
    }

    fun navigateToMainFromCreatePass() {
        parentNavController?.navigate(CreatePassFragmentDirections.actionCreatePassFragmentToMainFragment())
    }


}