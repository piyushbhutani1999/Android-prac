package com.example.mssi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

open class MainActivity:AppCompatActivity() {

    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set tablayout for tabs
        setToolBarAndTabLayout()

        // set view pager
        setViewPager()
    }

    private fun setToolBarAndTabLayout() {

        var toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Dashboard))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.FillRebate))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
    }

    // The view pager can now be accessed here, too.
    fun returnToDashBoard() {
        viewPager.currentItem = 0
    }

    private fun setViewPager(){

        viewPager = findViewById(R.id.pager)
        val adapter : PagerAdapter = DashboardAdapter(supportFragmentManager, 2)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })}
}



