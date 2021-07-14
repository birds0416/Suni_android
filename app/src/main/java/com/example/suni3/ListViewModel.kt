package com.example.suni3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.suni3.ui.phonebooth.PhoneNumbers

class ListViewModel : ViewModel() {
    private val repo = Repo()
    fun fetchData(): LiveData<MutableList<PhoneNumbers>> {
        val mutableData = MutableLiveData<MutableList<PhoneNumbers>>()
        repo.getData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }
}