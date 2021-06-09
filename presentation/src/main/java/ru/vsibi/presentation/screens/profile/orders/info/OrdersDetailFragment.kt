package ru.vsibi.presentation.screens.profile.orders.info

import androidx.navigation.fragment.navArgs
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentOrdersDetailBinding
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

class OrdersDetailFragment : BaseFragment<FragmentOrdersDetailBinding>(FragmentOrdersDetailBinding::inflate, R.layout.fragment_orders_detail) {

    private val args : OrdersDetailFragmentArgs by navArgs()

    override fun initViews() {
        super.initViews()
    }

    override fun initArguments() {
        updateViews(args.hotel)
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        binding.relTicket1.setOnClickListener {
            router.navigateToTicket()
        }
        binding.relTicket2.setOnClickListener {
            router.navigateToTicket()
        }
    }

    override fun initData() {
        super.initData()
    }

    override fun initObservers() {
        super.initObservers()
    }

    private fun updateViews(hotel: HotelsModel) {
        binding.apply {
            tvTitle.text = hotel.title
            tvLocation.text = hotel.location
        }
    }
}