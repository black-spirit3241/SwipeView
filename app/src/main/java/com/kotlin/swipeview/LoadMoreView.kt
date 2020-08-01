package com.kotlin.swipeview

import android.os.Looper
import com.mindorks.placeholderview.InfinitePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.infinite.LoadMore
import java.util.logging.Handler
import kotlin.concurrent.thread

@Layout(R.layout.load_more_view)
class LoadMoreView(
    private val mLoadMoreView:InfinitePlaceHolderView,
    private  val feedList:List<InfiniteFeedInfo>
) {

    @LoadMore
    fun onLoadMore(){
        ForcedWaitedLoading()
    }

    inner class ForcedWaitedLoading : Runnable{

        init {
            Thread(this).start()
        }

        override fun run() {
           thread {
               val count=mLoadMoreView.viewCount
               var start=count-1
               while ((start < count-1+6) && feedList.size > start){
                   mLoadMoreView.addView(ItemView(mLoadMoreView.context,feedList[start]))
                   start++

                   if(start == feedList.size-1){
                       mLoadMoreView.noMoreToLoad()
                       break
                   }
               }
               mLoadMoreView.loadingDone()
           }
        }

    }
}