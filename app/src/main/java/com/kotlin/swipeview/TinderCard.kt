package com.kotlin.swipeview

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*

@Layout(R.layout.tinder_card_view)
class TinderCard(
   private val mContext: Context,
   private val mProfile: Profile,
   private val mSwipeView: SwipePlaceHolderView
) {

    @View(R.id.profileImageView)
    lateinit var profileImageView: ImageView

    @View(R.id.nameAgeTxt)
    lateinit var nameAgeTxt : TextView

    @View(R.id.locationNameTxt)
    lateinit var locationNameTxt : TextView

    @Resolve
    fun onResolved() {
       Glide.with(mContext).load(mProfile.imageUrl).into(profileImageView)
        nameAgeTxt.text=mProfile.name+" , "+mProfile.age
        locationNameTxt.text=mProfile.location
    }

    @SwipeOut
    fun onSwipeOut() {
        mSwipeView.addView(this)
    }


    @SwipeIn
    fun onSwipeIn() {

    }

    @SwipeCancelState
    fun onSwipeCancelState() {

    }

    @SwipeInState
    fun onSwipeInState() {

    }

    @SwipeOutState
    fun onSwipeOutState() {

    }

}