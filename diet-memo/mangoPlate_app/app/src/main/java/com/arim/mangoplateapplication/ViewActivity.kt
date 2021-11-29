package com.arim.mangoplateapplication

import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth


        val Url = intent.getStringExtra("URl").toString()
        val ImageUrl = intent.getStringExtra("IMAGEURL").toString()
        val title = intent.getStringExtra("TITLE").toString()

        val webView = findViewById<WebView>(R.id.webView)

        webView.loadUrl(Url)

        val BookmarkBtn = findViewById<TextView>(R.id.BookMarkBtn)

        val database = Firebase.database
        val mBookmark = database.getReference("bookmark_ref")

        BookmarkBtn.setOnClickListener {

            mBookmark
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(DataModel(Url, ImageUrl, title)) }

    }


}