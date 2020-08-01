package com.kotlin.swipeview

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Profile(

    @SerializedName("name")
    @Expose
    val name:String,

    @SerializedName("url")
    @Expose
    val imageUrl:String,

    @SerializedName("age")
    @Expose
    val age:Int,

    @SerializedName("location")
    @Expose
    val location:String
)
{
}