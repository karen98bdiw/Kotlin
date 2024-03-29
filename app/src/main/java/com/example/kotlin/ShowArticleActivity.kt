package com.example.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_article.*

class ShowArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_article)

        if (intent != null){
           val a:Article = intent.getSerializableExtra("article") as Article

            titleInShowAct.setText(a.articleTitle)
            textInShowAct.setText(a.articleText)

        }
    }
}
