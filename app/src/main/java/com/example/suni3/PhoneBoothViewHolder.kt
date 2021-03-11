package com.example.suni3

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneBoothViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var tvName = itemView.findViewById<TextView>(R.id.tv_name)

    fun bind(phoneboothList: PhoneBooth) {
        tvName.text = phoneboothList.name
    }

}