package ru.vsibi.presentation.screens.login.emailVariant.email

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentLoginEmailBinding

class LoginEmailFragment :
    BaseFragment<FragmentLoginEmailBinding>(FragmentLoginEmailBinding::inflate, R.layout.fragment_login_email) {

    private val viewModel: LoginEmailViewModel by viewModels()
    private val args: LoginEmailFragmentArgs by navArgs()
    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.enter_email)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        if (args.isLogin) {
            binding.btnContinue.text = getString(R.string.next)
        } else {
            binding.btnContinue.text = getString(R.string.sign_up)
        }
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        binding.apply {
            btnContinue.setOnClickListener {
                viewModel.obtainEvent(LoginEmailEvent.ContinueWithEmail(tietEmail.text.toString().trim()))
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

    private fun bindViewState(state: LoginEmailViewState) {
        when (state) {
            is LoginEmailViewState.OnLoginEntered -> {
                if (args.isLogin) {
                    router.navigateToLoginPassword(state.data)
                } else {
                    router.navigateToCreatePassFromSignup(state.data)
                }
            }
        }
    }

    private fun bindViewActions(action: LoginEmailAction?) {}

}
