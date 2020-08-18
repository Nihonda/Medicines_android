package com.android.medicines_android.widget.tabbar

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import com.android.medicines_android.R

class TabBarView (context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val inflater = (context as Activity).layoutInflater

    private val items = arrayListOf<TabBarItem>()

    private var onClickTabBarItemListener: (Int) -> Unit = { }

    fun onClickTabBarItem(block: (Int) -> Unit): TabBarView {
        onClickTabBarItemListener = block
        return this
    }

    fun activate(at: Int) {
        if (at < 0 && items.size <= at) return

        items.forEachIndexed { index, item ->
            val iconId = if (index == at) {
                TabBarItemEnum.valueOf(at)?.iconActiveId
            } else {
                TabBarItemEnum.valueOf(index)?.iconDeactiveId
            }
            iconId?.let { item.setIconResource(iconId) }
        }
    }

    fun addItem(data: TabBarItemData, isActive: Boolean = false): TabBarView {
        val item = inflater.inflate(R.layout.tab_bar_item, this, false) as TabBarItem

        item.setIconResource(data.iconInactiveId)
        //item.setLabelResource(data.labelId)
        item.setOnClickListener {
            // makeActive(item) // "タップ時"に色を変えると、色が変わってから画面遷移するので不自然
            onClickTabBarItemListener.invoke(data.index)
        }
        if (isActive) item.setIconResource(data.iconActiveId)
        addView(item)
        items.add(item)
        return this
    }

    fun addItems(data: List<TabBarItemData>): TabBarView {
        data.forEach { addItem(it) }
        return this
    }

    fun clearItems() {
        items.forEach { removeView(it) }
        items.clear()
    }
}