package io.github.sinistance.weatherapp.domain.commands

/**
 * Created by suryadarma on 17/7/17.
 */
interface Command<out T> {
    fun execute(): T
}