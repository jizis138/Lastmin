package ru.vsibi.presentation.screens.tours.info

import android.widget.AutoCompleteTextView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentHotelsInfoBinding
import ru.vsibi.presentation.screens.tours.info.more.TourMoreFragmentArgs
import ru.vsibi.presentation.screens.tours.main.TourModel


class ToursInfoFragment :
    BaseFragment<FragmentHotelsInfoBinding>(FragmentHotelsInfoBinding::inflate, R.layout.fragment_hotels_info) {

    private val args: TourMoreFragmentArgs by navArgs()
    private val viewModel: ToursInfoViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        initBoardingSpinner()
        initRoomsSpinner()
        initTransferSpinner()
    }

    override fun FragmentHotelsInfoBinding.initViews() {

    }

    override fun initArguments() {
        viewModel.obtainEvent(ToursInfoEvent.ConfigureArgs(args.tour))
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun FragmentHotelsInfoBinding.initListeners() {
        binding.apply {
            fabBack.setOnClickListener {
                popBack()
            }
            btnBook.setOnClickListener {
                viewModel.tour?.let { it1 -> router.navigatePurchaseForm(it1) }
            }
            tvMore.setOnClickListener {
                router.navigateTourMore(viewModel.tour)
            }
            tvFlightDetails.setOnClickListener {
                router.navigateToFlightDetails()
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

    private fun bindViewState(state: ToursInfoState) {
        when (state) {
            is ToursInfoState.Loaded -> updateViews(state.data)
        }
    }

    private fun bindViewActions(action: ToursInfoAction?) {

    }

    private fun updateViews(data: TourModel) {
        binding.apply {
            tvTitle.text = data.title
            tvLocation.text = data.location
            tvDescription.text = data.description
            Glide.with(requireContext()).load(data.bigImage).into(image)
        }
    }

    private fun initBoardingSpinner() {
        val adapter = TourMenuAdapter(
            requireContext(),
            R.layout.cell_spinner_tour, TourInfoFactory.getBoardingList()
        )
        val editTextFilledExposedDropdown = binding.tvBoarding
        editTextFilledExposedDropdown.setAdapter(adapter)
        editTextFilledExposedDropdown.setOnClickListener {
            it as AutoCompleteTextView
            if (!it.isShown) {
                it.showDropDown()
            }
        }
        editTextFilledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            binding.tvBoarding.setText((binding.tvBoarding.adapter.getItem(position) as TourCellModel).title, false);
        }
    }

    private fun initRoomsSpinner() {
        val adapter = TourMenuAdapter(
            requireContext(),
            R.layout.cell_spinner_tour, TourInfoFactory.getRoomTypesList()
        )
        val editTextFilledExposedDropdown = binding.tvRoomType
        editTextFilledExposedDropdown.setAdapter(adapter)
        editTextFilledExposedDropdown.setOnClickListener {
            it as AutoCompleteTextView
            if (!it.isShown) {
                it.showDropDown()
            }
        }
        editTextFilledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            binding.tvRoomType.setText((binding.tvRoomType.adapter.getItem(position) as TourCellModel).title, false);
        }
    }

    private fun initTransferSpinner() {
        val adapter = TourMenuAdapter(
            requireContext(),
            R.layout.cell_spinner_tour, TourInfoFactory.getTransferList()
        )
        val editTextFilledExposedDropdown = binding.tvTransfer
        editTextFilledExposedDropdown.setAdapter(adapter)
        editTextFilledExposedDropdown.setOnClickListener {
            it as AutoCompleteTextView
            if (!it.isShown) {
                it.showDropDown()
            }
        }
        editTextFilledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            binding.tvTransfer.setText((binding.tvTransfer.adapter.getItem(position) as TourCellModel).title, false);
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }

}