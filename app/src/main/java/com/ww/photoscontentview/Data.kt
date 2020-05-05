package com.ww.photoscontentview

data class Data(
    val nickname: String = "",
    val content: String = "",
    val photoList: MutableList<String> = mutableListOf()
)