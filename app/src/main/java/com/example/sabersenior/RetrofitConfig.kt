package com.example.sabersenior

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    companion object{
        fun getRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5072/") //http do servidor dotnet
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}