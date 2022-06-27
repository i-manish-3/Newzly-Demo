package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Adapter.NewsAdapter
import com.example.recyclerview.Models.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter
    var pageNum = 1
    var totalResults = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Newzly Demo")
//        val songs:List<String> = listOf("Manish","Babli","Manish","Babli","Manish","Babli","Manish","Babli","Manish","Babli")

//        val songsObject:MutableList<Model> = mutableListOf<Model>()
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        songsObject.add(Model("Babli","I am Babli"))
//        songsObject.add(Model("Manish","I am Manish"))
//        recView.adapter = MyAdapter(songsObject)
//        recView.layoutManager = LinearLayoutManager(this)

        getNews()

    }

    private fun getNews() {
        val news: Call<News> = NewsServices.newsInstance.getHeadlines("in",pageNum)
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news!= null)
                {
                    totalResults = news.totalResults
                    adapter = NewsAdapter(this@MainActivity,news.articles)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MANISH","Error",t)
            }
        })
    }
}