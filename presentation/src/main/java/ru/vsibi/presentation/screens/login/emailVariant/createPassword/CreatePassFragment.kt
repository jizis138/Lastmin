package ru.vsibi.presentation.screens.login.emailVariant.createPassword

import androidx.appcompat.app.AppCompatActivity
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentCreatePasswordBinding

class CreatePassFragment : BaseFragment<FragmentCreatePasswordBinding>(
    FragmentCreatePasswordBinding::inflate,
    R.layout.fragment_create_password
) {

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
                router.navigateToMainFromCreatePass()
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