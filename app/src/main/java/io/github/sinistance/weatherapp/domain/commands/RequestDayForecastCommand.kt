package io.github.sinistance.weatherapp.domain.commands

import io.github.sinistance.weatherapp.domain.datasource.ForecastProvider
import io.github.sinistance.weatherapp.domain.model.Forecast

/**
 * Created by suryadarma on 1/8/17.
 */
class RequestDayForecastCommand(val id: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}