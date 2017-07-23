package io.github.sinistance.weatherapp.ui

import android.app.Application
import io.github.sinistance.weatherapp.extensions.DelegateExt

/**
 * Created by suryadarma on 22/7/17.
 */
class App : Application() {

    companion object {
        var instance: App by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}