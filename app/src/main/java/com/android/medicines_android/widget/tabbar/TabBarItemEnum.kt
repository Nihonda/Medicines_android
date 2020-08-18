package com.android.medicines_android.widget.tabbar

import com.android.medicines_android.R
import com.android.medicines_android.fragment.*

enum class TabBarItemEnum(val index: Int, val iconDeactiveId: Int, val iconActiveId: Int) {
    Home(0, R.drawable.btn_tabbar_home_off, R.drawable.btn_tabbar_home_on),
    Keep(1, R.drawable.btn_tabbar_keep_off, R.drawable.btn_tabbar_keep_on),
    Catalog(2, R.drawable.btn_tabbar_catalog_off, R.drawable.btn_tabbar_catalog_on),
    Setting(3, R.drawable.btn_tabbar_settings_off, R.drawable.btn_tabbar_settings_off), ;

    companion object {
        fun valueOf(index: Int): TabBarItemEnum? =
            values().find { it.index == index }

        fun valueOf(fragment: MenuBaseFragment) =
            when (fragment) {
                is MenuHomeFragment -> Home
                is MenuKeepFragment -> Keep
                is MenuCatalogFragment -> Catalog
                is MenuSettingFragment -> Setting
                else -> null
            }
    }

    fun getFragment() =
        when (this) {
            Home -> MenuHomeFragment()
            Keep -> MenuKeepFragment()
            Catalog -> MenuCatalogFragment()
            Setting -> MenuSettingFragment()
        }
}
