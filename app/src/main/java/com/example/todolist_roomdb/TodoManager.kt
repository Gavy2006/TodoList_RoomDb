package com.example.todolist_roomdb

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date


object TodoManager {

    val list = mutableListOf<Todo>() ;

    fun getAllTodo() : List<Todo>{
        return  list.toList() ;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(text : String){
        list.add(Todo(text , System.currentTimeMillis().toInt(),Date.from(Instant.now())))
    }

    fun deleteTodo(id : Int){
        list.removeIf { it.id == id }
    }
}