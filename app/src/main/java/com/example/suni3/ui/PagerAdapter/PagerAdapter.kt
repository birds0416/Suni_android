package com.example.suni3.ui.PagerAdapter

import android.content.Context
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.suni3.CourseFragment
import com.example.suni3.ManualFragment
import java.util.concurrent.CountDownLatch

//private val TAB_TITLES = arrayOf("Course", "Manual")

class PagerAdapter (manager: FragmentManager) : FragmentPagerAdapter(manager){

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}