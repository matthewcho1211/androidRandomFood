package com.example.randomfood

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val BGMmediaplayer = MediaPlayer.create(this,R.raw.bgm)
        BGMmediaplayer.start()
        BGMmediaplayer.isLooping = true

        val startBtn = findViewById<Button>(R.id.startBtn)

        startBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            BGMmediaplayer.stop()

        }

    }
}