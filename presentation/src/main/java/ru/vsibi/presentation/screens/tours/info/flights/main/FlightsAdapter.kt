package ru.vsibi.presentation.screens.tours.info.flights.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vsibi.presentation.databinding.CellFlightsBinding

class FlightsAdapter(private var itemClickListener: ((FlightsModel) -> Unit)? = null) :
    RecyclerView.Adapter<FlightsAdapter.FlightsViewHolder>() {

    private val flights = mutableListOf<FlightsModel>()

    fun setupAdapter(flights: List<FlightsModel>) {
        this.flights.clear()
        this.flights.addAll(flights)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightsViewHolder {
        val binding = CellFlightsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FlightsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    inner class FlightsViewHolder(private val binding: CellFlightsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = flights[position]
            binding.apply {
                root.setOnClickListener {
                    itemClickListener?.invoke(item)
                }
            }
        }
    }

}