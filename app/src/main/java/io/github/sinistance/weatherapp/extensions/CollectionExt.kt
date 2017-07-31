package io.github.sinistance.weatherapp.extensions

/**
 * Created by suryadarma on 23/7/17.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> = map { it.key to it.value!! }.toTypedArray()

inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {
    this.forEach {
        val result = predicate(it)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found.")
}