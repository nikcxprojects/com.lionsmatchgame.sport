package com.lionsmatchgame.sport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.lionsmatchgame.sport.Music.mediaplayer_music
import kotlinx.android.synthetic.main.activity_games5.*
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

class GamesActivity5 : AppCompatActivity() {

    var arrayImage = arrayListOf(R.drawable.image8,R.drawable.image9,R.drawable.image10)

    var arrayImage2 = arrayListOf(R.drawable.image8,R.drawable.image9,R.drawable.image10)

    private var mCountDownTimer1: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis: Long = 0
    private var mEndTime: Long = 0

    var index_image = 0
    var startindex = 0
    var index1 = 0
    var index2 = 0
    var index3 = 0
    var index5 = 0
    var index6 = 0
    var index7 = 0

    var indexs = 0
    var id = 0
    var win_index = 0

    var index_to_click = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games5)

        mediaplayer_music!!.start()
        mediaplayer_music!!.isLooping = true

        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)

        Random_Idex()
        val time = PreferenceManager.getDefaultSharedPreferences(this).getInt("time", 1)

        if(time == 1){
            startTimer()
            textView5.visibility = View.VISIBLE
            progressBar.visibility = View.VISIBLE
        }else{
            textView5.visibility = View.GONE
            progressBar.visibility = View.GONE
        }


        textView6.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            onBackPressed()
        }

        textView8.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            onBackPressed()
        }

        Handler(Looper.myLooper()!!).postDelayed(
            {
                card1.setImageResource(R.drawable.main_icon)
                card2.setImageResource(R.drawable.main_icon)
                card3.setImageResource(R.drawable.main_icon)
                card5.setImageResource(R.drawable.main_icon)
                card6.setImageResource(R.drawable.main_icon)
                card7.setImageResource(R.drawable.main_icon)
                START_TIME_IN_MILLIS = 120000
                startTimer()
            }, 3000)

        card1.setOnClickListener {
            RandomImage(1)
            indexs += 1
            if(indexs == 2) {
                Win(id, index1,1)
            }
            else if(indexs == 1){
                id = 1
            }
        }

        card2.setOnClickListener {
            RandomImage(2)
            indexs += 1
            if(indexs == 2) {
                Win(id, index2,2)
            }
            else if(indexs == 1){
                id = 2
            }
        }

        card3.setOnClickListener {
            RandomImage(3)
            indexs += 1
            if(indexs == 2) {
                Win(id, index3,3)
            }
            else if(indexs == 1){
                id = 3
            }
        }

        card5.setOnClickListener {
            RandomImage(5)
            indexs += 1
            if(indexs == 2) {
                Win(id, index5,5)
            }
            else if(indexs == 1){
                id = 5
            }
        }

        card6.setOnClickListener {
            RandomImage(6)
            indexs += 1
            if(indexs == 2) {
                Win(id, index6,6)
            }
            else if(indexs == 1){
                id = 6
            }
        }

        card7.setOnClickListener {
            RandomImage(7)
            indexs += 1
            if(indexs == 2) {
                Win(id, index7,7)
            }
            else if(indexs == 1){
                id = 7
            }
        }
    }

    fun close(index1:Int,index2:Int){
        if(index1 == 1 || index2 == 1){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card1.setImageResource(R.drawable.main_icon)
                }, 500)
        }
        if(index1 == 2 || index2 == 2){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card2.setImageResource(R.drawable.main_icon)
                }, 500)
        }
        if(index1 == 3 || index2 == 3){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card3.setImageResource(R.drawable.main_icon)
                }, 500)
        }
        if(index1 == 5 || index2 == 5){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card5.setImageResource(R.drawable.main_icon)
                }, 500)
        }
        if(index1 == 6 || index2 == 6){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card6.setImageResource(R.drawable.main_icon)
                }, 500)
        }
        if(index1 == 7 || index2 == 7){
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    card7.setImageResource(R.drawable.main_icon)
                }, 500)
        }
    }

    fun Win(index:Int,image:Int,thisIndex:Int){
        indexs = 0

        if(index == 1){
            if(index1 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }
        else if(index == 2){
            if(index2 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }
        else if(index == 3){
            if(index3 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }
        else if(index == 5){
            if(index5 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }
        else if(index == 6){
            if(index6 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }
        else if(index == 7){
            if(index7 == image){
                win_index += 1
            }else{
                close(index,thisIndex)
            }
        }

        if(win_index == 3){
            START_TIME_IN_MILLIS = 3890
            resetTimer()
            textView7.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            Toast.makeText(this,"YOU WIN",Toast.LENGTH_SHORT).show()
        }
    }

    fun Random_Idex(){
        for (it in 0..2) {
            if(it == 0){
                val random = Random.nextInt(0 until arrayImage.size)
                index1 = arrayImage[random]
                Log.d("asdasd","$it ++ $index1")
                card1.setImageResource(arrayImage[random])
                arrayImage.removeAt(random)
            }
            else if(it == 1){
                val random = Random.nextInt(0 until arrayImage.size)
                index2 = arrayImage[random]
                card2.setImageResource(arrayImage[random])
                arrayImage.removeAt(random)
            }
            else if(it == 2){
                val random = Random.nextInt(0 until arrayImage.size)
                index3 = arrayImage[random]
                card3.setImageResource(arrayImage[random])
                arrayImage.removeAt(random)
            }
        }

        for(it in 0..2){
            if(it == 0){
                val random = Random.nextInt(0 until arrayImage2.size)
                index5 = arrayImage2[random]
                card5.setImageResource(arrayImage2[random])
                arrayImage2.removeAt(random)
            }
            else if(it == 1){
                val random = Random.nextInt(0 until arrayImage2.size)
                index6 = arrayImage2[random]
                card6.setImageResource(arrayImage2[random])
                arrayImage2.removeAt(random)
            }
            else if(it == 2){
                val random = Random.nextInt(0 until arrayImage2.size)
                index7 = arrayImage2[random]
                card7.setImageResource(arrayImage2[random])
                arrayImage2.removeAt(random)
            }
        }
    }

    fun RandomImage(intdex:Int) {
        if(intdex == 1){
            card1.setImageResource(index1)
        }
        else if(intdex == 2){
            card2.setImageResource(index2)
        }
        else if(intdex == 3){
            card3.setImageResource(index3)
        }
        else if(intdex == 5){
            card5.setImageResource(index5)
        }
        else if(intdex == 6){
            card6.setImageResource(index6)
        }
        else if(intdex == 7){
            card7.setImageResource(index7)
        }
    }

    private fun startTimer(): Boolean {
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer1 = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                mTimerRunning = false
            }

        }.start()
        mTimerRunning = true

        return true
    }

    private fun pauseTimer() {
        mCountDownTimer1!!.cancel()
        mTimerRunning = false
    }

    private fun resetTimer() {
        startindex = 0
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        updateCountDownText()
        pauseTimer()
    }

    private fun updateCountDownText() {

        val hours = ((mTimeLeftInMillis / (1000 * 60 * 60)) % 24)
        val minutes = ((mTimeLeftInMillis / (1000 * 60)) % 60)
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted =
            String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds)
        textView5!!.text = "TIME LEFT: $timeLeftFormatted seconds"

        if (seconds == 0) {
            if (startindex == 1) {
                START_TIME_IN_MILLIS = 3890
                resetTimer()
                card1.setImageResource(index1)
                card2.setImageResource(index2)
                card3.setImageResource(index3)
                card5.setImageResource(index5)
                card6.setImageResource(index6)
                card7.setImageResource(index7)
                if(index_to_click == 1){
                    textView8.visibility = View.GONE
                }else{
                    index_to_click = 1
                }
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                startindex = 0
            }else{
                startindex = 1
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putInt("onStops", 1).apply()
    }

    companion object {
        private var START_TIME_IN_MILLIS: Long = 4000
    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            mediaplayer_music!!.pause()
        }
    }

}