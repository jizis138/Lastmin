package ru.vsibi.presentation.screens.hotels.info

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentHotelsInfoBinding
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

class HotelsInfoFragment :
    BaseFragment<FragmentHotelsInfoBinding>(FragmentHotelsInfoBinding::inflate, R.layout.fragment_hotels_info) {

    private val args: HotelsInfoFragmentArgs by navArgs()
    private val viewModel: HotelsInfoViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun initViews() {

    }

    override fun initArguments() {
        viewModel.obtainEvent(HotelsInfoEvent.ConfigureArgs(args.hotel))
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        binding.apply {
            fabBack.setOnClickListener {
                popBack()
            }
        }
    }

    override fun initData() {
        super.initData()
    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: HotelsInfoState) {
        when (state) {
            is HotelsInfoState.Loaded -> updateViews(state.data)
        }
    }


    private fun bindViewActions(action: HotelsInfoAction?) {

    }

    private fun updateViews(data: HotelsModel) {
        binding.apply {
            tvTitle.text = data.title
            tvLocation.text = data.location
            tvDescription.text = data.description
            Glide.with(requireContext()).load(data.image).into(image)
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }

}