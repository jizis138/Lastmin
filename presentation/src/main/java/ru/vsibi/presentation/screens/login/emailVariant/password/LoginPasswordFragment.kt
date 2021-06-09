package ru.vsibi.presentation.screens.login.emailVariant.password

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentLoginPasswordBinding

@AndroidEntryPoint
class LoginPasswordFragment : BaseFragment<FragmentLoginPasswordBinding>(FragmentLoginPasswordBinding::inflate, R.layout.fragment_login_password) {

    private val args : LoginPasswordFragmentArgs by navArgs()
    private val viewModel : LoginPasswordViewModel by viewModels()

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.enter_password)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        viewModel.obtainEvent(LoginPasswordEvent.ConfigureArgs(args.email))
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        binding.apply {
            btnSignIn.setOnClickListener {
                viewModel.obtainEvent(LoginPasswordEvent.SignIn())
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

    private fun bindViewState(state: LoginPasswordViewState) {
        when (state) {
            is LoginPasswordViewState.Loaded -> updateViews(state.data)
            is LoginPasswordViewState.LoggedIn -> router.navigateToMainFromEmailLogin()
        }
    }


    private fun bindViewActions(action: LoginPasswordAction?) {}

    private fun updateViews(data: String) {
        binding.tvPassDesc.text = "${getString(R.string.enter_password_desc)} $data"
    }

}