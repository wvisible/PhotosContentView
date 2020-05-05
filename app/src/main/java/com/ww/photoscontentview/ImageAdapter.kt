package com.ww.photoscontentview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ww.photoscontentview.databinding.RecyclerItemImageBinding

class ImageAdapter(private val dataList: MutableList<Data>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(RecyclerItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val bean = dataList[position]
        holder.bind(bean)
    }

    class ImageViewHolder(private val binding: RecyclerItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bean: Data) {
            binding.nickname.text = bean.nickname
            binding.content.text = bean.content
            binding.photosContentView.setAdapter(object : PhotosContentViewAdapter<String>() {
                override fun onDisplayImage(context: Context, imageView: ImageView, data: String) {
                    Glide.with(context)
                        .load(data)
                        .apply(
                            RequestOptions().transform(
                            MultiTransformation(CenterCrop(), RoundedCorners(20))
                        ))
                        .into(imageView)
                }

                override fun onItemImageClick(
                    context: Context, imageView: ImageView,
                    index: Int, list: MutableList<String>) {
                    Toast.makeText(context, list[index], Toast.LENGTH_LONG).show()
                }
            })
            binding.photosContentView.setImageData(bean.photoList)
        }
    }
}