package com.kotlin.swipeview

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfiniteFeedInfo(
    @SerializedName("title")
    @Expose
    val title:String,

    @SerializedName("image_url")
    @Expose
    val imageUrl :String,

    @SerializedName("caption")
    @Expose
    val caption:String,

    @SerializedName("time")
    @Expose
    val time:String
) {
}