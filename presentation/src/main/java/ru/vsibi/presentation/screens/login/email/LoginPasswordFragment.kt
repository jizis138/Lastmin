package ru.vsibi.presentation.screens.login.email

import androidx.appcompat.app.AppCompatActivity
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentLoginEmailBinding
import ru.vsibi.presentation.databinding.FragmentLoginPasswordBinding

class LoginPasswordFragment : BaseFragment<FragmentLoginPasswordBinding>(FragmentLoginPasswordBinding::inflate, R.layout.fragment_login_password) {

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.enter_password)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        super.initArguments()
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun initData() {
        super.initData()
    }

    override fun initObservers() {
        super.initObservers()
    }
}