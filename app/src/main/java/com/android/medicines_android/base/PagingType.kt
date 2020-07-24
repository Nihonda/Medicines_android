package com.android.medicines_android.base

import android.content.Intent

enum class PagingType(val value: Int) {

    Push(-1),

    Once(Intent.FLAG_ACTIVITY_NO_HISTORY),

    BringToFront(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP),

    BackTo(Intent.FLAG_ACTIVITY_CLEAR_TOP),

    PopTo(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP), ;
}
