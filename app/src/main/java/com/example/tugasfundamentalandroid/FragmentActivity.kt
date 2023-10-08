package com.example.tugasfundamentalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentmanager : FragmentManager = supportFragmentManager
        val homefragment = FragmentHome()
        val fragment = fragmentmanager.findFragmentByTag(fragmentmanager::class.java.simpleName)

        if(fragment !is FragmentHome){
            fragmentmanager.beginTransaction().add(R.id.content, homefragment, FragmentHome::class.java.simpleName).commit()
        }
    }
}