package ru.vsibi.presentation.screens.profile.personalData

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import ru.vsibi.presentation.R
import ru.vsibi.presentation.base.BaseFragment
import ru.vsibi.presentation.databinding.FragmentPersonalDataBinding
import ru.vsibi.presentation.models.PersonalDataModel

class PersonalDataFragment :
    BaseFragment<FragmentPersonalDataBinding>(FragmentPersonalDataBinding::inflate, R.layout.fragment_personal_data) {

    private val args: PersonalDataFragmentArgs by navArgs()

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
    }

}