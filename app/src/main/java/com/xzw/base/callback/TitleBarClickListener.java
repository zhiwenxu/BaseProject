package com.xzw.base.callback;

/**
 * Created by dmsoft on 2017/9/11.
 */

public interface TitleBarClickListener {

    int TITLE_LEFT = 0;
    int TITLE_RIGHT = 1;

    void onTitleClick(int orientation);
}
