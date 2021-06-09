package ru.vsibi.presentation.screens.login.emailVariant.createPassword

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentCreatePasswordBinding
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordAction
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordViewState

@AndroidEntryPoint
class CreatePassFragment : BaseFragment<FragmentCreatePasswordBinding>(
    FragmentCreatePasswordBinding::inflate,
    R.layout.fragment_create_password
) {

    private val viewModel : CreatePassViewModel by viewModels()

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.app_name)
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
            btnCreatePass.setOnClickListener {
                viewModel.obtainEvent(CreatePassEvent.SignIn())
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

    private fun bindViewState(state: CreatePassState) {
        when (state) {
            is CreatePassState.Default -> {}
            is CreatePassState.LoggedIn -> router.navigateToMainFromCreatePass()
        }
    }


    private fun bindViewActions(action: CreatePassAction?) {}

}