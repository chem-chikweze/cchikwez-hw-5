package com.cchikwez.books.data

import androidx.annotation.DrawableRes

data class Book(
    val index: Int,
    val title: String,
    val author: String,
    val released: Int,
    val quote: String,
    val synopsis: String,
    @DrawableRes val image: Int
)
