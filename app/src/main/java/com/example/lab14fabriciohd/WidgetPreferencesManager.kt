package com.example.lab14fabriciohd

import android.content.Context
import android.content.SharedPreferences

object WidgetPreferencesManager {

    private const val PREFS_NAME = "widget_preferences"
    private const val KEY_PRODUCT_COUNT = "product_count"

    fun getProductCount(context: Context): Int {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_PRODUCT_COUNT, 0)
    }

    fun incrementProductCount(context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val currentCount = sharedPreferences.getInt(KEY_PRODUCT_COUNT, 0)
        sharedPreferences.edit().putInt(KEY_PRODUCT_COUNT, currentCount + 1).apply()
    }
}
