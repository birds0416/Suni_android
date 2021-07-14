package com.example.suni3.ui.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import com.example.suni3.R
import com.example.suni3.ui.PagerAdapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_add_course.*

class AddCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(CourseFragment(), "Cousre")
        adapter.addFragment(ManualFragment(), "Manual")
        view_pager.adapter = adapter
        tablayout.setupWithViewPager(view_pager)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

