package ru.vsibi.presentation.helpers

import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.vsibi.data.LastminData.ApiVersion
import ru.vsibi.presentation.R
import java.text.SimpleDateFormat
import java.util.*

object Lastmin {

    val listRequestOpts = RequestOptions.centerCropTransform()
    val circleOprions = RequestOptions.circleCropTransform().placeholder(R.drawable.profile).diskCacheStrategy(
        DiskCacheStrategy.ALL)
    val dateFormatter = SimpleDateFormat("EEE, dd MMMM yyyy")

    fun getImageUrl(image : String) : String {
        return "https://apitest.fun:9595/api/$ApiVersion/storage/$image"
    }

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