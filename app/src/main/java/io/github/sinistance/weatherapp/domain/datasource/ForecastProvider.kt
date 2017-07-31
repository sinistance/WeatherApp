package io.github.sinistance.weatherapp.domain.datasource

import io.github.sinistance.weatherapp.data.db.ForecastDb
import io.github.sinistance.weatherapp.data.server.ForecastServer
import io.github.sinistance.weatherapp.domain.model.ForecastList
import io.github.sinistance.weatherapp.extensions.firstResult

/**
 * Created by suryadarma on 31/7/17.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int) =
            sources.firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun  todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}