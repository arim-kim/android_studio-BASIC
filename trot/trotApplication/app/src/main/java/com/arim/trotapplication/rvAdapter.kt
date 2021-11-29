package com.arim.trotapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvAdapter(val list: MutableList<String>) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    // itemView를 연결해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.songitem, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {

        holder.bindItems(list[position])

    }

    override fun getItemCount(): Int {

        return list.size

    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {


        fun bindItems(item : String) {
            val rvItem_text = itemView.findViewById<TextView>(R.id.song_item)
            rvItem_text.text = item
        }




    }
}