package com.example.suni3.ui.schedule

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.suni3.MainActivity
import com.example.suni3.R
import com.example.suni3.ui.PagerAdapter.PagerAdapter
import com.github.tlaabs.timetableview.Schedule
import com.github.tlaabs.timetableview.Time
import kotlinx.android.synthetic.main.activity_add_course.*

class AddCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(CourseFragment(), "Course")
        adapter.addFragment(ManualFragment(), "Manual")
        view_pager.adapter = adapter
        tablayout.setupWithViewPager(view_pager)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }
}

