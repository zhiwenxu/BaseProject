package com.xzw.base.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by dmsoft on 2017/8/1.
 */

public class ListViewHeightUtil {

    public static void setListViewHeight(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){
            return;
        }
        int totalHeight = 0;
        for(int i=0;i<listAdapter.getCount();i++){
            View view = listAdapter.getView(i,null,listView);
            view.measure(0,0);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() -1));
        listView.setLayoutParams(params);
    }
}
