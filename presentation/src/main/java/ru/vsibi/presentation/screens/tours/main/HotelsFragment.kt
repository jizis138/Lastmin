package ru.vsibi.presentation.screens.tours.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentHotelsBinding

class HotelsFragment : BaseFragment<FragmentHotelsBinding>(FragmentHotelsBinding::inflate, R.layout.fragment_hotels) {

    private val viewModel : HotelsViewModel by viewModels()


    private val itemsClickListener: (TourModel) -> Unit = { hotel ->
        router.navigateToHotelsInfo(hotel)
    }
    private val adapter = HotelsAdapter(itemsClickListener)

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }

    override fun FragmentHotelsBinding.initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.hotels)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.rvHotels.configure()
    }

    override fun initData() {
        viewModel.obtainEvent(HotelsEvent.Default)
    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: HotelsViewState) {
        when (state) {
            is HotelsViewState.Loaded -> {
                adapter.setupAdapter(state.data)
            }
        }
    }

    private fun bindViewActions(action: HotelsAction?) {}

    private fun RecyclerView.configure() {
        adapter = this@HotelsFragment.adapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}

