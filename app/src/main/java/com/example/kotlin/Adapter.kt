package com.example.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin.Adapter.ViewHolder

open class Adapter(articles:ArrayList<Article>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    val data:ArrayList<Article>

    init {
        this.data = articles
    }

    var a:ItemClickListener?=null

    interface ItemClickListener{
        fun onClick(a:Article)
    }

    var itemClickListener:ItemClickListener? = null

    companion object {
        lateinit var itemClickListener:ItemClickListener
    }

    fun set(listener: ItemClickListener){
        this.itemClickListener  = listener
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layInflater = LayoutInflater.from(p0.context)
        val view:View = layInflater.inflate(R.layout.recycler_view_item,p0,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.text.setText(data.get(p1).articleTitle)
        p0.text.setOnClickListener {
            itemClickListener!!.onClick(data.get(p1))
        }

    }


    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text:TextView = itemView.findViewById(R.id.recItemTextView)

    }


}