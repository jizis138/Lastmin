package ru.movemove.presentation.helpers

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.vsibi.presentation.screens.main.MainFragmentDirections
import ru.vsibi.presentation.screens.search.SearchFragmentDirections

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

}