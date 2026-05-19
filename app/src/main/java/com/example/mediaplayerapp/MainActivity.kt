package com.example.mediaplayerapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentIndex = 0

    // Code simple rakhne ke liye sirf 3 songs use kiye hain
    private val songs = arrayOf(R.raw.song1, R.raw.song2, R.raw.song3)
    private val songNames = arrayOf("Ya Ali", "Tum Hi Ho", "Kesariya")
    private val albumImages = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI Elements
        val songTitle = findViewById<TextView>(R.id.songTitle)
        val albumArt = findViewById<ImageView>(R.id.albumArt)
        val btnPlayPause = findViewById<ImageButton>(R.id.btnPlayPause)
        val btnNext = findViewById<ImageButton>(R.id.btnNext)
        val btnPrevious = findViewById<ImageButton>(R.id.btnPrevious)

        // UI update karne ka function
        fun updateUI() {
            songTitle.text = songNames[currentIndex]
            albumArt.setImageResource(albumImages[currentIndex])
        }

        // Song play karne ka function
        fun playSong() {
            mediaPlayer?.release() // Purana song stop karo
            mediaPlayer = MediaPlayer.create(this, songs[currentIndex])
            mediaPlayer?.start()
            btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
            updateUI()
        }

        // Start mein pehle song ki details dikhao
        updateUI()

        // Play/Pause Button
        btnPlayPause.setOnClickListener {
            if (mediaPlayer == null || mediaPlayer?.isPlaying == false) {
                if (mediaPlayer == null) playSong() else mediaPlayer?.start()
                btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
            } else {
                mediaPlayer?.pause()
                btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
            }
        }

        // Next Button
        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % songs.size
            playSong()
        }

        // Previous Button
        btnPrevious.setOnClickListener {
            currentIndex = if (currentIndex > 0) currentIndex - 1 else songs.size - 1
            playSong()
        }
    }

    // App band hone par memory free karna
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}