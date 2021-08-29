package com.birds.suni3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, com.birds.suni3.MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}