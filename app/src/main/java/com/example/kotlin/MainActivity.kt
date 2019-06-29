package com.example.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.recycler_view_item.*
import java.sql.Array

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articles:Articles = Articles()

        articles.addArticle(Article("val & var","use val for unmutable field and var from mutable"))
        articles.addArticle(Article("withIndex","you can check array fields with index"))

        val recyclerView:RecyclerView = findViewById(R.id.kotlinArticlesRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter:Adapter = Adapter(articles.articles)

        recyclerView.adapter = adapter


        adapter.itemClickListener = object :Adapter.ItemClickListener{
            override fun onClick(a: Article) {
                val intent = Intent(this@MainActivity,ShowArticleActivity::class.java)
                intent.putExtra("article",a)
                startActivity(intent)
            }
        }


    }
}
