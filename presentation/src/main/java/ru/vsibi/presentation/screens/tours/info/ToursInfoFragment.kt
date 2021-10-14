package ru.vsibi.presentation.screens.tours.info

import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ru.vsibi.domain.network.response.ResponseSearch
import ru.vsibi.helper.getDateDayMonth
import ru.vsibi.helper.getPlaceText
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentHotelsInfoBinding
import ru.vsibi.presentation.helpers.Lastmin
import ru.vsibi.presentation.screens.tours.main.TourModel


class ToursInfoFragment :
    BaseFragment<FragmentHotelsInfoBinding>(FragmentHotelsInfoBinding::inflate, R.layout.fragment_hotels_info) {

    private val args: ToursInfoFragmentArgs by navArgs()
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
//                viewModel.tour?.let { it1 -> router.navigatePurchaseForm(it1) }
            }
            tvMore.setOnClickListener {
//                router.navigateTourMore(viewModel.tour)
            }
            tvFlightDetails.setOnClickListener {
                router.navigateToFlightDetails()
            }
            image.setOnClickListener {
                viewModel.tour?.tour?.hotel?.hotel_images?.let {
                    router.navigatePhotoViewerFromTourInfo(it.toList().map { hotelImage->
                        hotelImage.file_name
                    })
                }
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

    private fun updateViews(data: ResponseSearch.Result) {
        binding.apply {
            tvTitle.text = data.tour.hotel.name
            val regionName = data.tour.hotel.place.resort.region.region_name?.name?:"Resort"
            val countryName = data.tour.hotel.place.resort.region.country.country_name?.name
            tvLocation.text = getPlaceText(regionName, countryName)
//            tvDescription.text = data.description
            Glide.with(requireContext()).load(Lastmin.getImageUrl(data.tour.hotel.hotel_images[0].file_name)).apply(
                Lastmin.listRequestOpts).into(image)

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