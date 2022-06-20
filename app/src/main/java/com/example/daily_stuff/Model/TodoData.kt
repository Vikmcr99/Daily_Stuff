package com.example.daily_stuff.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoData {
    private val todoListData = mutableListOf<Todo>()
    private val todos = MutableLiveData<List<Todo>>()

    init{
        todos.value = todoListData
    }

    fun addTodo(todo:Todo)
    {
        todoListData.add(todo)
        todos.value = todoListData
    }

    fun getTodos() = todos as LiveData<List<Todo>>
}