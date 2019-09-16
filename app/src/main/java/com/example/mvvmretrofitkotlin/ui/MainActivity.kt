package com.example.mvvmretrofitkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitkotlin.R
import com.example.mvvmretrofitkotlin.adapter.TodoAdapter
import com.example.mvvmretrofitkotlin.model.Todo
import com.example.mvvmretrofitkotlin.viewmodels.TodoViewModel

class MainActivity : AppCompatActivity() {
    lateinit var rv_todo_list:RecyclerView;
    lateinit var todoAdapter:TodoAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        rv_todo_list = findViewById(R.id.rv_todo_list) as RecyclerView
        rv_todo_list.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(this)
        todoViewModel.getTodos().observe(this,object:Observer<List<Todo>> {
            override fun onChanged(t: List<Todo>) {
                Log.d("==>", "Fdsdf")
                todoAdapter.setListValue(t)

            }
        })
        rv_todo_list.adapter = todoAdapter
    }
}
