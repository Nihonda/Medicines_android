package com.android.medicines_android.fragment

import com.android.medicines_android.R

abstract class ResultBaseFragment: TitleBarFragment() {
    companion object {
        val KEY_QUERY_ARGUMENT = "key_query_argument"
    }

    override val layoutId = R.layout.fragment_result
}