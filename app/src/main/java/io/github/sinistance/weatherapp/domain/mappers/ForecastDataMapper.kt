package io.github.sinistance.weatherapp.domain.mappers

import io.github.sinistance.weatherapp.data.server.Forecast
import io.github.sinistance.weatherapp.data.server.ForecastResult
import io.github.sinistance.weatherapp.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import io.github.sinistance.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by suryadarma on 17/7/17.
 */
class ForecastDataMapper {

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt,
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { index, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult): ForecastList {
        return ForecastList(zipCode,
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}