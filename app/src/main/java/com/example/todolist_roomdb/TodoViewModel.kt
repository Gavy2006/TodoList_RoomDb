import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist_roomdb.MainApplication
import com.example.todolist_roomdb.Todo
import kotlinx.coroutines.launch
import java.util.Date

class TodoViewModel : ViewModel() {

    private val todoDao = MainApplication.tododb.gettodoDao()

    val todolist = todoDao.getAllTodo()

    fun addTodo(text: String) {

        viewModelScope.launch {
            todoDao.addTodo(
                Todo(
                    title = text,
                    date = Date()
                )
            )
        }
    }

    fun deleteTodo(id: Int) {

        viewModelScope.launch {
            todoDao.deleteTodo(id)
        }
    }
}