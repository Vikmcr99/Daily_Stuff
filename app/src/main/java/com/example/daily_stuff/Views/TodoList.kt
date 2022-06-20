package com.example.daily_stuff.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daily_stuff.Adapters.AdapterTodo
import com.example.daily_stuff.R
import com.example.daily_stuff.Model.Todo
import com.example.daily_stuff.ViewModel.TodoListViewModel
import com.example.daily_stuff.injectorUtils
import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.activity_todo_list.*
import java.lang.StringBuilder


class TodoList : AppCompatActivity() {

    private lateinit var todoAdapter: AdapterTodo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        todoAdapter = AdapterTodo(mutableListOf())
        rvTodoList.adapter = todoAdapter
        rvTodoList.layoutManager = LinearLayoutManager(this)

        btnDelTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
        UiInitialize()

    }

    private fun UiInitialize(){
        val factory = injectorUtils.provideTodosViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(TodoListViewModel::class.java)

        viewModel.getTodos().observe(this, Observer { todos ->
            val stringBuilder = StringBuilder()
            todos.forEach{todo -> stringBuilder.append("$todo\n\n")}

        })

        /*btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                viewModel.addTodos(todo)
                etTodoTitle.setText("")

            }
        }*/
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
    }

}
