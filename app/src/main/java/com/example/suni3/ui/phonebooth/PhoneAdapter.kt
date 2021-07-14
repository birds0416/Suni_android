package com.example.suni3.ui.phonebooth

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.suni3.R

class PhoneAdapter(private val context: Context, private val dataList: ArrayList<PhoneNumbers>) : RecyclerView.Adapter<PhoneAdapter.ItemViewHolder>() {

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

    fun addItem(data: PhoneNumbers) {
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
        val view = LayoutInflater.from(context).inflate(R.layout.phonebooth_list, parent, false)
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

        private val name = itemView.findViewById<TextView>(R.id.tv_name)
        private val phonenum = itemView.findViewById<TextView>(R.id.phone_num)
        private val email_btn = itemView.findViewById<ImageView>(R.id.email)


        fun bind (data: PhoneNumbers, context: Context) {
            val email : String = data.email

            name.text = data.name
            phonenum.text = data.phone_num

            email_btn.setOnClickListener {
                val clipboard = itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip : ClipData = ClipData.newPlainText("email_add", email)
                Toast.makeText(itemView.context, "email copied to clipboard!", Toast.LENGTH_SHORT).show()
                clipboard.setPrimaryClip(clip)
            } }
        }

}