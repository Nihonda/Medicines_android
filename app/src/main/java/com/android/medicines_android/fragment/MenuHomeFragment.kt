package com.android.medicines_android.fragment

import android.os.Bundle
import android.view.View
import com.android.medicines_android.R
import com.android.medicines_android.activity.HomeActivity
import com.android.medicines_android.activity.ResultAcitvity
import com.android.medicines_android.base.Pager
import com.android.medicines_android.base.PagingType
import com.android.medicines_android.extra.HomeActivityExtra
import com.android.medicines_android.widget.tabbar.TabBarItemEnum
import kotlinx.android.synthetic.main.fragment_menu_home.*

class MenuHomeFragment: MenuBaseFragment() {
    override val layoutId = R.layout.fragment_menu_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setClickListeners()
    }

    private fun setClickListeners() {
        searchBtn.setOnClickListener { onClickSearchButton.invoke(it) }
    }

    private val onClickSearchButton = ignore@{ view: View? ->

        Pager.build(requireActivity())
            .open(ResultAcitvity::class.java)
            .flags(PagingType.BackTo)
            .execute()
    }
}