package ru.vsibi.presentation.screens.profile.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import ru.vsibi.domain.network.response.ResponseProfile
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentProfileBinding


@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate, R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun FragmentProfileBinding.initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.profile)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }
        Glide.with(requireContext()).load(R.drawable.profile)
            .into(binding.profilePhoto)

    }

    override fun initArguments() {
        super.initArguments()
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun FragmentProfileBinding.initListeners() {
        binding.apply {
            linSignout.setOnClickListener {
                viewModel.obtainEvent(ProfileEvent.LogOut())
            }
            relOrders.setOnClickListener {
                router.navigateToMyOrders()
            }
            relPersonalData.setOnClickListener {
                router.navigateToPersonalData()
            }
            relCoTravellers.setOnClickListener {
                router.navigateToCoTravellers()
            }
            relChangePass.setOnClickListener {
                router.navigateToChangePass()
            }
        }
    }

    override fun initData() {
        viewModel.obtainEvent(ProfileEvent.FetchProfile())
    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: ProfileViewState) {
        when (state) {
            is ProfileViewState.LoggedOut -> router.reopenApp()
            is ProfileViewState.Error -> onError(state.error)
            is ProfileViewState.Loaded -> {
                binding.setProfileName(state.result)
            }
            is ProfileViewState.Loading -> {
            }
        }
    }

    private fun bindViewActions(action: ProfileAction?) {
        when (action) {
            is ProfileAction.ShowSnackBar -> Snackbar.make(binding.root, getString(action.data), Snackbar.LENGTH_LONG)
                .show()
        }
    }


    private fun FragmentProfileBinding.setProfileName(result: ResponseProfile.Result?) {
        val firstName = result?.first_name
        val secondName = result?.last_name
        if (firstName == null && secondName != null) {
            tvProfileName.text = secondName
        } else if (firstName != null && secondName == null) {
            tvProfileName.text = firstName
        } else if (firstName != null && secondName != null) {
            tvProfileName.text = "$firstName $secondName"
        } else {
            tvProfileName.text = ""
        }
    }
}
