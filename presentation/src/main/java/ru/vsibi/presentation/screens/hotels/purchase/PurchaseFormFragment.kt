package ru.vsibi.presentation.screens.hotels.purchase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentPurchaseFormBinding
import ru.vsibi.presentation.helpers.Lastmin
import ru.vsibi.presentation.screens.hotels.info.HotelsInfoFragmentArgs
import ru.vsibi.presentation.screens.hotels.main.HotelsModel

class PurchaseFormFragment :
    BaseFragment<FragmentPurchaseFormBinding>(FragmentPurchaseFormBinding::inflate, R.layout.fragment_purchase_form) {

    private val viewModel: PurchaseFormViewModel by viewModels()
    private val args: HotelsInfoFragmentArgs by navArgs()

    override fun initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.customer_purchase_form)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        viewModel.obtainEvent(PurchaseFormEvent.ConfigureArgs(args.hotel))
    }

    override fun initFragment() {
        super.initFragment()
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun initData() {
        super.initData()
    }

    override fun initObservers() {
        viewModel.viewStates().observe(viewLifecycleOwner) { bindViewState(it) }
        viewModel.viewActions().observe(viewLifecycleOwner) { bindViewActions(it) }
    }

    private fun bindViewState(state: PurchaseFormState) {
        when (state) {
            is PurchaseFormState.Loaded -> updateViews(state.data)
        }
    }

    private fun bindViewActions(action: PurchaseFormAction?) {

    }

    @SuppressLint("SetTextI18n")
    private fun updateViews(data: HotelsModel) {
        binding.apply {
            hotel.tvTitle.text = data.title
            hotel.tvDescription.text = data.location
            hotel.relCost.tvCost.text = "${data.currency} ${data.cost}"
            hotel.relCost.tvDate.text = "${data.dateStart} - ${data.dateEnd}"
            Glide.with(requireContext()).load(data.image).apply(Lastmin.listRequestOpts).into(hotel.image)
        }
    }

}