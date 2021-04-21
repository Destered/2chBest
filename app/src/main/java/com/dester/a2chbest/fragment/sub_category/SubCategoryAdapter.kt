package com.dester.a2chbest.fragment.sub_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.a2chbest.api.model.SubCategory
import com.dester.a2chbest.databinding.CategoryCardBinding
import java.util.*

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.VH>() {

    private val items: ArrayList<SubCategory> = arrayListOf()

    private var clickItem: ((String) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<SubCategory>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setClickAction(action: (String) -> Unit) {
        clickItem = action
    }

    fun addItem(item: SubCategory) {
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

        fun bind(position: Int, boardCategory: SubCategory) {
            binding.name.text = boardCategory.name
            binding.root.setOnClickListener {
                clickItem?.invoke(boardCategory.name)
            }
        }
    }
}