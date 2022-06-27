package com.example.recyclerview.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.FullView
import com.example.recyclerview.Models.Article
import com.example.recyclerview.R

class NewsAdapter(val context : Context, val article: List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImg)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDesc = itemView.findViewById<TextView>(R.id.newsDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article:Article = article[position]
        holder.newsTitle.text = article.title
        holder.newsDesc.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, FullView::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return article.size
    }

}

