package ru.vsibi.presentation.screens.tours.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.vsibi.presentation.R
import ru.vsibi.presentation.databinding.CellHotelsBigBinding
import ru.vsibi.presentation.databinding.CellHotelsBinding
import ru.vsibi.presentation.helpers.Lastmin

class HotelsAdapter(private var itemClickListener: ((TourModel) -> Unit)? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VT_SMALL = 0
        private const val VT_BIG = 1
    }

    private var isSmallSize = true
    private val hotels = mutableListOf<TourModel>()
    fun setupAdapter(hotels: List<TourModel>) {
        this.hotels.clear()
        this.hotels.addAll(hotels)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VT_BIG -> {
                val binding = CellHotelsBigBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                BigHotelsViewHolder(binding)
            }
            VT_SMALL -> {
                val binding = CellHotelsBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                SmallHotelsViewHolder(binding)
            }
            else -> error("Unknown View Type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VT_BIG -> {
                (holder as BigHotelsViewHolder).bind(position)
            }
            VT_SMALL -> {
                (holder as SmallHotelsViewHolder).bind(position)
            }
            else -> error("Unknown View Type for holder $holder")
        }

    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isSmallSize) VT_SMALL else VT_BIG
    }

    fun displayBigSize() {
        isSmallSize = false
        notifyDataSetChanged()
    }

    fun displaySmallSize() {
        isSmallSize = true
        notifyDataSetChanged()
    }

    inner class SmallHotelsViewHolder(private val binding: CellHotelsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = hotels[position]
            binding.apply {
                Glide.with(root.context).load(item.image).apply(Lastmin.listRequestOpts).into(image)
                tvTitle.text = item.title
                tvDescription.text = item.location
                relCost.tvDate.text = item.dateStart + " - " + item.dateEnd
                relCost.tvCost.text = item.currency + " " + item.cost
                if (item.isFavorite) {
                    relCost.ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_pink)
                } else {
                    relCost.ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_border)
                }
                root.setOnClickListener {
                    itemClickListener?.invoke(item)
                }
            }
        }
    }

    inner class BigHotelsViewHolder(private val binding: CellHotelsBigBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = hotels[position]
            binding.apply {
                Glide.with(root.context).load(item.bigImage).apply(Lastmin.listRequestOpts).into(image)
                tvTitle.text = item.title
                tvDescription.text = item.location
                relCost.tvDate.text = item.dateStart + " - " + item.dateEnd
                relCost.tvCost.text = item.currency + " " + item.cost
                if (item.isFavorite) {
                    relCost.ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_pink)
                } else {
                    relCost.ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_border)
                }
                root.setOnClickListener {
                    itemClickListener?.invoke(item)
                }
            }
        }
    }

}