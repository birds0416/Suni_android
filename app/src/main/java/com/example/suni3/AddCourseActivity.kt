package com.example.suni3

import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
//import com.example.suni3.ui.PagerAdapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_add_course.*

class AddCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)
//        val fragmentList = listOf(CourseFragment(), ManualFragment())
//        val tabLayout: TabLayout = findViewById(R.id.tablayout)
//        val viewPager: ViewPager = findViewById(R.id.view_pager)
//
//        val adapter: PagerAdapter = PagerAdapter(this)
//        adapter.fragments = fragmentList
//        view_pager.adapter = adapter
//        tabLayout.setupWithViewPager(viewPager)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_schedule, menu)
        if (menu != null) {
            menu.findItem(R.id.add_course).setVisible(false)
            menu.findItem(R.id.capture).setVisible(false)
            menu.findItem(R.id.before).setVisible(false)
        }
        return super.onCreateOptionsMenu(menu)
    }
}

