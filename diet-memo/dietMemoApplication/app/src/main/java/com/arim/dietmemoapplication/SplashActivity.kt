package com.arim.dietmemoapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

const val TAG = "SplashActivity"

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        try {
            // 현재 사용자 로그인이 되어있지 않으면 -> 익명 계정이 없다면 catch로
            Log.d(TAG, "기존 비회원 입니다. "+ auth.currentUser!!.uid)
            Toast.makeText(this, "기존 비회원 계정으로 로그인됩니다.", Toast.LENGTH_SHORT).show()

            //(1) splash 화면 만들기 -> manifest 화면 수정
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)


        }catch (e : Exception) {
            Log.d(TAG, "회원가입이 필요합니다.")

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(baseContext, "비회원 로그인 성공.",
                            Toast.LENGTH_SHORT).show()

                        Handler().postDelayed({
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }, 3000)


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "비회원 로그인 실패.",
                            Toast.LENGTH_SHORT).show()

                    }
                }


        }





    }

}