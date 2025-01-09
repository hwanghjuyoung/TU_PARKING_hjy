package com.example.tu_parking

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import androidx.appcompat.app.AppCompatActivity
import com.example.tu_parking.databinding.ActivityMainBinding // 바인딩



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val intent = Intent(applicationContext, SearchActivity::class.java)

        try {
            sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        startActivity(intent)
        finish()


    }


}