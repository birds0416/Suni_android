package com.example.suni3.ui.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suni3.R

class CalendarAdapter (private val context: Context, private val dataList : ArrayList<CalendarEvents>) : RecyclerView.Adapter<CalendarAdapter.CalViewHolder>() {

    interface ItemClickListener {
        fun onItemClick (position: Int)
    }

    var mPos = 0

    fun getPostion() : Int {
        return mPos
    }

    private fun setPosition(position: Int) {
        mPos = position
    }

    fun addItem(data: CalendarEvents) {
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.calendar_events, parent, false)
        return CalViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        mItemClickListener = itemClickListener
    }

    private lateinit var mItemClickListener : ItemClickListener

    inner class CalViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(adapterPosition)
            }
        }

        private val event_title = itemView.findViewById<TextView>(R.id.event_title)
        private val event_content = itemView.findViewById<TextView>(R.id.event_content)

        fun bind(data : CalendarEvents, context: Context) {
            event_title.text = data.title + " " + data.date
            event_content.text = data.contents
        }

    }

}