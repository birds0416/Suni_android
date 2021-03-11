package com.example.suni3.ui.PagerAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.suni3.CourseFragment
import com.example.suni3.ManualFragment

private val TAB_TITLES = arrayOf("Course", "Manual")

//class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
//
////    private val fragmentList: List<Fragment> = ArrayList<Fragment>()
////
////    override fun getItemCount(): Int = fragmentList.size
////
////    override fun createFragment(position: Int): Fragment {
////        return fragmentList.get(position)
////    }
//
//
//}