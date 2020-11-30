package com.maishameds.post.helper

import android.view.View

interface CustomItemClickListener {

    fun <T> onItemClick(item: T, position: Int)

    fun onItemLongClick(v: View, position: Int)
}
