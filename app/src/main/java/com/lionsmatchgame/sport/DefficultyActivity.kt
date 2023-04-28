package com.lionsmatchgame.sport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import com.lionsmatchgame.sport.Music.mediaplayer_music
import kotlinx.android.synthetic.main.activity_defficulty.*

class DefficultyActivity : AppCompatActivity() {

    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defficulty)

        mediaplayer_music!!.start()
        mediaplayer_music!!.isLooping = true

        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)

        val levels = PreferenceManager.getDefaultSharedPreferences(this).getString("level", "5 x 4")

        textView4.text = levels

        textView4.setOnClickListener {
            val level = PreferenceManager.getDefaultSharedPreferences(this).getString("level", "5 x 4")
            if (level == "5 x 4"){
                index = 1
                textView4.text = "4 x 4"
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("level", "4 x 4").apply()
            }else if(level == "4 x 4"){
                index = 2
                textView4.text = "3 x 4"
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("level", "3 x 4").apply()
            }else if(level == "3 x 4"){
                index = 3
                textView4.text = "2 x 4"
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("level", "2 x 4").apply()
            }else if(level == "2 x 4"){
                index = 4
                textView4.text = "2 x 3"
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("level", "2 x 3").apply()
            }else if(level == "2 x 3"){
                index = 0
                textView4.text = "5 x 4"
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("level", "5 x 4").apply()
            }
        }

        textView3.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putInt("onStops", 1).apply()
    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            mediaplayer_music!!.pause()
        }
    }
}