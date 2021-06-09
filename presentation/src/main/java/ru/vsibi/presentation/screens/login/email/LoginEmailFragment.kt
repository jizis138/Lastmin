package ru.vsibi.presentation.screens.login.email

import androidx.appcompat.app.AppCompatActivity
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentLoginEmailBinding

class LoginEmailFragment : BaseFragment<FragmentLoginEmailBinding>(FragmentLoginEmailBinding::inflate, R.layout.fragment_login_email) {

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.enter_email)
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
        binding.apply {
            btnContinue.setOnClickListener {
                router.navigateToLoginPassword()
            }
        }
    }

    override fun initData() {
        super.initData()
    }

    override fun initObservers() {
        super.initObservers()
    }
}