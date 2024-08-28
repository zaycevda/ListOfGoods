package com.example.listofgoods.ui.utils

import android.util.Log
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val Long.formattedDate: String
    get() {
        val date = Date(
            this
        )
        val format = SimpleDateFormat(
            "dd.MM.yyyy",
            Locale.getDefault()
        )
        return format.format(date)
    }

fun ViewModel.logError(throwable: Throwable) {
    Log.e(
        this::class.java.name,
        this::class.java.name,
        throwable
    )
}