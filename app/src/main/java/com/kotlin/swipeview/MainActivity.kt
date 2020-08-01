package com.kotlin.swipeview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contractClass=ContractClass(applicationContext,swipeView)
        contractClass.GetModifiedView(swipeView)

        for(profile in Utils.loadProfiles(applicationContext)){
            swipeView.addView(TinderCard(applicationContext,profile,swipeView))
        }

        rejectBtn.setOnClickListener {
            swipeView.doSwipe(false)
        }

        acceptBtn.setOnClickListener {
            swipeView.doSwipe(true)
        }

        btn_next.setOnClickListener {
            startActivity(Intent(applicationContext,InfiniteActivity::class.java))
        }
    }
}