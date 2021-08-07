package com.example.suni3.ui.calendar

import android.content.res.AssetManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applikeysolutions.cosmocalendar.selection.BaseSelectionManager
import com.example.suni3.*
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import kotlin.collections.ArrayList

class CalendarFragment : Fragment() {

    private var dataList : ArrayList<CalendarEvents> = ArrayList()

    private var selectionManager : BaseSelectionManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        try {
            val assetManager : AssetManager = resources.assets
            val inputStream = assetManager.open("calendar.json")

            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jObject = JSONObject(jsonString)
            val jArray = jObject.getJSONArray("calendar")


            for (i in 0.. jArray.length() - 1) {
                val obj = jArray.getJSONObject(i)
                val tempData = CalendarEvents(
                    obj.getBoolean("holiday"),
                    obj.getString("date"),
                    obj.getString("title"),
                    obj.getString("contents")
                )

                dataList.add(tempData)

            }

        } catch (e: JSONException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val mAdapter = CalendarAdapter(this.requireContext(), dataList)
        val recyclerView : RecyclerView = view.findViewById(R.id.calendar_recycler_view)
        recyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this.requireContext())
        recyclerView.layoutManager = lm.also { it.orientation = LinearLayoutManager.HORIZONTAL }
        recyclerView.setHasFixedSize(true)

        return view
    }
}