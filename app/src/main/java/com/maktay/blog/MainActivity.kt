package com.maktay.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maktay.blog.fragments.BookmarkFragment
import com.maktay.blog.fragments.HomePageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomePageFragment())
        initBottomNavigation();
    }

    private fun initBottomNavigation() {
        val bottom = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomePageFragment())
                    true
                }
                R.id.bookmark -> {
                    replaceFragment(BookmarkFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val changer: FragmentTransaction = supportFragmentManager.beginTransaction()
        changer.replace(R.id.fragment_container, fragment)
        changer.commit()
    }
}