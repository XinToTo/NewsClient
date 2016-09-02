package com.example.administrator.newsclient.page;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.newsclient.HomeActivity;

/**
 * Created by Administrator on 2016/8/27.
 */
public class SettingPage extends MyPage{


    public SettingPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tv_pageview_pageTitle.setText("设置");

        //添加内容
        TextView textView = new TextView(mActivity);
        textView.setText("这是设置页面的内容");
        textView.setGravity(Gravity.CENTER);
        ll_viewpage_content.addView(textView);

       /* //设置侧边栏不可滑动
        HomeActivity homeActivity = (HomeActivity)mActivity;
        homeActivity.setSlidingMenuEnable(false);*/
    }
}
