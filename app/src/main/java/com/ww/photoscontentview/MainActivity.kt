package com.ww.photoscontentview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ww.photoscontentview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val dataList = mutableListOf(
//        "https://cdn.pixabay.com/photo/2015/03/28/16/40/lake-696098_1280.jpg",
//        "https://cdn.pixabay.com/photo/2014/07/30/02/00/iceberg-404966__480.jpg",
//        "https://cdn.pixabay.com/photo/2012/10/30/15/55/hayden-valley-63564__480.jpg",
//        "https://cdn.pixabay.com/photo/2015/07/28/22/11/wheat-865152__480.jpg",
//        "https://cdn.pixabay.com/photo/2017/05/08/13/15/spring-bird-2295431__480.jpg",
        "https://cdn.pixabay.com/photo/2017/05/06/14/13/pathway-2289978__480.jpg",
        "https://cdn.pixabay.com/photo/2016/01/18/09/46/yoga-1146277__480.jpg",
        "https://cdn.pixabay.com/photo/2020/02/29/19/02/norderney-4890873__480.jpg",
        "https://cdn.pixabay.com/photo/2020/03/24/05/37/family-4962871__480.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.photosContentView.setAdapter(object : PhotosContentViewAdapter<String>() {
            override fun onDisplayImage(context: Context, imageView: ImageView, data: String) {
                Glide.with(context)
                    .load(data)
                    .apply(RequestOptions().transform(
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
        binding.photosContentView.setImageData(dataList)
    }
}
