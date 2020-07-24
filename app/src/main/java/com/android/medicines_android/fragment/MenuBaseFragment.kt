package com.android.medicines_android.fragment

import com.android.medicines_android.activity.HomeActivity
import com.android.medicines_android.widget.tabbar.TabBarItemEnum

abstract class MenuBaseFragment: TitleBarFragment() {

    override fun onResume() {
        super.onResume()

        val item = TabBarItemEnum.valueOf(this)
        val index = TabBarItemEnum.values().indexOf(item)

        tabBar?.activate(index)
    }

    fun onBackPressed() {
        val parent = activity
        if (parent is HomeActivity) {
            parent.onBackPressed()
        }
    }

}