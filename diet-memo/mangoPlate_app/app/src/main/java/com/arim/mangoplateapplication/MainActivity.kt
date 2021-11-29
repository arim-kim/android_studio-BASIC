package com.arim.mangoplateapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(DataModel("https://www.mangoplate.com/restaurants/nBBuYGL3kAkI",
            "https://mp-seoul-image-production-s3.mangoplate.com/461443/qjpteuudbqi3gm.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "마라신화마라탕" ))
        items.add(DataModel("https://www.mangoplate.com/restaurants/prl1JPZOWqag",
        "https://mp-seoul-image-production-s3.mangoplate.com/538728_1608802270896998.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
        "오꼬노미스토리"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/71KcF_LODj",
            "https://mp-seoul-image-production-s3.mangoplate.com/619788_1589163634081740.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "매니멀스모크하우스"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/0lzD8d-8RBRI",
            "https://mp-seoul-image-production-s3.mangoplate.com/431508/qlc6abuqycwjcb.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "모터시티"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/jXzOHlVIwY",
            "https://mp-seoul-image-production-s3.mangoplate.com/48002/483575_1456412084656_332206?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "부탄츄"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/9pIv7vDY70k1",
            "https://mp-seoul-image-production-s3.mangoplate.com/360830/90579_1545209467325_2522?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "버거파크"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/nBBuYGL3kAkI",
            "https://mp-seoul-image-production-s3.mangoplate.com/461443/qjpteuudbqi3gm.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "마라신화마라탕" ))
        items.add(DataModel("https://www.mangoplate.com/restaurants/prl1JPZOWqag",
            "https://mp-seoul-image-production-s3.mangoplate.com/538728_1608802270896998.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "오꼬노미스토리"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/71KcF_LODj",
            "https://mp-seoul-image-production-s3.mangoplate.com/619788_1589163634081740.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "매니멀스모크하우스"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/0lzD8d-8RBRI",
            "https://mp-seoul-image-production-s3.mangoplate.com/431508/qlc6abuqycwjcb.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "모터시티"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/jXzOHlVIwY",
            "https://mp-seoul-image-production-s3.mangoplate.com/48002/483575_1456412084656_332206?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "부탄츄"))
        items.add(DataModel("https://www.mangoplate.com/restaurants/9pIv7vDY70k1",
            "https://mp-seoul-image-production-s3.mangoplate.com/360830/90579_1545209467325_2522?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "버거파크"))

        val rvView = findViewById<RecyclerView>(R.id.rv_container)
        val rv_adapter = rvAdapter(baseContext, items)
        rvView.adapter = rv_adapter

        rv_adapter.itemClick = object : rvAdapter.ItemClick{

            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("URl", items[position].url)
                intent.putExtra("TITLE", items[position].titleText)
                intent.putExtra("IMAGEURL", items[position].ImageUrl)

//                Log.d("MainActivity", items[position].ImageUrl.toString() )
                startActivity(intent)

            }

        }

        val GoBookMarkBtn = findViewById<Button>(R.id.GoBookMark)

        GoBookMarkBtn.setOnClickListener {
            val intent = Intent(baseContext, BookMarkActivity::class.java)
            startActivity(intent)
        }

        rvView.layoutManager = GridLayoutManager(this, 2)


    }


}