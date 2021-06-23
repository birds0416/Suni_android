package com.example.suni3

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CourseFragment : Fragment() {

    public fun newInstance(): CourseFragment {
        val args = Bundle()
        val fragment = CourseFragment()
        fragment.arguments = args
        return fragment
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_course, container, false)

        val button_mon : TextView = view.findViewById(R.id.mon)
        val button_tue : TextView = view.findViewById(R.id.tue)
        val button_wed : TextView = view.findViewById(R.id.wed)
        val button_thu : TextView = view.findViewById(R.id.thu)
        val button_fri : TextView = view.findViewById(R.id.fri)
        val button_ams : TextView = view.findViewById(R.id.ams)
        val button_bus : TextView = view.findViewById(R.id.bus)
        val button_cse : TextView = view.findViewById(R.id.cse)
        val button_tsm : TextView = view.findViewById(R.id.tsm)
        val button_etc : TextView = view.findViewById(R.id.etc)
        val button_mec : TextView = view.findViewById(R.id.mec)



        button_mon?.setOnClickListener {
            button_mon?.isSelected = button_mon?.isSelected != true
        }
        button_tue?.setOnClickListener {
            button_tue?.isSelected = button_tue?.isSelected != true
        }
        button_wed?.setOnClickListener {
            button_wed?.isSelected = button_wed?.isSelected != true
        }
        button_thu?.setOnClickListener {
            button_thu?.isSelected = button_thu?.isSelected != true
        }
        button_fri?.setOnClickListener {
            button_fri?.isSelected = button_fri?.isSelected != true
        }
        button_ams?.setOnClickListener {
            button_ams?.isSelected = button_ams?.isSelected != true
        }
        button_bus?.setOnClickListener {
            button_bus?.isSelected = button_bus?.isSelected != true
        }
        button_cse?.setOnClickListener {
            button_cse?.isSelected = button_cse?.isSelected != true
        }
        button_tsm?.setOnClickListener {
            button_tsm?.isSelected = button_tsm?.isSelected != true
        }
        button_mec?.setOnClickListener {
            button_mec?.isSelected = button_mec?.isSelected != true
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}