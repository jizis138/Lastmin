package ru.vsibi.presentation.screens.login.emailVariant.forgotPassword

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentForgotPasswordBinding
import ru.vsibi.presentation.databinding.FragmentLoginEmailBinding
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordViewState

class ForgotPassFragment : BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate, R.layout.fragment_forgot_password) {

    private val viewModel : ForgotPassViewModel by viewModels()
    private val args : ForgotPassFragmentArgs by navArgs()

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.forgot_pass)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        binding.tietEmail.setText(args.email)
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        binding.apply {
            btnSendLink.setOnClickListener {
                viewModel.obtainEvent(ForgotPassEvent.SendResetLink(tietEmail.text.toString().trim()))
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

    private fun bindViewState(state: ForgotPassViewState) {
        when (state) {
            is ForgotPassViewState.OnSentLink -> router.navigateToCreatePassFromForgot()
        }
    }

    private fun bindViewActions(action: ForgotPassAction?) {}

}