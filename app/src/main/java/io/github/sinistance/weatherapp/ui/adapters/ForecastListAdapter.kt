package io.github.sinistance.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.github.sinistance.weatherapp.R
import io.github.sinistance.weatherapp.domain.model.Forecast
import io.github.sinistance.weatherapp.domain.model.ForecastList
import io.github.sinistance.weatherapp.utils.ctx
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by suryadarma on 16/7/17.
 */
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount() = weekForecast.dailyForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}