package ru.vsibi.presentation.screens.hotels.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentHotelsBinding

class HotelsFragment : BaseFragment<FragmentHotelsBinding>(FragmentHotelsBinding::inflate, R.layout.fragment_hotels) {

    private val viewModel : HotelsViewModel by viewModels()
    private val itemsClickListener: (HotelsModel) -> Unit = { hotel ->
        router.navigateToHotelsInfo(hotel)
    }
    private val adapter = HotelsAdapter(itemsClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.hotels)
    }

    override fun initViews() {
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

