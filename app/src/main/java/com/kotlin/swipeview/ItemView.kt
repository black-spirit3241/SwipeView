package com.kotlin.swipeview

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View

@Layout(R.layout.load_more_item_view)
class ItemView(
   private val context: Context,
   private val info: InfiniteFeedInfo
) {

    @View(R.id.titleTxt)
    lateinit var titleTxt:TextView

    @View(R.id.captionTxt)
    lateinit var captionTxt:TextView

    @View(R.id.timeTxt)
    lateinit var timeTxt:TextView

    @View(R.id.imageView)
    lateinit var imageView:ImageView

    @Resolve
    fun onResolve() {
        titleTxt.text=info.title
        captionTxt.text=info.caption
        timeTxt.text=info.time
        Glide.with(context).load(info.imageUrl).into(imageView)
    }
}