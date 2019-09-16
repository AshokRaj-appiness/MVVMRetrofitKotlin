package com.example.mvvmretrofitkotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitkotlin.R
import com.example.mvvmretrofitkotlin.model.Todo

class TodoAdapter(context: Context):RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    var context:Context ?= null;
    var todos:List<Todo> = ArrayList<Todo>()
    init {
        this.context = context
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.findViewById(R.id.text_view) as TextView
        var tv_status = itemView.findViewById<TextView>(R.id.tv_status)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           LayoutInflater.from(context).inflate(
               R.layout.todo_item,
               parent,
               false
           )
       )
    }

    fun setListValue(todoList:List<Todo>){
        this.todos = todoList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("value ==>",todos.get(position).title)
        holder.textView.text = todos.get(position).title
        holder.tv_status.text = todos.get(position).completed.toString()
    }

}