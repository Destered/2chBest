package com.dester.a2chbest.fragment.post


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
import java.util.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.VH>() {

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
            if (thread.subject.isEmpty()) {
                binding.threadName.visibility = View.GONE
            } else binding.threadName.text = thread.subject


            /*if(!thread.files.isNullOrEmpty()){
              var hasVideo = false
                val sliderImage = binding.postImage
                val images = arrayListOf<String>()
                thread.files.forEach {
                    if(it.path.contains("mp4") || it.path.contains("webm")){
                        hasVideo = true
                        return@forEach
                    }
                    images.add(ApiFactory.BASE_URL+it.path)
                }
                if(hasVideo){
                    images.clear()
                    binding.postImage.visibility = View.GONE
                }else{
                    sliderImage.setItems(images)
                }

            } else{
                binding.postImage.visibility = View.GONE
            }*/

            if (!thread.files.isNullOrEmpty()) {
                var hasVideo = false
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
        }
    }
}
