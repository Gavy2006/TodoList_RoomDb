package com.example.todolist_roomdb

import android.app.Application
import androidx.room.Room
import com.example.todolist_roomdb.ui.theme.DbPackage.TodoDataBase

class MainApplication  : Application(){

    companion object {
        lateinit var tododb : TodoDataBase
    }

    override fun onCreate() {
        super.onCreate()
       tododb = Room.databaseBuilder(this , TodoDataBase::class.java , TodoDataBase.DATABASE_NAME).build()
    }
}