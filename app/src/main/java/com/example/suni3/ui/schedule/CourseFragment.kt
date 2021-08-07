package com.example.suni3.ui.schedule

import android.content.res.AssetManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suni3.R
import com.example.suni3.ui.phonebooth.PhoneAdapter
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class CourseFragment : Fragment() {

    private var dataList : ArrayList<CoursesData> = ArrayList()
    private var cartList : ArrayList<CartItem> = ArrayList()
    private var filteredList : ArrayList<CoursesData> = ArrayList()
    lateinit var searchViewModel : SearchViewModel
    lateinit var searchAdapter: SearchAdapter

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

        val button_mon : TextView = view.findViewById(R.id.mon_course)
        val button_tue : TextView = view.findViewById(R.id.tue_course)
        val button_wed : TextView = view.findViewById(R.id.wed_course)
        val button_thu : TextView = view.findViewById(R.id.thu_course)
        val button_fri : TextView = view.findViewById(R.id.fri_course)
        val button_ams : TextView = view.findViewById(R.id.ams)
        val button_bus : TextView = view.findViewById(R.id.bus)
        val button_cse : TextView = view.findViewById(R.id.cse)
        val button_tsm : TextView = view.findViewById(R.id.tsm)
        val button_etc : TextView = view.findViewById(R.id.etc)
        val button_mec : TextView = view.findViewById(R.id.mec)

        try {
            val assetManager : AssetManager = resources.assets
            val inputStream = assetManager.open("all_courses.json")

            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jObject = JSONObject(jsonString)
            val jArray = jObject.getJSONArray("all_courses")

            for (i in 0.. jArray.length() - 1) {
                val obj = jArray.getJSONObject(i)
                val tempData = CoursesData(
                    obj.getString("major"),
                    obj.getString("name"),
                    obj.getString("title"),
                    obj.getString("type"),
                    obj.getInt("credit"),
                    obj.getJSONArray("days"),
                    obj.getString("startTime"),
                    obj.getString("endTime"),
                    obj.getString("room"),
                    obj.getString("instructor"),
                    obj.getBoolean("hasLab"),
                    obj.getString("link")
                )
                dataList.add(tempData)
            }

        // Exceptions
        } catch (e: JSONException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val mAdapter = CoursesAdapter(this.requireContext(), dataList)
        val cartAdapter = CartAdapter(this.requireContext(), cartList)
        val cart_recycle : RecyclerView = view.findViewById(R.id.course_cart)
        val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
        recyclerView.adapter = mAdapter
        mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                cartList.add(CartItem(dataList[position].name))
                Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
            }
        })

        cart_recycle.adapter = cartAdapter

        // filtering
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
        button_etc?.setOnClickListener {
            button_etc?.isSelected = button_etc?.isSelected != true
        }

        val lm = LinearLayoutManager(this.requireContext())
        val cart_lm = LinearLayoutManager(this.requireContext())
        recyclerView.layoutManager = lm
        cart_recycle.layoutManager = cart_lm.also { it.orientation = LinearLayoutManager.HORIZONTAL }
        recyclerView.setHasFixedSize(true)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}