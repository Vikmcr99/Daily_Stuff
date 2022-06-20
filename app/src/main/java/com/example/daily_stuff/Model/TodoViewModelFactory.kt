package com.example.daily_stuff.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daily_stuff.ViewModel.TodoListViewModel

class TodoViewModelFactory(private val todoRepository: TodoRepository): ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoListViewModel(todoRepository) as T
    }
}