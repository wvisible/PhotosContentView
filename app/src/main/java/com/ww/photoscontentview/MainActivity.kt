package com.ww.photoscontentview

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ww.photoscontentview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val imageList = mutableListOf(
        "https://cdn.pixabay.com/photo/2015/03/28/16/40/lake-696098_1280.jpg",
        "https://cdn.pixabay.com/photo/2014/07/30/02/00/iceberg-404966__480.jpg",
        "https://cdn.pixabay.com/photo/2012/10/30/15/55/hayden-valley-63564__480.jpg",
        "https://cdn.pixabay.com/photo/2015/07/28/22/11/wheat-865152__480.jpg",
        "https://cdn.pixabay.com/photo/2017/05/08/13/15/spring-bird-2295431__480.jpg",
        "https://cdn.pixabay.com/photo/2017/05/06/14/13/pathway-2289978__480.jpg",
        "https://cdn.pixabay.com/photo/2016/01/18/09/46/yoga-1146277__480.jpg",
        "https://cdn.pixabay.com/photo/2020/02/29/19/02/norderney-4890873__480.jpg",
        "https://cdn.pixabay.com/photo/2020/03/24/05/37/family-4962871__480.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val dataList = mutableListOf<Data>()
        for (index in imageList.indices) {
            dataList.add(Data("追风筝的人",
            "朴塘村的美，不张扬，不显露，不败落，不颓废，一切皆在四季的更替中，安然呈现。",
                imageList.subList(0, index + 1)))
        }
        binding.recyclerView.adapter = ImageAdapter(dataList)
    }
}
