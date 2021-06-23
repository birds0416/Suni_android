package com.example.suni3.ui.phonebooth

import android.os.Bundle
import android.view.*
import android.app.Activity
import android.app.Person
import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.suni3.PhoneNumbers
import com.example.suni3.R
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.uiThread
import java.io.IOException
import java.io.InputStream
import java.nio.channels.AsynchronousFileChannel.open

class PhoneBoothFragment : Fragment(){

    companion object {
        fun newInstance() : PhoneBoothFragment {
            return PhoneBoothFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_phonebooth, container, false)


//        doAsync {
//            val jsonFileString =
//            Log.i("data", jsonFileString)
//            val gson = Gson()
//            val phonenums = gson.fromJson(jsonFileString, Array<PhoneNumbers>::class.java).toList()
//
//            uiThread {
//                phonenums.forEach {
//                    Log.d("PhoneBooth", "person name? ${it.name}" )
//                }
//            }
//        }

//        val listPersonType = object : TypeToken<List<Person>>() {}.type
//
//        var persons: List<Person> = gson.fromJson(jsonFileString, listPersonType)
//        persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }

        return view
    }



}