package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import com.bumptech.glide.Glide

class SplashScreenActivity : AppCompatActivity() {

    val Duration:Long = 3000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        this.window.setFlags(
                FLAG_FULLSCREEN,
                FLAG_FULLSCREEN
        )

        val img = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.gifImageView)

        Glide.with(this).load(R.drawable.ic_splashscreen).into(img)

        changeActivity()

    }

    private fun changeActivity() {
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, Duration)
    }
}