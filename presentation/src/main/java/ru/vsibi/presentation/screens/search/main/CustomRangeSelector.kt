package ru.vsibi.presentation.screens.search.main

import android.annotation.SuppressLint
import androidx.core.util.Pair
import androidx.core.util.Preconditions
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.RangeDateSelector

//import com.google.android.material.datepicker.UtcDates

@SuppressLint("RestrictedApi")
class CustomRangeSelector : RangeDateSelector() {

    companion object {
        const val DAY_3_AGO = 259200000
        const val DAY_5_AGO = 432000000
    }

    private var selectedItem: Long? = null
    private var mode: MaterialDatePicker.RadioMode = MaterialDatePicker.RadioMode.DAYS_3

    override fun select(selection: Long) {
        selectedItem = selection
        var dayAgoMillis = 0
        if (mode == MaterialDatePicker.RadioMode.DAYS_3) {
            dayAgoMillis = DAY_3_AGO
        } else if (mode == MaterialDatePicker.RadioMode.DAYS_5) {
            dayAgoMillis = DAY_5_AGO
        }
        super.select(selectedItem!! - dayAgoMillis)
        super.select(selectedItem!! + dayAgoMillis)
    }

    override fun getSelectedDays(): MutableCollection<Long> {
        val selections = super.getSelectedDays()
        selectedItem?.let {
            selections.add(it)
        }
        return selections
    }

    fun switchRadioMode(mode: MaterialDatePicker.RadioMode?) {
        if (mode != null) {
            this.mode = mode
        }
        selectedItem?.let {
            select(it)
        }
    }
//
//    private fun create3daysAgo(): Collection<Pair<Long?, Long?>?> {
//        if (selectedItem == null) return emptyList()
//        val agodays = arrayListOf<Pair<Long?, Long?>?>()
//        agodays.add(Pair(selectedItem!!, selectedItem!! - 259200000))
//        agodays.add(Pair(selectedItem!!, selectedItem!! + 259200000))
//        return agodays
//    }
//
//    override fun getSelectedRanges(): Collection<Pair<Long?, Long?>?> {
//        val ranges = ArrayList<Pair<Long?, Long?>?>()
//        ranges.addAll(create3daysAgo())
//        return ranges
//    }
//
//    override fun getSelection(): Pair<Long, Long> {
//        return Pair(
//            selectedItem!! - 259200000,
//            selectedItem!! + 259200000
//        )
//    }
}