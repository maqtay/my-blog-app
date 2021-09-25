package com.maktay.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation();
    }

    private fun initBottomNavigation() {
        val bottom = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    println("home selected")
                    true
                }
                R.id.bookmark -> {
                    println("bookmark selected")
                    true
                }
                else -> false
            }
        }
    }
}