package com.example.todolist_roomdb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(todoViewModel: TodoViewModel ){

    var input by remember {mutableStateOf("")}
     var list = todoViewModel.todolist.observeAsState(listOf()).value

    Column(modifier = Modifier.fillMaxSize()) {


        Row(modifier = Modifier.padding(8.dp)){
            OutlinedTextField(value = input , onValueChange = { input = it } , label = { Text("Enter Todo") } , modifier = Modifier.weight(1f) )

            Button({
                todoViewModel.addTodo(input)
                input = ""
            }) {
                Text("Add")
            }
        }

       LazyColumn(
           content = {
               itemsIndexed(list) { index, item :Todo ->

                   Row(modifier = Modifier.padding(8.dp)) {

                       Column {
                           Text(item.title)
                           Text(item.date.toString())
                       }

                       IconButton(onClick = {todoViewModel.deleteTodo(item.int)}) {

                           Icon(painter = painterResource(R.drawable.baseline_delete_24) , contentDescription = "")
                       }
                   }
               }
           }
       )


    }
}