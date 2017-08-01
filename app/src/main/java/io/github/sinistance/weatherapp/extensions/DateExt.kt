package io.github.sinistance.weatherapp.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by suryadarma on 1/8/17.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}