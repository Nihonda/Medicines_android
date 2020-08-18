package com.android.medicines_android.fragment

import com.android.medicines_android.activity.PageActivity
import com.android.medicines_android.widget.TitleBarView
import com.android.medicines_android.widget.tabbar.TabBarView

abstract class TitleBarFragment : BaseFragment() {
    protected var titleBar: TitleBarView? = null
        get () {
            if (requireActivity() is PageActivity) {
                val customView = (requireActivity() as PageActivity).supportActionBar?.customView
                if (customView is TitleBarView) {
                    return customView
                }
            }

            throw IllegalStateException("This fragment MUST be added into the activity derived from PageActivity.")
        }

    protected var tabBar: TabBarView? = null
        get () {
            if (requireActivity() is PageActivity) {
                return (requireActivity() as PageActivity).tabBar
            }

            throw IllegalStateException("This fragment MUST be added into the activity derived from PageActivity.")
        }
}
