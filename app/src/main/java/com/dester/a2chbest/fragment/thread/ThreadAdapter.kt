package com.dester.a2chbest.fragment.thread

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.asura.library.posters.Poster
import com.asura.library.posters.RemoteImage
import com.asura.library.posters.RemoteVideo
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.model.Post
import com.dester.a2chbest.databinding.ThreadCardBinding
import com.dester.a2chbest.utils.StringHelper
import timber.log.Timber
import java.util.*

class ThreadAdapter(
    val openPost: (String) -> Unit
) : RecyclerView.Adapter<ThreadAdapter.VH>() {

    private val items: ArrayList<Post> = arrayListOf()


    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Post>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: Post) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ThreadCardBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position, items[position])
    }


    inner class VH(private val binding: ThreadCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, thread: Post) {
            binding.threadName.text = thread.subject
            Timber.d("threadAdapter: get item= {${thread.comment}}")

            if (!thread.files.isNullOrEmpty()) {
                val sliderContent = binding.postSlider
                val files = arrayListOf<Poster>()
                thread.files.forEach {
                    if (it.durationSecs > 0) {
                        files.add(RemoteVideo((ApiFactory.BASE_URL + it.path).toUri()))
                    } else {
                        files.add(RemoteImage(ApiFactory.BASE_URL + it.path))
                    }
                }
                sliderContent.setPosters(files)
            } else {
                binding.postSlider.visibility = View.GONE
            }

            binding.username.text = "${thread.name} #${thread.num}"
            binding.date.text = thread.date

            binding.description.text = StringHelper.parseHtml(thread.comment)
            binding.root.setOnClickListener {
                Timber.d("dest/MainScreenAdapter: clickOnItem= ${thread.num}")
                openPost.invoke(thread.num)
            }
        }
    }
}
