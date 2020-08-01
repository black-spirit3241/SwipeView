package com.kotlin.swipeview;

import android.content.Context;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class ContractClass{

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    public ContractClass(Context context,SwipePlaceHolderView swipePlaceHolderView){
        this.mContext=context;
        this.mSwipeView=swipePlaceHolderView;
    }

    public SwipePlaceHolderView GetModifiedView(SwipePlaceHolderView swipePlaceHolderView){
        swipePlaceHolderView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        return swipePlaceHolderView;
    }
}
