package com.android.medicines_android.activity

import com.android.medicines_android.R
import com.android.medicines_android.fragment.ResultBaseFragment
import com.android.medicines_android.query.Query
import kotlinx.android.synthetic.main.activity_result.*

class ResultAcitvity: PageActivity() {
    lateinit private var fragment: ResultBaseFragment
    private var query = Query.init()

    override val layoutId = R.layout.activity_result

    override fun getTitleLabel() =
        null

    override fun getRootView() =
        container
}