package ru.vsibi.presentation.screens.tours.info.flights.info

import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentFligthsBinding
import ru.vsibi.presentation.databinding.FragmentFligthsInfoBinding
import ru.vsibi.presentation.screens.tours.info.flights.main.FlightsModel

class FlightsInfoFragment :
    BaseFragment<FragmentFligthsInfoBinding>(FragmentFligthsInfoBinding::inflate, R.layout.fragment_fligths_info) {

    override fun initViews() {

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

