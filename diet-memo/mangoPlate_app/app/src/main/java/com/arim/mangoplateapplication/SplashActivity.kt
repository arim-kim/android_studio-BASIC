package com.arim.mangoplateapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth


        if(auth.currentUser?.uid == null) {
            // 회원가입이 안되어 있으므로 JoinActivity
            Handler().postDelayed({
                startActivity(Intent(this,JoinActivity::class.java))
                finish()
            }, 3000)

        }else{
            // 회원가입이 되어 있으므로 MainActivity
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }, 3000)
        }
    }
}