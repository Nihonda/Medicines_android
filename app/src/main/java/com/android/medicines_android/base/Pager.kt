package com.android.medicines_android.base

import android.app.Activity
import android.content.Intent
import java.io.Serializable

class Pager private constructor(private val activity: Activity) {
    companion object {
        val KEY_SERIALIZABLE_EXTRA = "__key_serializable_extra__"

        private var previousPage: Class<*>? = null

        fun build(activity: Activity): Pager =
            Pager(activity)

        fun <T: Serializable> getExtra(activity: Activity): T? {
            val extra = activity.intent.getSerializableExtra(KEY_SERIALIZABLE_EXTRA) as? T
            return extra ?: null
        }
    }

    var previous = previousPage
        get () = previousPage

    fun back() =
        activity.finish()

    fun <T : Activity> open(page: Class<T>): PagerOpen =
        PagerOpen(page)

    inner class PagerOpen(private val page: Class<*>) {
        private var flags = PagingType.Push
//        private var anim = PagingAnim.Default
        private var extra: Serializable? = null
        private var requestCode: Int? = null

//        fun animation(anim: PagingAnim): PagerOpen {
//            this.anim = anim
//            return this
//        }

        fun flags(flags: PagingType): PagerOpen {
            this.flags = flags
            return this
        }

        fun extra(extra: Serializable): PagerOpen {
            this.extra = extra
            return this
        }

        fun requestCode(requestCode: Int): PagerOpen {
            this.requestCode = requestCode
            return this
        }

        fun execute() {
            previousPage = activity.javaClass
            val intent = Intent(activity, page)
            if (flags != PagingType.Push) intent.flags = flags.value
            if (extra != null) intent.putExtra(KEY_SERIALIZABLE_EXTRA, extra)

            if (requestCode == null) {
                activity.startActivity(intent)
            } else {
                activity.startActivityForResult(intent, requestCode!!)
            }

//            if (anim != PagingAnim.Default) activity.overridePendingTransition(anim.enterAnim, anim.exitAnim)
        }
    }
}
