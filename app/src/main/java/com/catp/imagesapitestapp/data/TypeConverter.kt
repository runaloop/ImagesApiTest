package com.catp.imagesapitestapp.data

import androidx.room.TypeConverter
import java.util.*

class TypeConverter {
    @TypeConverter
    fun toDate(dateLong:Long):Date {
        return Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date):Long{
        return date.time;
    }
}