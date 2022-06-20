package com.example.daily_stuff.Model

class TodoRepository private constructor(private val todoDao: TodoData)
{
    fun addTodo(todo : Todo){
        todoDao.addTodo(todo)
    }

    fun getTodos() = todoDao.getTodos()

    companion object{
        @Volatile private var instance:TodoRepository? = null

        fun instanceGet(todoDao: TodoData) = instance?: synchronized(this){
            instance ?: TodoRepository(todoDao).also { instance = it }
        }
    }
}