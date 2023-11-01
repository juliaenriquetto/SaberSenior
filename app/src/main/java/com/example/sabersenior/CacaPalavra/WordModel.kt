package com.example.sabersenior.CacaPalavra

import android.graphics.Color
import androidx.annotation.ColorInt

data class WordModel(
    val text: String,
    @ColorInt
    val color: Int = Color.DKGRAY,
    var selected: Boolean = false
)