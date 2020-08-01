package com.kotlin.swipeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_infinite.*

class InfiniteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite)

        setupView()
    }

    private fun setupView(){
        val feedList=Utils.loadInfiniteFeeds(applicationContext)
        for(i in 0 until 6){
            loadMoreView.addView(ItemView(applicationContext,feedList[i]))
        }

        loadMoreView.setLoadMoreResolver(LoadMoreView(loadMoreView,feedList))
    }
}