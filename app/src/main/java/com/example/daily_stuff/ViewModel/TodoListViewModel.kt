package com.example.daily_stuff.ViewModel

import androidx.lifecycle.ViewModel
import com.example.daily_stuff.Model.Todo
import com.example.daily_stuff.Model.TodoRepository

class TodoListViewModel(private val todoRepository : TodoRepository): ViewModel()
{
    fun getTodos() = todoRepository.getTodos()

    fun addTodos(todo: Todo) =  todoRepository.addTodo(todo)


}