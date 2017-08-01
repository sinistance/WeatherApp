package io.github.sinistance.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by suryadarma on 1/8/17.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)