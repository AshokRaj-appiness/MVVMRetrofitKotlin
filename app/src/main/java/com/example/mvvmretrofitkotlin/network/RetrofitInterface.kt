package com.example.mvvmretrofitkotlin.network

import androidx.lifecycle.LiveData
import com.example.mvvmretrofitkotlin.model.Todo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("todos/")
    fun getTodos(): Call<List<Todo>>
}