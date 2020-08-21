package com.android.medicines_android.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.TextView

class QueryLabelView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
//        maxLines = Configs.MAX_QUERY_LABEL_LINES
        ellipsize = TextUtils.TruncateAt.END
    }
}