package com.arim.dietmemoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdaptor(val list : MutableList<DataModel>)  : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
       return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertview = convertView

        if(convertview == null) {
            convertview = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)

        }

        val memo = convertview?.findViewById<TextView>(R.id.item_text)
        val date = convertview?.findViewById<TextView>(R.id.item_date)

        memo!!.text = list[position].memoContent
        date!!.text = list[position].date
        // setText 와 text에서 대입해주는 것의 차이

        return convertview!!
    }
}