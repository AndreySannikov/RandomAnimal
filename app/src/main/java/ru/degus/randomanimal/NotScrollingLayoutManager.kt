package ru.degus.randomanimal

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager


class NotScrollingLayoutManager(context: Context?) : LinearLayoutManager(context) {

    override fun canScrollVertically(): Boolean {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return false
    }
}