package ru.vsibi.presentation.screens.tours.info.more

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentTourMoreBinding

class TourMoreFragment :
    BaseFragment<FragmentTourMoreBinding>(FragmentTourMoreBinding::inflate, R.layout.fragment_tour_more) {

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }
    override fun initViews() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                popBack()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }
}