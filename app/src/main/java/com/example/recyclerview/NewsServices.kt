package com.example.recyclerview

import com.example.recyclerview.Models.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=4e6269d5f3d44bc18ada38fbfd169a3b

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "4e6269d5f3d44bc18ada38fbfd169a3b"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String, @Query("page")page:Int): Call<News>

//    https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=
}

object NewsServices{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
