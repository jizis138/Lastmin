package ru.vsibi.presentation.helpers

import android.view.View
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

object Lastmin {

    val listRequestOpts = RequestOptions.centerCropTransform()
    val dateFormatter = SimpleDateFormat("EEE, dd MMMM yyyy")

    fun View.gone() {
        this.visibility = View.GONE
    }
    fun View.invis() {
        this.visibility = View.INVISIBLE
    }
    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun getStringDate(long : Long) : String{
        return dateFormatter.format(Date(long))
    }
}