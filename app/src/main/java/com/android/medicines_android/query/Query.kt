package com.android.medicines_android.query

import java.io.Serializable

open class Query : Serializable {
    companion object {
        fun init() =
            Query()
    }
}