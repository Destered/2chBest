package com.dester.a2chbest.fragment.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dester.a2chbest.api.response.BoardCategoryResponse
import com.dester.a2chbest.databinding.CategoryCardBinding
import java.util.ArrayList

class MainScreenAdapter: RecyclerView.Adapter<MainScreenAdapter.VH>() {

    private val items: ArrayList<String> = arrayListOf()

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: String) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryCardBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position, items[position])
    }


    inner class VH(private val binding: CategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, boardCategory: String) {
            binding.categoryName.text = boardCategory
        }
    }
}