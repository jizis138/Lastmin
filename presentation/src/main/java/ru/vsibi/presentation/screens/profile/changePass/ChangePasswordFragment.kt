package ru.vsibi.presentation.screens.profile.changePass

import androidx.appcompat.app.AppCompatActivity
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment : BaseFragment<FragmentChangePasswordBinding>(FragmentChangePasswordBinding::inflate, R.layout.fragment_change_password) {

    override fun FragmentChangePasswordBinding.initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.change_pass)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
}