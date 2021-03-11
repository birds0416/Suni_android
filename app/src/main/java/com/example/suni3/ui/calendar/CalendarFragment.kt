package com.example.suni3.ui.calendar

import android.os.Bundle
import android.view.*
import android.widget.CalendarView
import com.applikeysolutions.cosmocalendar.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.suni3.R
import java.util.*
import com.prolificinteractive.*

class CalendarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_calendar, container, false)

        return root
    }
}