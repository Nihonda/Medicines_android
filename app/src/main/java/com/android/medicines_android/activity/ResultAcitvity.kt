package com.android.medicines_android.activity

import android.os.Bundle
import com.android.medicines_android.R
import com.android.medicines_android.fragment.ResultBaseFragment
import com.android.medicines_android.fragment.ResultVanillaFragment
import com.android.medicines_android.query.Query
import kotlinx.android.synthetic.main.activity_result.*

class ResultAcitvity: PageActivity() {
    private lateinit var fragment: ResultBaseFragment
    private var query = Query.init()

    override val layoutId = R.layout.activity_result

    override fun getTitleLabel() =
        null

    override fun getRootView() =
        container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPage(query)
    }

    private fun initPage(query: Query) {

        fragment = ResultVanillaFragment()

        val bundle = Bundle()
        bundle.putSerializable(ResultBaseFragment.KEY_QUERY_ARGUMENT, query)
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.resultContent, fragment)
            .commit()
    }
}