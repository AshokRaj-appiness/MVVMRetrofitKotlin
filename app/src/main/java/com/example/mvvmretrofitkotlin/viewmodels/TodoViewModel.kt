package com.example.mvvmretrofitkotlin.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitkotlin.model.Todo
import com.example.mvvmretrofitkotlin.network.RetrofitClient
import com.example.mvvmretrofitkotlin.network.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class TodoViewModel(application: Application): AndroidViewModel(application) {
    var myApplication: Application
    var retrofit: Retrofit
    var todoList: MutableLiveData<List<Todo>> = MutableLiveData()

    init {
        this.myApplication = application
        this.retrofit = RetrofitClient.getInstance()
    }

    fun getTodos():LiveData<List<Todo>>{
        var todos = retrofit.create(RetrofitInterface::class.java).getTodos()
        todos.enqueue(object :Callback<List<Todo>>{
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.d("response ==>",response.body().toString())
                todoList.value = response.body()
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("error=>",t.message)
            }
        })
        return todoList
    }



}