package ru.vsibi.presentation.screens.profile.personalData

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentPersonalDataBinding
import ru.vsibi.presentation.models.PersonalDataModel
import ru.vsibi.presentation.screens.search.main.SearchEvent
import java.text.SimpleDateFormat
import java.util.*

class PersonalDataFragment :
    BaseFragment<FragmentPersonalDataBinding>(FragmentPersonalDataBinding::inflate, R.layout.fragment_personal_data) {

    private val args: PersonalDataFragmentArgs by navArgs()
    private var picker: MaterialDatePicker<Long>? = null

    companion object {
        const val KEY_PERSONAL_DATA = "key_personal_data"
    }

    override fun FragmentPersonalDataBinding.initViews() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.personal_data)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun initArguments() {
        args.person?.let { person ->
            updateViews(person)
        }
    }

    override fun FragmentPersonalDataBinding.initListeners() {
        tietDob.setOnClickListener {
            showDatePicker()
        }
        btnSave.setOnClickListener {
            val id = args.person?.id ?: 1
            setFragmentResult(KEY_PERSONAL_DATA, Bundle().apply {
                putParcelable(
                    KEY_PERSONAL_DATA, PersonalDataModel(
                        id,
                        tietName.text.toString().trim(),
                        tietDob.text.toString().trim(),
                        tietEmail.text.toString().trim(),
                        tietPhone.text.toString().trim(),
                        PersonalDataModel.Passport(
                            tietNumber.text.toString().trim(),
                            tietCountry.text.toString().trim(),
                            tietDoe.text.toString().trim()
                        )
                    )
                )
            })
            popBack()
        }
    }

    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val calendar = Calendar.getInstance()
        calendar.set(1990, 1, 15)
        val startFrom = calendar.timeInMillis
        val constraints = CalendarConstraints.Builder()
            .setOpenAt(startFrom)
            .build()
        builder.setCalendarConstraints(constraints).setTitleText(getString(R.string.dob))

        picker = builder.build()
        picker?.show(childFragmentManager, picker.toString())
        picker?.addOnPositiveButtonClickListener {
            val formatter = SimpleDateFormat("dd/MM/yyyy");
            val dateString = formatter.format(Date(it));
            binding.tietDob.setText(dateString)

            Log.d(
                "DatePicker Activity",
                "Date String = ${picker?.headerText}::  Date epoch values::${it}"
            )
        }
    }

    private fun updateViews(person: PersonalDataModel) {
        binding.apply {
            tietCountry.setText(person.passport.country)
            tietDoe.setText(person.passport.dateOfExpiry)
            tietNumber.setText(person.passport.number)
            tietDob.setText(person.dateOfBirth)
            tietEmail.setText(person.email)
            tietName.setText(person.name)
            tietPhone.setText(person.phoneNumber)
        }
        if(person.id == 1){
            (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.adult)
        }else{
            (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.kid)
        }
    }

}