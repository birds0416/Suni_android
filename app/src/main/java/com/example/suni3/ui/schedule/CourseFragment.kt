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
import org.json.JSONArray
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

        val assetManager : AssetManager = resources.assets
        val inputStream = assetManager.open("all_courses.json")

        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("all_courses")

        try {
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

        // filtering
        button_mon?.setOnClickListener {
            button_mon?.isSelected = button_mon?.isSelected != true
            if (button_mon?.isSelected) {
                filteredList = filter2("MON", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_tue?.setOnClickListener {
            button_tue?.isSelected = button_tue?.isSelected != true
            if (button_tue?.isSelected) {
                filteredList = filter2("TUE", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_wed?.setOnClickListener {
            button_wed?.isSelected = button_wed?.isSelected != true
            if (button_wed?.isSelected) {
                filteredList = filter2("WED", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_thu?.setOnClickListener {
            button_thu?.isSelected = button_thu?.isSelected != true
            if (button_thu?.isSelected) {
                filteredList = filter2("THU", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_fri?.setOnClickListener {
            button_fri?.isSelected = button_fri?.isSelected != true
            if (button_fri?.isSelected) {
                filteredList = filter2("FRI", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_ams?.setOnClickListener {
            button_ams?.isSelected = button_ams?.isSelected != true
            if (button_ams?.isSelected) {
                filteredList = filter("major", "AMS", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_bus?.setOnClickListener {
            button_bus?.isSelected = button_bus?.isSelected != true
            if (button_bus?.isSelected) {
                filteredList = filter("major", "BUS", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_cse?.setOnClickListener {
            button_cse?.isSelected = button_cse?.isSelected != true
            if (button_cse?.isSelected) {
                filteredList = filter("major", "CSE", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_tsm?.setOnClickListener {
            button_tsm?.isSelected = button_tsm?.isSelected != true
            if (button_tsm?.isSelected) {
                filteredList = filter("major", "TSM", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_mec?.setOnClickListener {
            button_mec?.isSelected = button_mec?.isSelected != true
            if (button_mec?.isSelected) {
                filteredList = filter("major", "MEC", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }
        button_etc?.setOnClickListener {
            button_etc?.isSelected = button_etc?.isSelected != true
            if (button_etc?.isSelected) {
                filteredList = filter("major", "ETC", jArray)
                val filterAdapter = CoursesAdapter(this.requireContext(), filteredList)
                val filterView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                filterView.adapter = filterAdapter
                filterAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                filterView.layoutManager = lm
                filterView.setHasFixedSize(true)
            } else {
                dataList = unfilter(jArray)
                val mAdapter = CoursesAdapter(this.requireContext(), dataList)
                val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
                recyclerView.adapter = mAdapter
                mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "touch!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
                    }
                })
                val lm = LinearLayoutManager(this.requireContext())
                recyclerView.layoutManager = lm
                recyclerView.setHasFixedSize(true)
            }
        }

        val mAdapter = CoursesAdapter(this.requireContext(), dataList)
        var cartAdapter = CartAdapter(this.requireContext(), cartList)
        val cart_recycle : RecyclerView = view.findViewById(R.id.course_cart)
        val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
        recyclerView.adapter = mAdapter
        mAdapter.setItemClickListener(object : CoursesAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                cartList.add(CartItem(dataList[position].name))
            }
        })

        cart_recycle.adapter = cartAdapter

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

    fun filter(category : String , s : String, array : JSONArray): ArrayList<CoursesData> {
        var list : ArrayList<CoursesData> = ArrayList()
        for (i in 0.. array.length() - 1) {
            val currObject : JSONObject = array.getJSONObject(i)
            val name = currObject.getString(category)
            if (name == s) {
                val filteredData = CoursesData(
                    currObject.getString("major"),
                    currObject.getString("name"),
                    currObject.getString("title"),
                    currObject.getString("type"),
                    currObject.getInt("credit"),
                    currObject.getJSONArray("days"),
                    currObject.getString("startTime"),
                    currObject.getString("endTime"),
                    currObject.getString("room"),
                    currObject.getString("instructor"),
                    currObject.getBoolean("hasLab"),
                    currObject.getString("link")
                )
                list.add(filteredData)
            }
        }
        return list
    }

    fun filter2(s : String, array : JSONArray): ArrayList<CoursesData> {
        var list : ArrayList<CoursesData> = ArrayList()
        for (i in 0.. array.length() - 1) {
            val currObject : JSONObject = array.getJSONObject(i)
            val dayArray = currObject.getJSONArray("days")
            if (dayArray.length() == 1) {
                if (dayArray[0].toString() == s) {
                    val filtereddata = CoursesData (
                        currObject.getString("major"),
                        currObject.getString("name"),
                        currObject.getString("title"),
                        currObject.getString("type"),
                        currObject.getInt("credit"),
                        currObject.getJSONArray("days"),
                        currObject.getString("startTime"),
                        currObject.getString("endTime"),
                        currObject.getString("room"),
                        currObject.getString("instructor"),
                        currObject.getBoolean("hasLab"),
                        currObject.getString("link")
                    )
                    list.add(filtereddata)
                }
            } else {
                if (dayArray[0].toString() == s || dayArray[dayArray.length() - 1].toString() == s) {
                    val filtereddata = CoursesData (
                        currObject.getString("major"),
                        currObject.getString("name"),
                        currObject.getString("title"),
                        currObject.getString("type"),
                        currObject.getInt("credit"),
                        currObject.getJSONArray("days"),
                        currObject.getString("startTime"),
                        currObject.getString("endTime"),
                        currObject.getString("room"),
                        currObject.getString("instructor"),
                        currObject.getBoolean("hasLab"),
                        currObject.getString("link")
                    )
                    list.add(filtereddata)
                }
            }
        }
        return list
    }

    fun unfilter(array : JSONArray): ArrayList<CoursesData> {
        var list : ArrayList<CoursesData> = ArrayList()
        for (i in 0.. array.length() - 1) {
            val currObject : JSONObject = array.getJSONObject(i)
            val tempData = CoursesData(
                currObject.getString("major"),
                currObject.getString("name"),
                currObject.getString("title"),
                currObject.getString("type"),
                currObject.getInt("credit"),
                currObject.getJSONArray("days"),
                currObject.getString("startTime"),
                currObject.getString("endTime"),
                currObject.getString("room"),
                currObject.getString("instructor"),
                currObject.getBoolean("hasLab"),
                currObject.getString("link")
            )
            list.add(tempData)
        }
        return list
    }
}