package com.example.android.model

/**
 * Resident representation in android
 */
data class ResidentModel (
    var rut:String,
    var name:String,
    var email:String,
    var phone:Int,
    var department_id:Int
)
