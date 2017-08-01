package io.github.sinistance.weatherapp.extensions

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by suryadarma on 23/7/17.
 */
fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> {
       return parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })
}

fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? {
    return parseOpt(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })
}

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("DELETE FROM $tableName")
}

fun SelectQueryBuilder.byId(id: Long) = whereSimple("_id = ?", id.toString())