package com.example.administrator.newsclient.page;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.newsclient.HomeActivity;
import com.example.administrator.newsclient.R;

/**
 * Created by Administrator on 2016/8/26.
 */
public abstract class MyPage {

    public View mPageView;//就是viewpager里面的每一个page
    public Activity mActivity;

    protected TextView tv_pageview_pageTitle;
    protected LinearLayout ll_viewpage_content;
    protected ImageButton bt_pageview_leftbuttum;
    protected ImageButton bt_pageview_rightbuttum;

    //mPageView构造方法，构造时传入Activity
    public MyPage(Activity activity) {
        //this.mPageView = mPageView;
        mActivity = activity;
        initView();
        initData();
    }

    //此方法用于各子页面个性化实现
    public abstract void initData();

    //此方法用于子页面调用决定是否使用SlidingMenu(LeftFragment)
    public void setSlidingMenuEnable(boolean enable){

        HomeActivity homeActivity = (HomeActivity)mActivity;
        homeActivity.setSlidingMenuEnable(enable);

    }

    private void initView() {
        //View.inflate(getActivity(), R.layout.page_content, null);
        // getActivity()
        //写一个成员变量，在构造方法的时候把Activity传入
        mPageView = View.inflate(mActivity, R.layout.page_content, null);
        //初始化ContentPage的TextView控件
        tv_pageview_pageTitle = (TextView) mPageView.findViewById(R.id.tv_pageview_pageTitle);

        //找到ContentFragment的LenearLayout控件用于（子page调用）动态添加每个子page的内容
        ll_viewpage_content = (LinearLayout) mPageView.findViewById(R.id.ll_viewpage_content);

        //找到标题栏的两个ImageButton
        bt_pageview_leftbuttum = (ImageButton) mPageView.findViewById(R.id.bt_pageview_leftbuttum);
        bt_pageview_rightbuttum = (ImageButton) mPageView.findViewById(R.id.bt_pageview_rightbuttum);
    }

    //以下设置标题的方法不实用
   /* public void setPageTitle(String title){
        tv_pageview_pageTitle.setText(title);
    }*/

}
