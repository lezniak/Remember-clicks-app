package com.example.navigationtask.ui.secondFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationtask.R
import com.example.navigationtask.databinding.CardclickBinding
import com.example.navigationtask.infrastructure.model.Click

class secondAdapter(list: List<Click>, requireContext: Context): RecyclerView.Adapter<secondViewHolder>() {
    private val requireContext = requireContext
    private val list = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): secondViewHolder =
        secondViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cardclick, parent, false))

    override fun onBindViewHolder(holder: secondViewHolder, position: Int) {
        holder.bind(list[position],requireContext,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class secondViewHolder(binding : CardclickBinding): RecyclerView.ViewHolder(binding.root){
    private val title = binding.title
    private val first = binding.first
    private val second = binding.second
    fun bind(item: Click, requireContext: Context,position: Int) {
        title.text = "Nr "+position.toString()
        first.text = item.buttonName
        second.text = item.data
    }

}