package com.android.medicines_android.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.android.medicines_android.R
import com.android.medicines_android.base.Pager.Companion.getExtra
import com.android.medicines_android.extra.HomeActivityExtra
import com.android.medicines_android.fragment.BaseFragment
import com.android.medicines_android.fragment.MenuKeepFragment
import com.android.medicines_android.widget.tabbar.TabBarItemEnum
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: PageActivity() {
    private var lastTab: TabBarItemEnum? = null
    private var currentTab = TabBarItemEnum.Home
    private var currentFragment: BaseFragment? = null

    override val layoutId = R.layout.activity_home

    override fun getTitleLabel() =
        null

    override fun getRootView() =
        container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extra = getExtra<HomeActivityExtra>(this)
        if (extra == null) {
            //throw IllegalStateException("HomeActivityExtra must not be null.")
        } else {
            onClickTabBarItem(extra.tabBarItem)
        }
    }

    override fun onBackPressed() {
        if (currentTab.equals(TabBarItemEnum.Home)) {
            super.onBackPressed()
        } else {
            onClickTabBarItem(TabBarItemEnum.Home)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (currentFragment == null) return
        if ((currentFragment as? MenuKeepFragment) == null) return

//        data?.extras?.let { bundle ->
//            when (requestCode) {
//                RecordListFragment.REQUEST_CODE -> when (resultCode) {
//                    RecordListFragment.RESULT_CODE -> {
//                        val fragment = currentFragment as MenuKeepFragment
//                        val isRead = bundle.getBoolean(DetailActivity.KEY_IS_READ_EXTRA)
//                        val isKeep = bundle.getBoolean(DetailActivity.KEY_IS_KEEP_EXTRA)
//                        val isEntry = bundle.getBoolean(DetailActivity.KEY_IS_ENTRY_EXTRA)
//                        fragment.updateItemState(isRead, isKeep, isEntry)
//                    }
//
//                    else -> Unit
//                }
//
//                else -> Unit
//            }
//        }
    }

    override fun onClickTabBarItem(nextTab: TabBarItemEnum?) {
        nextTab?.let ignore@{ item ->
            if (lastTab != null && nextTab.equals(currentTab)) {
                return@ignore
            }

            val fragment = nextTab.getFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.tabContent, fragment)
                .commit()

            lastTab = currentTab
            currentTab = nextTab
            currentFragment = fragment
        }
    }
}