package com.example.todolist_roomdb.ui.theme.DbPackage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todolist_roomdb.Convertor
import com.example.todolist_roomdb.Todo

@Database(entities = [Todo::class] , version = 1)
@TypeConverters(Convertor::class)
abstract class TodoDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "todo_db"
    }

    abstract fun gettodoDao() : TodoDaoooooo

}