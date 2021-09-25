package com.maktay.blog.model

data class PostData(
    val data: List<Post>,
    val success: Boolean? = null,
    val category: String? = null
)

data class Post (
    val date: String? = null,
    val readMoreUrl: String? = null,
    val author: String? = null,
    val imageUrl: String? = null,
    val time: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null
)
