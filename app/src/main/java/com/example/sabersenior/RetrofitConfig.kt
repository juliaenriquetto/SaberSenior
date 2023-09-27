package com.example.sabersenior

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    companion object{
        fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://") //colocar o http do servidor node
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}