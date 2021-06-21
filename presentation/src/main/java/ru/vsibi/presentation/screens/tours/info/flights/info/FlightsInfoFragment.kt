package ru.vsibi.presentation.screens.tours.info.flights.info

import androidx.viewpager2.widget.ViewPager2
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentFligthsInfoBinding

class FlightsInfoFragment :
    BaseFragment<FragmentFligthsInfoBinding>(FragmentFligthsInfoBinding::inflate, R.layout.fragment_fligths_info) {

    override fun FragmentFligthsInfoBinding.initViews() {

        binding.viewpager.configure()
    }

    private fun ViewPager2.configure() {
        val fragments = mutableListOf<FlightsInfoModel>()
        fragments.add(FlightsInfoModel())
        fragments.add(FlightsInfoModel())
        fragments.add(FlightsInfoModel())
        adapter = FlightsInfoAdapter(
            childFragmentManager, lifecycle, fragments
        )
    }
}

