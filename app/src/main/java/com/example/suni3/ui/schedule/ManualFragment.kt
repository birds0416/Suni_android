package com.example.suni3.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.suni3.R

class ManualFragment: Fragment() {

    public fun newInstance(): ManualFragment {
        val args = Bundle()
        val fragment = ManualFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_manual, container, false)

        val button_mon : TextView = view.findViewById(R.id.mon_manual)
        val button_tue : TextView = view.findViewById(R.id.tue_manual)
        val button_wed : TextView = view.findViewById(R.id.wed_manual)
        val button_thu : TextView = view.findViewById(R.id.thu_manual)
        val button_fri : TextView = view.findViewById(R.id.fri_manual)

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

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}