package com.kotlin.swipeview

import android.content.Context
import com.google.gson.Gson
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception

class Utils {
    companion object {

        fun loadProfiles(context: Context): List<Profile> {
            val jsonArray=JSONArray(loadJsonFromAsset(context,"profiles.json"))
            val profileList : MutableList<Profile> = mutableListOf()
            for(i in 0 until jsonArray.length()){
                val profile= Gson().fromJson(jsonArray.getString(i),Profile::class.java)
                profileList.add(profile)
            }
            return profileList
        }


       fun loadInfiniteFeeds(context: Context) : List<InfiniteFeedInfo>{
           val jsonArray=JSONArray(loadJsonFromAsset(context,"infinite_news.json"))
           val profileList : MutableList<InfiniteFeedInfo> = mutableListOf()
           for(i in 0 until jsonArray.length()){
               val profile= Gson().fromJson(jsonArray.getString(i),InfiniteFeedInfo::class.java)
               profileList.add(profile)
           }
           return profileList
       }

      private  fun loadJsonFromAsset(context: Context, jsonFileName: String): String {
            var jsonString :String
            var inputStream: InputStream
            try {
                val assetManager = context.assets
                inputStream = assetManager.open(jsonFileName)
                val size=inputStream.available()
                val buffer= ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                jsonString= String(buffer,Charsets.UTF_8)

            } catch (ex: Exception) {
                return ""
            }
            return jsonString
        }
    }



}