package com.birds.suni3.ui.schedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import com.birds.suni3.R
import com.github.tlaabs.timetableview.Schedule

class PopupActivity : AppCompatActivity() {

    private var course_title : TextView? = null
    private var course_time : TextView? = null
    private var course_inst : TextView? = null
    private var course_room : TextView? = null
    private var course_time_info : TextView? = null
    private var course_inst_info : TextView? = null
    private var course_room_info : TextView? = null
    private var btn_delete : ImageButton? = null
    private var mode = 0
    private var delIdx = 0
    private var schedule : Schedule? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        schedule = Schedule()

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        course_title = findViewById(R.id.course_title)
        course_time = findViewById(R.id.course_time)
        course_inst = findViewById(R.id.course_inst)
        course_room = findViewById(R.id.course_room)
        course_time_info = findViewById(R.id.course_time_info)
        course_inst_info = findViewById(R.id.course_inst_info)
        course_room_info = findViewById(R.id.course_room_info)
        btn_delete = findViewById(R.id.btn_delete)

//        loadScheduleData()
        checkMode()


    }

    private fun checkMode() {
        val i = Intent()
        delIdx = i.getIntExtra("del_idx", -1)
        mode = i.getIntExtra("mode", ScheduleFragment.REQUEST_DELETE)
        if (mode == i.getIntExtra("mode", ScheduleFragment.REQUEST_DELETE)) {
            btn_delete?.setOnClickListener {
                if (mode == ScheduleFragment.REQUEST_DELETE) {
                    i.putExtra("del_idx", delIdx)
                    setResult(RESULT_OK_DELETE, i)
                    finish()
                }
            }
        }
    }

    private fun loadScheduleData() {
        val i = Intent()
        delIdx = i.getIntExtra("idx", -1)
        val schedules = i.getSerializableExtra("del_schedule") as ArrayList<Schedule>
        schedule = schedules[0]

        var dayString : String = ""
        if (schedule!!.day == 0) {
            dayString = "MON"
        } else if (schedule!!.day == 1) {
            dayString = "TUE"
        } else if (schedule!!.day == 2) {
            dayString = "WED"
        } else if (schedule!!.day == 3) {
            dayString = "THU"
        } else if (schedule!!.day == 4) {
            dayString = "FRI"
        }

        course_title!!.text = schedule!!.classTitle
        course_time_info!!.text = dayString + schedule!!.startTime.toString() + "-" + schedule!!.endTime.toString()
        course_inst_info!!.text = schedule!!.professorName.toString()
        course_room_info!!.text = schedule!!.classPlace.toString()
    }

    companion object {
        const val RESULT_OK_DELETE = 5
    }
}