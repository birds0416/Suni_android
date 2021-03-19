package com.example.suni3.ui.phonebooth

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.suni3.R

class PhoneBoothFragment : Fragment(){

//    private var list: ArrayList<String>? = null
//    private var listPosition: Int = 0
//    private var listPositionTop: Int = 0
//
//    // JSON
//    val assetManager = resources.assets
//    val inputStream = assetManager.open("phone_number.json")
//    val jsonString = inputStream.bufferedReader().use { it.readText() }
//
//    val jObject = JSONObject(jsonString)
//    val jArray = jObject.getJSONArray("phone_number")

//    private val phoneboothList: ArrayList<PhoneBooth> = ArrayList()
//    lateinit var recyclerView: RecyclerView

//    private lateinit var phoneboothList: MutableList<PhoneBooth>
//    private val linearLayoutManager by lazy { LinearLayoutManager(context) }
//    private lateinit var phoneboothAdapter: PhoneBoothAdapter

    companion object {
        fun newInstance() : PhoneBoothFragment {
            return PhoneBoothFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_phonebooth, container, false)

        return view
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        rv_phonebooth.layoutManager = linearLayoutManager
//        phoneboothList = ArrayList()
//        for (i in 0 until 20) {
//            phoneboothList.add(PhoneBooth("IGC Housing Office", "032-626-4856", "housing@igc.or.kr"))
//            phoneboothList.add(PhoneBooth("IGC Central Library", "032-626-0251", "libmaster@igc.or.kr"))
//            phoneboothList.add(PhoneBooth("IGC IT Center", "032-626-0200", "itcenter@igc.or.kr"))
//            phoneboothList.add(PhoneBooth("IGC Health Center", "032-626-0553", "chayj@igc.or.kr"))
//            phoneboothList.add(PhoneBooth("IGC Cafeteria", "032-626-0600", ""))
//        }
//
//        phoneboothAdapter = PhoneBoothAdapter(phoneboothList)
//        rv_phonebooth.adapter = phoneboothAdapter
//
//        clickListener()
//    }

//    private fun clickListener() {
//        email.setOnClickListener{
//            copyText("Hello World")
//        }
//    }
//
//    private fun copyText (text : String) {
//        val myClipBoard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//        val myClip : ClipData = ClipData.newPlainText("Label", text)
//        myClipBoard.setPrimaryClip(myClip)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val phoneboothList = arrayListOf(
//            PhoneBooth("IGC Housing Office", "032-626-4856", R.drawable.email),
//            PhoneBooth("IGC Central Library", "032-626-0251", R.drawable.email),
//            PhoneBooth("IGC IT Center", "032-626-0200", R.drawable.email),
//            PhoneBooth("IGC Health Center", "032-626-0553", R.drawable.email),
//            PhoneBooth("IGC Cafeteria", "032-626-0600", R.drawable.email)
//        )
//
//        rv_phonebooth.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        rv_phonebooth.setHasFixedSize(true)
//        rv_phonebooth.adapter = PhoneBoothAdapter(phoneboothList)
//    }
}