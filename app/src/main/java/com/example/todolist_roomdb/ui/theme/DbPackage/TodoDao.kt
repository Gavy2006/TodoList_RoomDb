package com.example.todolist_roomdb.ui.theme.DbPackage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist_roomdb.Todo


@Dao
 interface TodoDaoooooo {

     @Query("SELECT * FROM todo")
    fun getAllTodo() : LiveData<List<Todo>>

    @Insert
    suspend fun addTodo(todo : Todo)

    @Query("DELETE FROM todo WHERE id = :id")
    suspend fun deleteTodo(id : Int)
}
