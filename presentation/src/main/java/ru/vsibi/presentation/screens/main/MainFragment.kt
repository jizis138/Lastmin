package ru.vsibi.presentation.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import ru.movemove.presentation.helpers.Router
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate, R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun initViews() {
        navHostFragment = childFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        router.childNavController = navHostFragment?.navController
        router.childNavHostFragment = navHostFragment
        router.parentNavController = findNavController()
        navHostFragment?.navController?.let { NavigationUI.setupWithNavController(binding.bottomNavigationView, it) }
        navHostFragment?.navController?.addOnDestinationChangedListener { _, destination, _ ->
            log("destination " + destination.label)
            when (destination.id) {
                R.id.travellersFragment -> hideNavigation()
                else -> showNavigation()
            }
        }
    }

    override fun initFragment() {
        if (viewModel.isAuth) {
            binding.bottomNavigationView.menu.getItem(4).title = getString(R.string.profile)
        } else {
            binding.bottomNavigationView.menu.getItem(4).title = getString(R.string.sign_in)

            binding.bottomNavigationView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.profileFragment->{
                        router.navigateToLogin()
                    }
                    else -> {
                        navHostFragment?.navController?.let { it1 -> NavigationUI.onNavDestinationSelected(it, it1) }
                    }
                }
                return@setOnNavigationItemSelectedListener false
            }
        }
    }

    fun showNavigation() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    fun hideNavigation() {
        binding.bottomNavigationView.visibility = View.GONE
    }

}

