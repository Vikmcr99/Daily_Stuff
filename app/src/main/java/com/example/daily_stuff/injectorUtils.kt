package com.example.daily_stuff

import com.example.daily_stuff.Model.DataFake
import com.example.daily_stuff.Model.TodoRepository
import com.example.daily_stuff.Model.TodoViewModelFactory

object injectorUtils {
    fun provideTodosViewModelFactory(): TodoViewModelFactory{
        val todoRepository = TodoRepository.instanceGet(DataFake.instanceGet().todoDao)
        return TodoViewModelFactory(todoRepository)
    }
}