package com.example.alarmproject

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding

   lateinit var pref: SharedPreferences
   lateinit var editor: SharedPreferences.Editor

   private val alarms = listOf(   //서버에서 받고 싶은데..
       UserData(true, "8:00", "Monday", false),
       UserData(true, "9:00", "Monday", true),
       UserData(true, "10:00", "Monday", false),
       UserData(true, "11:00", "Monday", false),
       UserData(true, "12:00", "Monday", false),
       UserData(true, "1:00", "Monday", false),
       UserData(true, "2:00", "Monday", false),
       UserData(true, "3:00", "Monday", false),
       UserData(true, "4:00", "Monday", false),
       UserData(true, "5:00", "Monday", false),
       UserData(true, "6:00", "Monday", false),
       UserData(true, "7:00", "Monday", false)

   )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = getPreferences(Context.MODE_PRIVATE)
        editor = pref.edit()  //Shared Preference 초기화
        editor.putString("InputData", "save Data")  //key-value
        editor.apply()


        initializeViews()
    }
    private fun initializeViews(){
        binding.alarm.layoutManager= LinearLayoutManager(this)
        binding.alarm.adapter = AlarmAdapter(alarms)

    }
}