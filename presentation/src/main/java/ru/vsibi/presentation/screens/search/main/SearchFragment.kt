package ru.vsibi.presentation.screens.search.main

import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentSearchBinding
import ru.vsibi.presentation.screens.search.travallers.TravellersFragment
import ru.vsibi.presentation.screens.search.travallers.TravellersModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate, R.layout.fragment_search) {

    private var picker: MaterialDatePicker<Pair<Long, Long>>? = null
    private val viewModel: SearchViewModel by viewModels()
    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.search)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }
        initOriginSpinner()
        initDestinationSpinner()
        initRangeDatePicker()
    }


    override fun initArguments() {

    }

    override fun initFragment() {

    }

    override fun initListeners() {
        setFragmentResultListener(TravellersFragment.KEY_TRAVELLERS) { requestKey, bundle ->
            val travellersModel = bundle.getParcelable(TravellersFragment.KEY_TRAVELLERS) as? TravellersModel
            binding.tvTravellers.setText("" + travellersModel?.adultsCount + " Adults, " + travellersModel?.childsCount + " Kids")
        }
        binding.apply {
            tvTravellers.setOnClickListener {
                router.navigateToTravellers()
            }
//            btnSearch.setOnClickListener {
//                viewModel.obtainEvent(SearchEvent.StartSearch())
//            }
        }
    }

    override fun initData() {

    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: SearchViewState) {
        when (state) {
            is SearchViewState.Loading -> {
                binding.progress.visibility = View.VISIBLE
                binding.btnSearch.alpha = 0.5f
            }
            is SearchViewState.Loaded -> {
                binding.progress.visibility = View.GONE
                binding.btnSearch.alpha = 1f
                router.navigateHotels()
                viewModel.obtainEvent(SearchEvent.Default())
            }
            is SearchViewState.Default -> {
            }
        }
    }

    private fun bindViewActions(action: SearchAction?) {}


    private fun initOriginSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.cell_spinner, SearchFactory.getCountryList()
        )
        val editTextFilledExposedDropdown = binding.tvOrigin
        editTextFilledExposedDropdown.setAdapter(adapter)
        editTextFilledExposedDropdown.setOnClickListener {
            it as AutoCompleteTextView
            if (!it.isShown) {
                it.showDropDown()
            }
        }
    }

    private fun initDestinationSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.cell_spinner, SearchFactory.getCountryList()
        )
        val editTextFilledExposedDropdown = binding.tvDestionation
        editTextFilledExposedDropdown.setAdapter(adapter)
        editTextFilledExposedDropdown.setOnClickListener {
            it as AutoCompleteTextView
            if (!it.isShown) {
                it.showDropDown()
            }
        }
    }

    private fun initRangeDatePicker() {
        val builder = MaterialDatePicker.Builder.dateRangePicker()

        picker = builder.build()
        binding.tvDate.setOnClickListener {
            picker?.show(childFragmentManager, picker.toString())
            picker?.addOnPositiveButtonClickListener {
                binding.tvDate.setText(picker?.headerText)
                Log.d(
                    "DatePicker Activity",
                    "Date String = ${picker?.headerText}::  Date epoch values::${it.first}:: to :: ${it.second}"
                )
            }
        }
    }

}

