package com.example.suni3.ui.schedule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suni3.R
import org.jetbrains.anko.find

class CoursesAdapter (private val context: Context, private val dataList: ArrayList<CoursesData>) : RecyclerView.Adapter<CoursesAdapter.ItemViewHolder>()  {

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

    fun addItem(data: CoursesData) {
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.courses_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        mItemClickListener = itemClickListener
    }

    private lateinit var mItemClickListener : ItemClickListener

    inner class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(adapterPosition)
            }
        }

        private val name = itemView.findViewById<TextView>(R.id.course_name)
        private val professor = itemView.findViewById<TextView>(R.id.professor)
        private val class_time = itemView.findViewById<TextView>(R.id.class_time)
        private val class_info = itemView.findViewById<ImageButton>(R.id.class_info)

        fun bind (data : CoursesData, context: Context) {

            name.text = data.name
            professor.text = "By " + data.instructor
            class_time.text = data.days[0].toString() + "/" + data.days[data.days.length() - 1].toString() + " " + data.startTime + "-" + data.endTime

            class_info.setOnClickListener {

            }
        }


    }

}