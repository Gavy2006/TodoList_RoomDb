package com.example.todolist_roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "todo")
data class Todo (

    var title : String ,

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0 ,

    var date : Date
)
