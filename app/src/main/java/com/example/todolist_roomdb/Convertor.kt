package com.example.todolist_roomdb

import androidx.room.TypeConverter
import java.util.Date

class Convertor {

    @TypeConverter
    fun fromDate(date : Date) : Long
    {
        return date.time
    }


    @TypeConverter
    fun toDate(time : Long) : Date{
        return Date(time)

    }
    }