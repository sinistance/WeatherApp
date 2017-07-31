package io.github.sinistance.weatherapp.domain.commands

import io.github.sinistance.weatherapp.domain.datasource.ForecastProvider
import io.github.sinistance.weatherapp.domain.model.ForecastList

/**
 * Created by suryadarma on 17/7/17.
 */
class RequestForecastCommand(val zipCode: Long,
                             val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}