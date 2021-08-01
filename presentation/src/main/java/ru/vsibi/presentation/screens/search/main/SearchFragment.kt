package ru.vsibi.presentation.screens.search.main

import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.facebook.internal.Utility.arrayList
import com.google.android.material.datepicker.MaterialDatePicker
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentSearchBinding
import ru.vsibi.presentation.screens.search.travallers.TravellersFragment
import ru.vsibi.presentation.screens.search.travallers.TravellersModel
import java.text.SimpleDateFormat
import java.util.*


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate, R.layout.fragment_search) {

    private var picker: MaterialDatePicker<Pair<Long, Long>>? = null
    private val viewModel: SearchViewModel by viewModels()
    private var isPickerOpened = false

    override fun onResume() {
        super.onResume()
        initOriginSpinner()
        initDestinationSpinner()
        isPickerOpened = false
    }

    override fun FragmentSearchBinding.initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.search)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }
        initRangeDatePicker()
    }


    override fun initArguments() {

    }

    override fun initFragment() {

    }

    override fun FragmentSearchBinding.initListeners() {
        setFragmentResultListener(TravellersFragment.KEY_TRAVELLERS) { requestKey, bundle ->
            val travellersModel = bundle.getParcelable(TravellersFragment.KEY_TRAVELLERS) as? TravellersModel
            binding.tvTravellers.setText("" + travellersModel?.adultsCount + " Adults, " + travellersModel?.childsCount + " Kids")
            viewModel.obtainEvent(SearchEvent.UpdatePersonsDesc("" + travellersModel?.adultsCount + " + " + travellersModel?.childsCount))
        }
        binding.apply {
            tvTravellers.setOnClickListener {
                router.navigateToTravellers()
            }
            btnSearch.setOnClickListener {
                viewModel.obtainEvent(SearchEvent.UpdateCountry(tvDestionation.text.toString().trim()))
                viewModel.obtainEvent(SearchEvent.StartSearch())
            }
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
                router.navigateHotels(viewModel.getSearchModel())
                viewModel.obtainEvent(SearchEvent.Default())
            }
            is SearchViewState.Default -> {
            }
        }
    }

    private fun bindViewActions(action: SearchAction?) {}


    private fun initOriginSpinner() {
//        val adapter = ArrayAdapter(
//            requireContext(),
//            R.layout.cell_spinner, SearchFactory.getCountryList()
//        )
        val editTextFilledExposedDropdown = binding.tvOrigin
//        editTextFilledExposedDropdown.setAdapter(adapter)
        val clickListener = View.OnClickListener {
            val popupMenu = PopupMenu(requireContext(), editTextFilledExposedDropdown, Gravity.END, 0, R.style.PopupMenuMoreCentralized)
//            popupMenu.gravity = Gravity.END
            val list = SearchFactory.getCountryList()
            for (i in list.indices) {
                popupMenu.menu.add(i, Menu.FIRST, i, list[i])
            }
            popupMenu.setOnMenuItemClickListener { menuItem ->
                editTextFilledExposedDropdown.setText(menuItem.title)
                false
            }
            popupMenu.show()
        }
        binding.tilOrigin.setEndIconOnClickListener(clickListener)
        editTextFilledExposedDropdown.setOnClickListener(clickListener)
//        {
//            it as AutoCompleteTextView
//            if (!it.isShown) {
//                it.showDropDown()
//            }
//        }
    }

    private fun initDestinationSpinner() {
//        val adapter = ArrayAdapter(
//            requireContext(),
//            R.layout.cell_spinner, SearchFactory.getCountryList()
//        )
        val editTextFilledExposedDropdown = binding.tvDestionation
//        editTextFilledExposedDropdown.setAdapter(adapter)
        val clickListener = View.OnClickListener {
            val popupMenu = PopupMenu(requireContext(), editTextFilledExposedDropdown, Gravity.END, 0, R.style.PopupMenuMoreCentralized)
            val list = SearchFactory.getCountryList()
            for (i in list.indices) {
                popupMenu.menu.add(i, Menu.FIRST, i, list[i])
            }
            popupMenu.setOnMenuItemClickListener { menuItem ->
                editTextFilledExposedDropdown.setText(menuItem.title)
                false
            }
            popupMenu.show()
        }
        binding.tilDestination.setEndIconOnClickListener(clickListener)
        editTextFilledExposedDropdown.setOnClickListener(clickListener)
//        {
//            it as AutoCompleteTextView
//            if (!it.isShown) {
//                it.showDropDown()
//            }

//        }
    }

    private fun initRangeDatePicker() {
        val builder = MaterialDatePicker.Builder.dateRangePicker()
        picker = builder.build()
        binding.tvDate.setOnClickListener {
            if (isPickerOpened) return@setOnClickListener
            isPickerOpened = true

            router.openDateRangeDialog()

//            picker?.show(childFragmentManager, picker.toString())
//            picker?.addOnPositiveButtonClickListener {
//                val formatter = SimpleDateFormat("dd.MM");
//                val dateString = formatter.format(Date(it.first));
//                binding.tvDate.setText(picker?.headerText)
//                viewModel.obtainEvent(SearchEvent.UpdateDate(dateString))
//                Log.d(
//                    "DatePicker Activity",
//                    "Date String = ${picker?.headerText}::  Date epoch values::${it.first}:: to :: ${it.second}"
//                )
//            }
//            picker?.addOnCancelListener {
//                isPickerOpened = false
//            }
//            picker?.addOnDismissListener {
//                isPickerOpened = false
//            }
        }
    }

}

