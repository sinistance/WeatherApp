package io.github.sinistance.weatherapp.domain.commands

import io.github.sinistance.weatherapp.data.ForecastRequest
import io.github.sinistance.weatherapp.domain.mappers.ForecastDataMapper
import io.github.sinistance.weatherapp.domain.model.ForecastList

/**
 * Created by suryadarma on 17/7/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}