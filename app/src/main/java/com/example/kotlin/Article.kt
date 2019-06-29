package com.example.kotlin

import java.io.Serializable

class Article(title:String,text:String):Serializable{

    val articleTitle:String;
    val articleText:String;

    init {
        this.articleText = text
        this.articleTitle = title
    }

}