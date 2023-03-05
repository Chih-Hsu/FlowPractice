package com.chihhsu.parking.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chihhsu.parking.R
import com.chihhsu.parking.data.ParkingUIModel
import com.chihhsu.parking.databinding.ItemParkingBinding

class HomeAdapter :
    ListAdapter<ParkingUIModel, HomeAdapter.HomeViewHolder>(HomeDiffUtil()) {

    class HomeDiffUtil : DiffUtil.ItemCallback<ParkingUIModel>() {
        override fun areItemsTheSame(
            oldItem: ParkingUIModel,
            newItem: ParkingUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ParkingUIModel,
            newItem: ParkingUIModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    class HomeViewHolder(private val binding: ItemParkingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ParkingUIModel) {
            binding.apply {
                textId.text = item.id
                textTitle.text = item.title
                textAddress.text = item.address
                textAvailableTotal.text = itemView.context.getString(
                    R.string.available_total,
                    item.availableCar,
                    item.totalCar
                )
                textChargingStandby.text = itemView.context.getString(
                    R.string.standby_charging,
                    item.standby ?: 0,
                    item.charging ?: 0
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemParkingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}