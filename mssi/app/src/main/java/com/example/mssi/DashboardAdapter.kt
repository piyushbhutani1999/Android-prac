package com.example.mssi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class DashboardAdapter(fm :FragmentManager, var numOfTabs : Int) :
   FragmentStatePagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return if(position == 0){
            DashboardFragment()
        }else{
            FillRebateFragment()
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }

}