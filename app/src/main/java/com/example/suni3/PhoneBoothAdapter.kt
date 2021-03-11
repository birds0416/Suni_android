package com.example.suni3

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.phonebooth_list.view.*

class PhoneBoothAdapter (val phoneboothList: ArrayList<PhoneBooth>) : RecyclerView.Adapter<PhoneBoothViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneBoothViewHolder {
        return PhoneBoothViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.phonebooth_list, parent, false))
    }

    override fun getItemCount(): Int {
        return phoneboothList.size
    }

    override fun onBindViewHolder(holder: PhoneBoothViewHolder, position: Int) {
        holder.bind(phoneboothList[position])
    }
}

