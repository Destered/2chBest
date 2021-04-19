package com.dester.a2chbest.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.a2chbest.api.model.Category
import com.dester.a2chbest.databinding.CategoryCardBinding
import java.util.*

class MainScreenAdapter: RecyclerView.Adapter<MainScreenAdapter.VH>() {

    private val items: ArrayList<Category> = arrayListOf()

    private var clickItem: ((String) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setClickAction(action: (String) -> Unit) {
        clickItem = action
    }

    fun addItem(item: Category) {
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

        fun bind(position: Int, boardCategory: Category) {
            binding.categoryName.text = boardCategory.name
            binding.categoryName.setOnClickListener {
                clickItem?.invoke(boardCategory.name)
            }
        }
    }
}