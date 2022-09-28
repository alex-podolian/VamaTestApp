package com.podolian.vamatestapp.utils

fun String.resize(width: Int, height: Int): String {
    return replace("100x100", "${width}x${height}")
}