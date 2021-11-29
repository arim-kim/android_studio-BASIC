package com.arim.wisesayingapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List : MutableList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertview = convertView

        if (convertview == null ){
            convertview = LayoutInflater.from(parent?.context).inflate(R.layout.listviewitem, parent, false)
        }

        val element = convertview!!.findViewById<TextView>(R.id.listViewItem)
        element?.text = List[position]

        return convertview!!

    } // xml에 넣어줌

}