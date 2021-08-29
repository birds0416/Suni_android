package com.birds.suni3.ui.schedule

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.birds.suni3.R
import org.jetbrains.anko.find

class CoursesAdapter (private val context: Context, private val dataList: ArrayList<CoursesData>) : RecyclerView.Adapter<CoursesAdapter.ItemViewHolder>()  {

    private var datas: ArrayList<CoursesData>? = dataList

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
        private val class_type = itemView.findViewById<TextView>(R.id.class_type)

        fun bind (data : CoursesData, context: Context) {

            val link = data.link

            name.text = data.name
            class_type.text = data.type
            professor.text = "By " + data.instructor
            if (data.days.length() == 1) {
                class_time.text = data.days[0].toString() + " " + data.startTime + "-" + data.endTime
            } else {
                class_time.text = data.days[0].toString() + "/" + data.days[data.days.length() - 1].toString() + " " + data.startTime + "-" + data.endTime
            }

            class_info.setOnClickListener {
                val clipboard = itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip : ClipData = ClipData.newPlainText("email_add", link)
                Toast.makeText(itemView.context, context.getString(R.string.course_link_copy), Toast.LENGTH_SHORT).show()
                clipboard.setPrimaryClip(clip)
            }
        }


    }

}