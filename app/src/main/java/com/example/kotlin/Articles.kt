package com.example.kotlin

class Articles {

    val title = "Kotlin"
    val articles:ArrayList<Article> = arrayListOf()


    fun addArticle(a:Article){
        this.articles.add(a)
    }

}