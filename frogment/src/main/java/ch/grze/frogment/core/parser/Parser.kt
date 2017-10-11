package ch.grze.frogment.core.parser

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

class Parser {
    fun <T> getData(key: String, defaultData: T, primary: Bundle?, secondary: Intent): T {
        val primaryData = getDataFrom<T>(key, primary)
        val secondaryData = getDataFrom<T>(key, secondary)

        return primaryData ?: secondaryData ?: defaultData
    }

    fun <T> getData(key: String, defaultData: T, primary: Bundle?, secondary: Bundle?): T {
        val primaryData = getDataFrom<T>(key, primary)
        val secondaryData = getDataFrom<T>(key, secondary)

        return primaryData ?: secondaryData ?: defaultData
    }

    private fun <T> getDataFrom(key: String, bundle: Bundle?): T? {
        return if (bundle?.getParcelable<Parcelable>(key) != null) {
            bundle.getParcelable<Parcelable>(key) as T
        } else null
    }

    private fun <T> getDataFrom(key: String, intent: Intent): T? {
        return if (intent.extras?.getParcelable<Parcelable>(key) != null) {
            intent.extras.getParcelable<Parcelable>(key) as T
        } else null
    }
}
