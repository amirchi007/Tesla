package com.amir.neumorphism

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.neumorphism.databinding.CardViewBinding

class CardAdapter(private val dataList: List<Info>) :
    RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Info) {
            binding.txt1.text = item.txtOne
            binding.txt2.text = item.txtTwo
            binding.radioButton.isChecked = item.isSelected

            binding.radioButton.setOnClickListener {
                dataList.forEach { it.isSelected = false }
                item.isSelected = true
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
