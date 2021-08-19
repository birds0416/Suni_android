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
        manualFragment?.buttons()

//        button_mon_manual?.setOnClickListener {
//            button_mon_manual?.isSelected = button_mon_manual?.isSelected != true
//            schedule?.day = 0
//        }
//        button_tue_manual?.setOnClickListener {
//            button_tue_manual?.isSelected = button_tue_manual?.isSelected != true
//            schedule?.day = 1
//        }
//        button_wed_manual?.setOnClickListener {
//            button_wed_manual?.isSelected = button_wed_manual?.isSelected != true
//            schedule?.day = 2
//        }
//        button_thu_manual?.setOnClickListener {
//            button_thu_manual?.isSelected = button_thu_manual?.isSelected != true
//            schedule?.day = 3
//        }
//        button_fri_manual?.setOnClickListener {
//            button_fri_manual?.isSelected = button_fri_manual?.isSelected != true
//            schedule?.day = 4
//        }
//
//        startTime?.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v : View) {
//                val dialog = TimePickerDialog(
//                    context,
//                    listener,
//                    schedule!!.startTime.hour,
//                    schedule!!.startTime.minute,
//                    false
//                )
//                dialog.show()
//            }
//
//            val listener =
//                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//                    startTime?.setText("$hourOfDay:$minute")
//                    schedule?.startTime?.hour = hourOfDay
//                    schedule?.startTime?.minute = minute
//                }
//        })
//
//        endTime?.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v : View) {
//                val dialog = TimePickerDialog(
//                    context,
//                    listener,
//                    schedule!!.endTime.hour,
//                    schedule!!.endTime.minute,
//                    false
//                )
//                dialog.show()
//            }
//
//            val listener =
//                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//                    endTime?.setText("$hourOfDay:$minute")
//                    schedule?.endTime?.hour = hourOfDay
//                    schedule?.endTime?.minute = minute
//                }
//        })
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
                manualFragment?.inputDataProcessing()
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

//    private fun inputDataProcessing() {
//        schedule?.classTitle = className?.text.toString()
//        schedule?.classPlace = roomEdit?.text.toString()
//        schedule?.professorName = professorEdit?.text.toString()
//    }

    companion object {
        const val RESULT_OK_ADD = 1
        const val RESULT_OK_EDIT = 2
        const val RESULT_OK_DELETE = 3
    }

}

