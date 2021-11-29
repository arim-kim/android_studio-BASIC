package com.arim.mangoplateapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class rvAdapter( val context: Context , val list : MutableList<DataModel>) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)


        return ViewHolder(view)
    }

    interface ItemClick{

        fun onClick(view : View, position: Int)

    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {

        if (itemClick != null) {
            holder?.itemView.setOnClickListener { v->
                itemClick!!.onClick(v, position)
            }
        }

        holder.bindItems(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : DataModel) {
            val itemImage = itemView.findViewById<ImageView>(R.id.imageArea)
            val itemText = itemView.findViewById<TextView>(R.id.textArea)

            itemText.text = item.titleText

            Glide.with(context)
                .load(item.ImageUrl)
                .into(itemImage)


        }
    }

}