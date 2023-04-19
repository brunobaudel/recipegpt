package com.mobsky.recipechat.presentation.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OnEndlessScrollListener(
    var listCount: Int = 0,
    private val loadListener: (() -> Unit)? = null
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?

        if (linearLayoutManager != null
            && linearLayoutManager.findLastCompletelyVisibleItemPosition() == listCount - 1
        ) {
            loadListener?.invoke()
        }
    }
}