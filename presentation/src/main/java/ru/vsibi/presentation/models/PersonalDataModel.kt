package ru.vsibi.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonalDataModel(
    val name : String,
    val dateOfBirth : String,
    val email : String,
    val phoneNumber : String,
    val passport : Passport
) : Parcelable {

    @Parcelize
    class Passport(
        val number : String,
        val country : String,
        val dateOfExpiry : String
    ) : Parcelable
}