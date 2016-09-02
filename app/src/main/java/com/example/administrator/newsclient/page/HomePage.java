package com.example.administrator.newsclient.page;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.newsclient.HomeActivity;

/**
 * Created by Administrator on 2016/8/27.
 */
public class HomePage extends MyPage {
    public HomePage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        //添加标题
        tv_pageview_pageTitle.setText("首页");

        //添加内容
        TextView textView = new TextView(mActivity);
        textView.setText("这是首页的内容");
        textView.setGravity(Gravity.CENTER);
        ll_viewpage_content.addView(textView);

        /*//设置侧边栏不可滑动
        HomeActivity homeActivity = (HomeActivity)mActivity;
        homeActivity.setSlidingMenuEnable(false);*/
    }
}
