package io.github.sinistance.weatherapp.domain.datasource

import io.github.sinistance.weatherapp.domain.model.ForecastList

/**
 * Created by suryadarma on 31/7/17.
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}