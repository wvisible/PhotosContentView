# PhotosContentView
仿照朋友圈、微博展示的九宫格图片，支持使用Glide、Picasso等加载图片，支持点击事件，使用简单

该项目是根据 [https://github.com/jeasonlzy/NineGridView](https://github.com/jeasonlzy/NineGridView) 修改的 kotlin 版本

#### 效果
![](https://github.com/wvisible/PhotosContentView/blob/master/demonstrate.gif)
#### 如何使用
下载源码通过如下方式集成或者直接复制源码：
```
implementation project(':photoscontentview')
```
初始化适配器并设置：
```
photosContentView.setAdapter(object : PhotosContentViewAdapter<String>() {
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
```
然后设置数据源：
```
photosContentView.setImageData(bean.photoList)
```
#### 项目功能
- 支持设置单张大图尺寸
- 支持fill和grid两种模式，grid模式下4张图片显示2*2
- 自动根据图片张数调整大小
- 根据适配器模式设置图片加载和自定义的ImageView
- 支持Glide、Picasso等加载图片
- 支持点击事件

#### License  
PhotosContentView is licensed under the Apache License 2.0. See the LICENSE.txt file for more information.
