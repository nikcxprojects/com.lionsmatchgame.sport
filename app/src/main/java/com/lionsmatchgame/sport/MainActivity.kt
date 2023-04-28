package com.lionsmatchgame.sport

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.lionsmatchgame.sport.Music.mediaplayer_music
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaplayer_music = MediaPlayer.create(this,R.raw.game_music)

        mediaplayer_music!!.start()
        mediaplayer_music!!.isLooping = true

        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putInt("onStops", 0).apply()

        val time = PreferenceManager.getDefaultSharedPreferences(this).getInt("time", 1)

        if(time == 1){
            textView4.text = "COUNTDOWN: ON"
        }else{
            textView4.text = "COUNTDOWN: OFF"
        }

        textView4.setOnClickListener {
            val times = PreferenceManager.getDefaultSharedPreferences(this).getInt("time", 1)
            if(times == 1){
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("time", 0).apply()
                textView4.text = "COUNTDOWN: OFF"
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("time", 1).apply()
                textView4.text = "COUNTDOWN: ON"
            }
        }

        textView2.setOnClickListener {
            val level = PreferenceManager.getDefaultSharedPreferences(this).getString("level", "5 x 4")
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            if(level == "5 x 4"){
                startActivity(Intent(this,GamesActivity::class.java))
            }else if(level == "4 x 4"){
                startActivity(Intent(this,GamesActivity2::class.java))
            }else if(level == "3 x 4"){
                startActivity(Intent(this,GamesActivity3::class.java))
            }else if(level == "2 x 4"){
                startActivity(Intent(this,GamesActivity4::class.java))
            }else if(level == "2 x 3"){
                startActivity(Intent(this,GamesActivity5::class.java))
            }
        }

        textView3.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this,DefficultyActivity::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            mediaplayer_music!!.pause()
        }
    }
}