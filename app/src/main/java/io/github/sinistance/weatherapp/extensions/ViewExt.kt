package io.github.sinistance.weatherapp.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by suryadarma on 22/7/17.
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)