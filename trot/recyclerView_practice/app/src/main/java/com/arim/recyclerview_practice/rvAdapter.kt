package com.arim.recyclerview_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvAdapter(val list: MutableList<String>) : RecyclerView.Adapter<rvAdapter.ViewHolder>(){

    interface ItemClicked {
        fun onClick(view : View, position: Int)
    }

    var itemClicked : ItemClicked? = null

    // 리사이클러뷰의 아이템을 불러옴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {

        if (itemClicked != null) {
            holder.itemView.setOnClickListener { v->
                itemClicked?.onClick(v, position)
            }
        }

        holder.bindItems(list[position])
    }

    // 전체 리사이클러뷰 아이템의 개수
    override fun getItemCount(): Int {
        return list.size
    }




    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : String) {
            val rvItem_text = itemView.findViewById<TextView>(R.id.item)
            rvItem_text.text = item
        }

    }


}