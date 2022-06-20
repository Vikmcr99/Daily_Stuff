package com.example.daily_stuff.Adapters

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daily_stuff.Model.Todo
import com.example.daily_stuff.R
import kotlinx.android.synthetic.main.todo_itens.view.*

class AdapterTodo(private val todosList: MutableList<Todo>):
    RecyclerView.Adapter<AdapterTodo.TodoViewHolder>()
{
    class TodoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    fun addTodo(todo: Todo) {
        todosList.add(todo)
        notifyItemInserted(todosList.size - 1)
    }

    fun deleteDoneTodos() {
        todosList.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int
    {
        return todosList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder
    {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.todo_itens,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int)
    {
        val currentTodo = todosList[position]
        holder.itemView.tvTodoTitle.text = currentTodo.title
        holder.itemView.cbCheck.isChecked = currentTodo.isChecked
        toggleStrikeThrough(holder.itemView.tvTodoTitle, currentTodo.isChecked)
        holder.itemView.cbCheck.setOnCheckedChangeListener{_,ischeckd -> toggleStrikeThrough(holder.itemView.tvTodoTitle, ischeckd)}
        currentTodo.isChecked = !currentTodo.isChecked

    }
}