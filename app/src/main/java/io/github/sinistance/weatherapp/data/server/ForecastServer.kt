package io.github.sinistance.weatherapp.data.server

import io.github.sinistance.weatherapp.data.db.ForecastDb
import io.github.sinistance.weatherapp.domain.datasource.ForecastDataSource
import io.github.sinistance.weatherapp.domain.model.ForecastList

/**
 * Created by suryadarma on 31/7/17.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }
}