package ru.vsibi.presentation.screens.profile.main

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentProfileBinding


@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate, R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun initViews() {
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

    override fun initListeners() {
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
        super.initData()
    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: ProfileViewState) {
        when (state) {
            is ProfileViewState.LoggedOut -> router.reopenApp()
        }
    }

    private fun bindViewActions(action: ProfileAction?) {
        when (action) {
            is ProfileAction.ShowSnackBar -> Snackbar.make(binding.root, getString(action.data), Snackbar.LENGTH_LONG)
                .show()
        }
    }

}