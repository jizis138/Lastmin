package ru.vsibi.presentation.screens.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.vsibi.presentation.R
import ru.vsibi.presentation.databinding.CellHotelsBinding

class HotelsAdapter(private var itemClickListener: ((HotelsModel, Boolean) -> Unit)? = null) :
    RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder>() {

    private val hotels = mutableListOf<HotelsModel>()

    fun setupAdapter(hotels: List<HotelsModel>) {
        this.hotels.clear()
        this.hotels.addAll(hotels)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        val binding = CellHotelsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    inner class HotelsViewHolder(private val binding: CellHotelsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = hotels[position]
            binding.apply {
                Glide.with(root.context).load(item.image).into(image)
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvDate.text = item.dateStart + " - " + item.dateEnd
                tvCost.text = item.currency + " " + item.cost
                if(item.isFavorite){
                    ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_pink)
                }else{
                    ibFavorite.setImageResource(R.drawable.ic_icon_action_favorite_border)
                }
            }
        }
    }

}