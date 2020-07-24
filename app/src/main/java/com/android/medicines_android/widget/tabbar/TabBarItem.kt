package com.android.medicines_android.widget.tabbar

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.tab_bar_item.view.*

class TabBarItem(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    fun setIconResource(resId: Int) =
        tabIcon.setImageResource(resId)
}