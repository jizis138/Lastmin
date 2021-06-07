package ru.vsibi.presentation.screens.search.travallers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResult
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentTravellersBinding

class TravellersFragment : BaseFragment<FragmentTravellersBinding>(FragmentTravellersBinding::inflate, R.layout.fragment_travellers) {

    companion object {
        const val KEY_TRAVELLERS = "key_travellers"
    }

    override fun initViews() {
        binding.apply {

        }
    }

    override fun initArguments() {
        super.initArguments()
    }

    override fun initFragment() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.travellers)
    }

    override fun initListeners() {
        binding.apply {
            btnOk.setOnClickListener {
                setFragmentResult(KEY_TRAVELLERS, Bundle().apply { putParcelable(KEY_TRAVELLERS, TravellersModel(2, 3)) })
                popBack()
            }
            btnCancel.setOnClickListener {
                popBack()
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