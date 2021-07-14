package com.example.suni3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.suni3.ui.phonebooth.PhoneNumbers
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Repo {
    fun getData(): LiveData<MutableList<PhoneNumbers>> {
        val mutableData = MutableLiveData<MutableList<PhoneNumbers>>()
        val database = Firebase.database
        val myRef = database.getReference("phone_number")
        myRef.addValueEventListener(object : ValueEventListener {
            val listData: MutableList<PhoneNumbers> = mutableListOf<PhoneNumbers>()
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val getData = userSnapshot.getValue(PhoneNumbers::class.java)
                        listData.add(getData!!)

                        mutableData.value = listData
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return mutableData
    }
}