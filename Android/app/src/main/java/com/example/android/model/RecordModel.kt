package com.example.android.model

import android.service.autofill.DateTransformation
import java.text.SimpleDateFormat
import java.util.*

data class RecordModel (
    val kinship: String,
    val entryDate: String,
    val departureDate: String,
    val comment: String,
    val resident: String,
    val visits: String,
    val department: Int
)