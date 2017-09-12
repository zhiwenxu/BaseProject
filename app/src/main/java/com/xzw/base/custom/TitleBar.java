package com.xzw.base.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xzw.base.callback.TitleBarClickListener;
import com.xzw.base.utils.DisplayUtil;

/**
 * Created by dmsoft on 2017/9/11.
 *
 */

public class TitleBar extends RelativeLayout implements View.OnClickListener{

    private static final String TEXT_COLOR = "#808080";
    private static final String WHITEC_COLOR = "#ffffff";
    private static final float HEIGHT = 45;
    private static final float TITLE_TEXT_SIZE = 22;
    private static final float TEXT_SIZE = 20;

    private TitleBarClickListener mListener;
    private RelativeLayout leftLayout,rightLayout;
    private TextView leftTv,rightTv,centerTv;
    private ImageView leftImage,rightImage;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){

        leftLayout = new RelativeLayout(context);
        rightLayout = new RelativeLayout(context);
        leftTv = new TextView(context);
        rightTv = new TextView(context);
        centerTv = new TextView(context);
        leftImage = new ImageView(context);
        rightImage = new ImageView(context);

        //左边图片布局参数
        LayoutParams leftLayoutParam = new LayoutParams(DisplayUtil.dp2px(context,45), ViewGroup.LayoutParams.MATCH_PARENT);
        leftLayoutParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        leftLayoutParam.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        leftLayout.setLayoutParams(leftLayoutParam);
        leftLayout.setVisibility(GONE);

        //右边图片布局参数
        LayoutParams rightLayoutParam = new LayoutParams(DisplayUtil.dp2px(context,45), ViewGroup.LayoutParams.MATCH_PARENT);
        rightLayoutParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        rightLayoutParam.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        rightLayout.setLayoutParams(rightLayoutParam);
        rightLayout.setVisibility(GONE);

        //左边图片布局参数
        LayoutParams leftImageParam = new LayoutParams(DisplayUtil.dp2px(context,30),DisplayUtil.dp2px(context,30));
        leftImageParam.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        leftImage.setLayoutParams(leftImageParam);

        //右边图片布局参数
        LayoutParams rightImageParam = new LayoutParams(DisplayUtil.dp2px(context,30),DisplayUtil.dp2px(context,30));
        rightImageParam.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        rightImage.setLayoutParams(rightImageParam);

        //左边文字布局参数
        LayoutParams leftTvParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        leftTvParam.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        leftTvParam.leftMargin = DisplayUtil.dp2px(context,15);
        leftTv.setLayoutParams(leftTvParam);
        leftTv.setTextColor(Color.parseColor(TEXT_COLOR));
        leftTv.setTextSize(DisplayUtil.sp2px(context,TEXT_SIZE));
        leftTv.setVisibility(GONE);

        //右边文字布局参数
        LayoutParams rightTvParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        rightTvParam.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        rightTvParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        rightTvParam.rightMargin = DisplayUtil.dp2px(context,15);
        rightTv.setLayoutParams(rightTvParam);
        rightTv.setTextColor(Color.parseColor(TEXT_COLOR));
        rightTv.setTextSize(DisplayUtil.sp2px(context,TEXT_SIZE));
        rightTv.setVisibility(GONE);

        //中间标题文字布局参数
        LayoutParams centerTvParam = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        centerTvParam.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        centerTv.setLayoutParams(centerTvParam);
        centerTv.setTextColor(Color.parseColor(TEXT_COLOR));
        centerTv.setTextSize(DisplayUtil.sp2px(context,TITLE_TEXT_SIZE));


        leftLayout.setOnClickListener(this);
        rightLayout.setOnClickListener(this);

        leftLayout.addView(leftImage);
        rightLayout.addView(rightImage);

        addView(leftLayout);
        addView(rightLayout);
        addView(centerTv);
        addView(leftTv);
        addView(rightTv);
    }

    //设置监听
    public void setOnTitleBarListener(TitleBarClickListener listener){
        this.mListener = listener;
    }

    //设置标题
    public void setTitle(String title){
        centerTv.setText(title);
    }
    //设置左边图标
    public void setLeftImage(int drawable){
        leftLayout.setVisibility(VISIBLE);
        leftImage.setBackgroundResource(drawable);
        leftTv.setVisibility(GONE);
    }
    //设置右边图标
    public void setRightImage(int drawable){
        rightLayout.setVisibility(VISIBLE);
        rightImage.setBackgroundResource(drawable);
        rightTv.setVisibility(GONE);
    }
    //设置左边文字
    public void setLeftTv(String tv){
        leftTv.setText(tv);
        leftTv.setVisibility(VISIBLE);
        leftLayout.setVisibility(GONE);
    }
    //设置右边文字
    public void setRightTv(String tv){
        rightTv.setText(tv);
        rightTv.setVisibility(VISIBLE);
        rightLayout.setVisibility(GONE);
    }


    @Override
    public void onClick(View v) {
        if(v == leftLayout){
            if(mListener != null)
                mListener.onTitleClick(TitleBarClickListener.TITLE_LEFT);
        }
        if(v == rightLayout) {
            if(mListener != null)
                mListener.onTitleClick(TitleBarClickListener.TITLE_RIGHT);
        }
    }
}
