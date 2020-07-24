package com.android.medicines_android.activity

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.android.medicines_android.R
import com.android.medicines_android.base.Pager
import com.android.medicines_android.base.PagingType
import com.android.medicines_android.extra.HomeActivityExtra
import com.android.medicines_android.widget.tabbar.TabBarItemData
import com.android.medicines_android.widget.tabbar.TabBarItemEnum
import com.android.medicines_android.widget.tabbar.TabBarView

abstract class PageActivity: AppCompatActivity() {
    lateinit var tabBar: TabBarView
        private set

    abstract val layoutId: Int

    abstract fun getTitleLabel(): Int?

    abstract fun getRootView(): ViewGroup?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)

        initTabBar()
    }

    protected open fun initTabBar() {
        val container = getRootView() ?: return

        Log.d("Example","layoutInflater ${layoutInflater}")

        tabBar = layoutInflater.inflate(R.layout.tab_bar, container, false) as TabBarView
        val items = TabBarItemEnum.values().map { TabBarItemData(it.index, it.iconDeactiveId, it.iconActiveId) }

        tabBar.addItems(items)
        tabBar.onClickTabBarItem { index ->

            val item = TabBarItemEnum.valueOf(index)
            if (item == null) {
                IllegalArgumentException("The value of tab item is invalid: $index")
            }

            onClickTabBarItem(item)
        }
        container.addView(tabBar)
    }

    protected open fun onClickTabBarItem(item: TabBarItemEnum?) {
        Pager.build(this)
            .open(HomeActivity::class.java)
            .flags(PagingType.BackTo)
//            .animation(PagingAnim.Default)
            .extra(HomeActivityExtra(item))
            .execute()
    }
}