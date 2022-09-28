package com.podolian.vamatestapp.utils

import android.content.Context
import com.podolian.vamatestapp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun String.resize(width: Int, height: Int): String {
    return replace("100x100", "${width}x${height}")
}

fun String.formatDate(context: Context): String {
    val fullDatePattern = context.resources.getString(R.string.full_date_pattern)
    val monthYearPattern = context.resources.getString(R.string.month_year_pattern)

    val fullDateFormatter = DateTimeFormatter.ofPattern(fullDatePattern, Locale.US)
    val monthYearFormatter = DateTimeFormatter.ofPattern(monthYearPattern, Locale.US)

    return LocalDate
        .parse(this, fullDateFormatter)
        .format(monthYearFormatter)
}