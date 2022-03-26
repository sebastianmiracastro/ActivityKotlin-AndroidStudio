package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.bumptech.glide.Glide

class InfoApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_app)

        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val img = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.gifImageViewInfoApp)

        Glide.with(this).load(R.drawable.ic_splashscreen).into(img)

        val btnBackMainPage: Button = findViewById(R.id.btnBackMainPage)

        btnBackMainPage.setOnClickListener { backAppMain() }
    }
    private fun backAppMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}