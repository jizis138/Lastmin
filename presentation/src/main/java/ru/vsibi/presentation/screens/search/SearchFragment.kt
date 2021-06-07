package ru.vsibi.presentation.screens.search

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentSearchBinding
import ru.vsibi.presentation.screens.search.travallers.TravellersFragment
import ru.vsibi.presentation.screens.search.travallers.TravellersModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate, R.layout.fragment_search) {

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
        }
    }

    override fun initData() {

    }

    override fun initObservers() {
        super.initObservers()
    }


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

