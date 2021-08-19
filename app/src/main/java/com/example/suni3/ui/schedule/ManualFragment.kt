package com.example.suni3.ui.schedule

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.suni3.MainActivity
import com.example.suni3.R
import com.github.tlaabs.timetableview.Schedule
import com.github.tlaabs.timetableview.Time
import org.jetbrains.anko.find
import org.w3c.dom.Text

class ManualFragment: Fragment() {

    private var mode = 0
    private var startTime : EditText? = null
    private var endTime : EditText? = null
    private var professorEdit: EditText? = null
    private var roomEdit : EditText? = null
    private var className : EditText? = null
    private var button_mon : TextView? = null
    private var button_tue : TextView? = null
    private var button_wed : TextView? = null
    private var button_thu : TextView? = null
    private var button_fri : TextView? = null

    private var schedule : Schedule? = null
    private var editIdx = 0

//    var addCourseActivity : AddCourseActivity = AddCourseActivity()

    fun newInstance(): ManualFragment {
        val args = Bundle()
        val fragment = ManualFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_manual, container, false)

        button_mon = view.findViewById(R.id.mon_manual)
        button_tue = view.findViewById(R.id.tue_manual)
        button_wed = view.findViewById(R.id.wed_manual)
        button_thu = view.findViewById(R.id.thu_manual)
        button_fri = view.findViewById(R.id.fri_manual)

        startTime = view.findViewById(R.id.start_time)
        endTime = view.findViewById(R.id.end_time)
        professorEdit = view.findViewById(R.id.instructor_optional)
        roomEdit = view.findViewById(R.id.room_optional)
        className = view.findViewById(R.id.Name_required)

        schedule?.startTime = Time(9, 0)
        schedule?.endTime = Time(10, 0)

        buttons()

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun buttons() {

        button_mon?.setOnClickListener {
            button_mon?.isSelected = button_mon?.isSelected != true
            AddCourseActivity().schedule?.day = 0
        }
        button_tue?.setOnClickListener {
            button_tue?.isSelected = button_tue?.isSelected != true
            AddCourseActivity().schedule?.day = 1
        }
        button_wed?.setOnClickListener {
            button_wed?.isSelected = button_wed?.isSelected != true
            AddCourseActivity().schedule?.day = 2
        }
        button_thu?.setOnClickListener {
            button_thu?.isSelected = button_thu?.isSelected != true
            AddCourseActivity().schedule?.day = 3
        }
        button_fri?.setOnClickListener {
            button_fri?.isSelected = button_fri?.isSelected != true
            AddCourseActivity().schedule?.day = 4
        }

        startTime?.setOnClickListener(View.OnClickListener {
            val listener =
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    startTime?.setText("$hourOfDay:$minute")
                    AddCourseActivity().schedule!!.startTime.hour = hourOfDay
                    AddCourseActivity().schedule!!.startTime.minute = minute
                }

            fun onClick(v : View) {
                val dialog : TimePickerDialog = TimePickerDialog(
                    context,
                    listener,
                    AddCourseActivity().schedule!!.startTime.hour,
                    AddCourseActivity().schedule!!.startTime.minute,
                    false
                )
                dialog.show()
            }
        })

        endTime?.setOnClickListener(View.OnClickListener {
            val listener =
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    endTime?.setText("$hourOfDay:$minute")
                    schedule!!.endTime.hour = hourOfDay
                    schedule!!.endTime.minute = minute
                }

            fun onClick(v : View) {
                val dialog : TimePickerDialog = TimePickerDialog(
                    context,
                    listener,
                    AddCourseActivity().schedule!!.endTime.hour,
                    AddCourseActivity().schedule!!.endTime.minute,
                    false
                )
                dialog.show()
            }
        })
    }

    fun loadSchduleData() {
        val i = Intent()
        editIdx = i.getIntExtra("idx", -1)
        val schedules = i.getSerializableExtra("schedules") as java.util.ArrayList<Schedule>
        AddCourseActivity().schedule = schedules[0]
        className!!.setText(AddCourseActivity().schedule!!.classTitle)
        roomEdit!!.setText(AddCourseActivity().schedule!!.classPlace)
        professorEdit!!.setText(AddCourseActivity().schedule!!.professorName)
    }

    fun inputDataProcessing() {
        AddCourseActivity().schedule?.classTitle = className?.text.toString()
        AddCourseActivity().schedule?.classPlace = roomEdit?.text.toString()
        AddCourseActivity().schedule?.professorName = professorEdit?.text.toString()
    }

    companion object {
        const val RESULT_OK_ADD = 1
        const val RESULT_OK_EDIT = 2
        const val RESULT_OK_DELETE = 3
    }

}
