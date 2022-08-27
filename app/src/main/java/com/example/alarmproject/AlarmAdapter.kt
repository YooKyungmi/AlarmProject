package com.example.alarmproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmproject.databinding.ItemViewBinding

class AlarmAdapter(private val alarms: List<UserData>): RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,   //recyclerview
            false)
        return ViewHolder(binding).also{ holder->
            binding.onoffSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                alarms.getOrNull(holder.absoluteAdapterPosition)?.power = isChecked

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {  //position 리스트 상에서 몇번째인지
            holder.bind(alarms[position])
    }

    override fun getItemCount(): Int =alarms.size

    class ViewHolder(private val binding: ItemViewBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(alarm: UserData){
                //ampm = alarm.AMPM
                binding.settingTime.text=alarm.time
                binding.settingDate.text=alarm.date
                binding.onoffSwitch.isChecked=alarm.power
            }
    }
}