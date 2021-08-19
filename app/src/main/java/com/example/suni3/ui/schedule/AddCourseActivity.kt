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

    var schedule : Schedule? = null
    var datas : Intent? = null
    private var mode = 0
    private var context : Context? = null
    private var startTime : EditText? = null
    private var endTime : EditText? = null
    private var professorEdit: EditText? = null
    private var roomEdit : EditText? = null
    private var className : EditText? = null

    private var editIdx = 0

    // ManulFragment variables
    var manualFragment : ManualFragment? = ManualFragment()
    private var button_mon_manual : TextView? = null
    private var button_tue_manual : TextView? = null
    private var button_wed_manual : TextView? = null
    private var button_thu_manual : TextView? = null
    private var button_fri_manual : TextView? = null


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

        init()
    }

    private fun init() {
        context = this
        startTime = findViewById(R.id.start_time)
        endTime = findViewById(R.id.end_time)
        professorEdit = findViewById(R.id.instructor_optional)
        roomEdit = findViewById(R.id.room_optional)
        className = findViewById(R.id.Name_required)

        button_fri_manual = findViewById(R.id.mon_manual)
        button_fri_manual = findViewById(R.id.tue_manual)
        button_fri_manual = findViewById(R.id.wed_manual)
        button_fri_manual = findViewById(R.id.thu_manual)
        button_fri_manual = findViewById(R.id.fri_manual)

        schedule = Schedule()
        schedule!!.startTime = Time(9, 0)
        schedule!!.endTime = Time(10, 0)

        checkMode()
        initView()
    }

    private fun checkMode() {
        val i = intent
        mode = i.getIntExtra("mode", ScheduleFragment.REQUEST_ADD)
    }

    private fun initView() {
//         manualFragment?.buttons()
        // Day
        schedule?.day = datas.getIntExtra("setDay", 0)
        
        // Times
        schedule!!.startTime.hour = datas.getStringExtra("startTime_hour", "")
        schedule!!.startTime.minute = datas.getStringExtra("startTime_minute", "")
        schedule!!.endTime.hour = datas.getStringExtra("endTime_hour", "")
        schedule!!.endTime.minute = datas.getStringExtra("endTime_minute", "")
        
        // Strings (class title, classroom, professor)
        schedule?.classTitle = datas.getStringExtra("classTitle", "")
        schedule?.classPlace = datas.getStringExtra("classPlace", "")
        schedule?.professorName = datas.getStringExtra("professorName", "")
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
        val id: Int = item.itemId
        if (id == R.id.save) {
            if (mode == ScheduleFragment.REQUEST_ADD) {
//                 manualFragment?.inputDataProcessing()
                val i = Intent()
                val schedules = ArrayList<Schedule?>()
                schedules.add(schedule)
                i.putExtra("schedules", schedules)
                setResult(RESULT_OK_ADD, i)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadSchduleData() {
        manualFragment?.loadSchduleData()
//        val i = Intent()
//        editIdx = i.getIntExtra("idx", -1)
//        val schedules = i.getSerializableExtra("schedules") as java.util.ArrayList<Schedule>
//        schedule = schedules[0]
//        className!!.setText(schedule!!.classTitle)
//        roomEdit!!.setText(schedule!!.classPlace)
//        professorEdit!!.setText(schedule!!.professorName)
    }

    companion object {
        const val RESULT_OK_ADD = 1
        const val RESULT_OK_EDIT = 2
        const val RESULT_OK_DELETE = 3
    }

}

