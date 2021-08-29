package com.birds.suni3.ui.phonebooth

import android.content.res.AssetManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birds.suni3.R
import com.google.firebase.database.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class PhoneBoothFragment : Fragment() {

    val TAG = "PhoneBooth"
    private lateinit var dbref: DatabaseReference
    private lateinit var phoneRecyclerView: RecyclerView
    private lateinit var phoneList: MutableList<PhoneNumbers>
    private var dataList : ArrayList<PhoneNumbers> = ArrayList()
//    private lateinit var adapter: PhoneAdapter
//    private val viewModel by lazy { ViewModelProvider(this).get(ListViewModel::class.java) }

    companion object {
        fun newInstance(): PhoneBoothFragment {
            return PhoneBoothFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_phonebooth, container, false)

        try {
            val assetManager : AssetManager = resources.assets
            val inputStream = assetManager.open("phone_number.json")

            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jObject = JSONObject(jsonString)
            val jArray = jObject.getJSONArray("phone_number")


            for (i in 0.. jArray.length() - 1) {
                val obj = jArray.getJSONObject(i)
                val tempData = PhoneNumbers(
                    obj.getString("email"),
                    obj.getString("name"),
                    obj.getString("number")
                )

                dataList.add(tempData)

            }

        } catch (e: JSONException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val mAdapter = PhoneAdapter(this.requireContext(), dataList)
        val recyclerView : RecyclerView = view.findViewById(R.id.my_recycler_view)
        recyclerView.adapter = mAdapter
        mAdapter.setItemClickListener(object : PhoneAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {

            }
        })
        val lm = LinearLayoutManager(this.requireContext())
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
        return view
    }
}

