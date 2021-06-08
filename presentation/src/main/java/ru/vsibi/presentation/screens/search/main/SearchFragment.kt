package ru.vsibi.presentation.screens.search.main

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentSearchBinding
import ru.vsibi.presentation.screens.hotels.main.HotelsAction
import ru.vsibi.presentation.screens.hotels.main.HotelsViewState
import ru.vsibi.presentation.screens.search.travallers.TravellersFragment
import ru.vsibi.presentation.screens.search.travallers.TravellersModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate, R.layout.fragment_search) {

    private val viewModel : SearchViewModel by viewModels()

    override fun initViews() {

    }

    override fun initArguments() {

    }

    override fun initFragment() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.search)
    }

    override fun initListeners() {
        setFragmentResultListener(TravellersFragment.KEY_TRAVELLERS){requestKey, bundle ->
            val travellersModel = bundle.getParcelable(TravellersFragment.KEY_TRAVELLERS) as? TravellersModel
            binding.tvTravellers.setText("" + travellersModel?.adultsCount + " Adults, " + travellersModel?.childsCount + " Kids")
        }
        binding.apply {
            tvTravellers.setOnClickListener {
                router.navigateToTravellers()
            }
            btnSearch.setOnClickListener {
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
                router.navigateHotels()
            }
        }
    }

    private fun bindViewActions(action: SearchAction?) {}



//    private fun initSpiner(flag: Int) {
//        val list = ArrayList<String>()
//        list.add("за день")
//        list.add("за неделю")
//        list.add("за месяц")
//        list.add("за всё время")
//        val sAdapter = ArrayAdapter(
//            this,
//            R.layout.item_graph_spinner, R.id.text1, list
//        )
//        spinner.setPopupBackgroundDrawable(
//            ViewUtils.generateBackgroundWithShadow(
//                spinner, R.color.white,
//                15.dp.toFloat(), R.color.grey_dark_card, 10.dp
//            )
//        )
//        sAdapter.notifyDataSetChanged()
//        sAdapter.setDropDownViewResource(R.layout.item_spinner_custom)
//        spinner.adapter = sAdapter
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                chart.clear()
//                isNeedClear = true
//                spinnerPosition = position
//                initData(spinnerPosition)
//            }
//
//        }
//    }
}

