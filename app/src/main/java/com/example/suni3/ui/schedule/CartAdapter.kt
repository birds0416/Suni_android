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

class CartAdapter (private val context: Context, private val dataList: ArrayList<CartItem>) : RecyclerView.Adapter<CartAdapter.ItemViewHolder>(){

    private var datas: ArrayList<CartItem>? = dataList

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

    fun addItem(data: CartItem) {
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.courses_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartAdapter.ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItemClickListener(itemClickListener: CoursesAdapter.ItemClickListener) {
        mItemClickListener = itemClickListener
    }

    private lateinit var mItemClickListener : CoursesAdapter.ItemClickListener

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(adapterPosition)
            }
        }

        private val name = itemView.findViewById<TextView>(R.id.cart_item)
        private val delete = itemView.findViewById<ImageButton>(R.id.btn_close)

        fun bind (data : CartItem, context: Context) {
            name.text = data.course_name

            delete.setOnClickListener {

            }
        }
    }

}