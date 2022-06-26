package com.example.recyclerview.Models

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)