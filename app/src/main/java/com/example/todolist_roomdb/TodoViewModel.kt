package com.example.todolist_roomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date

class TodoViewModel : ViewModel() {

    private var _todolist = MutableLiveData<List<Todo>>()
    val todolist : LiveData<List<Todo>> = _todolist

    fun getAllTodo(){
        _todolist.value = TodoManager.getAllTodo()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(text : String){

        TodoManager.addTodo(text)
        getAllTodo()
    }

    fun deleteTodo(id : Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}