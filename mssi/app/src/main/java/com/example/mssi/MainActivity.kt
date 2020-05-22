package com.example.mssi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set the tab layout
        //setTabLayout()
        Log.d("VIEWPAGER", R.id.toolbar.toString() + " I am before toolbar")
        var toolbar : Toolbar = findViewById(R.id.toolbar)
        Log.d("VIEWPAGER", R.id.toolbar.toString() + " I am after toolbar")
        if(toolbar == null){
            Log.i("VIEWPAGER", "I am null")
        }
        Log.d("VIEWPAGER","Hello log")
        setSupportActionBar(toolbar)

        var tabLayout: TabLayout = findViewById(R.id.tab_layout)

        tabLayout.addTab(tabLayout.newTab().setText(R.string.Dashboard))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.FillRebate))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        // this is used to specify view pager to the activity
        val viewPager: ViewPager = findViewById(R.id.pager)
        val adapter: DashboardAdapter = DashboardAdapter(supportFragmentManager, 2)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}



