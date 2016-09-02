package com.example.administrator.newsclient.page;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.newsclient.HomeActivity;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by Administrator on 2016/8/27.
 */
public class NewsPage extends MyPage {

    private static final String TAG ="NewsPage";

    public NewsPage(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        tv_pageview_pageTitle.setText("新闻");

        //添加内容
        TextView textView = new TextView(mActivity);
        textView.setText("这是新闻页面的内容");
        textView.setGravity(Gravity.CENTER);
        ll_viewpage_content.addView(textView);
        //设置标题栏ImageButton可见
        bt_pageview_leftbuttum.setVisibility(View.VISIBLE);
        bt_pageview_rightbuttum.setVisibility(View.VISIBLE);

        /*//设置侧边栏可以滑动
        HomeActivity homeActivity = (HomeActivity)mActivity;
        homeActivity.setSlidingMenuEnable(true);*/

        final HomeActivity homeActivity = (HomeActivity) mActivity;
        //左边ImageButton控制侧边栏开启/关闭
        bt_pageview_leftbuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity.toggle();
            }
        });
        //调用方法解析JSON
        //getDataFromServer();应该在case点击的时候调用

    }
        //Json解析，下载侧边栏数据（倒包xUtils）
        public void getDataFromServer(){

            String url = "http://10.0.2.2:8080/zhbj/categories.json";

            HttpUtils httpUtils = new HttpUtils();
            httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {

                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    Log.i(TAG,responseInfo.result);
                }

                @Override
                public void onFailure(HttpException e, String s) {
                    Log.i(TAG,s);
                }
            });


        }

}
