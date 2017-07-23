package io.github.sinistance.weatherapp.extensions

/**
 * Created by suryadarma on 23/7/17.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> = map { it.key to it.value!! }.toTypedArray()