package com.example.multipleactivities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleactivities.databinding.ItemRowBinding

class RVadapter(val arraylist: ArrayList<String>) : RecyclerView.Adapter<RVadapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arraylist[position]

        holder.binding.apply {
            textView.text = item
        }
    }

    override fun getItemCount(): Int = arraylist.size

}