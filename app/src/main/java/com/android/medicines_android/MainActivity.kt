package com.android.medicines_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.medicines_android.activity.HomeActivity
import com.android.medicines_android.base.Pager
import com.android.medicines_android.base.PagingType
import com.android.medicines_android.extra.HomeActivityExtra
import com.android.medicines_android.widget.tabbar.TabBarItemEnum

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Pager.build(this)
            .open(HomeActivity::class.java)
            .extra(HomeActivityExtra(TabBarItemEnum.Home))
            .flags(PagingType.BackTo)
            .execute()
    }
}