package com.example.administrator.newsclient.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.newsclient.R;
import com.example.administrator.newsclient.page.GovermentPage;
import com.example.administrator.newsclient.page.HomePage;
import com.example.administrator.newsclient.page.MyPage;
import com.example.administrator.newsclient.page.NewsPage;
import com.example.administrator.newsclient.page.SettingPage;
import com.example.administrator.newsclient.page.SmartServicePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class ContentFragment extends Fragment {

    private ViewPager vp_fragment_content;

    //List<View> pageList = new ArrayList<View>();
    List<MyPage> pageList = new ArrayList<MyPage>();

    //找到RadioGroup
    private RadioGroup rg_framgentcontent_bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       /* TextView textView = new TextView(getActivity());
        textView.setText("content");
        textView.setGravity(Gravity.CENTER);

        return textView;*/
        //return super.onCreateView(inflater, container, savedInstanceState);

        //填充，显示UI
        View view = View.inflate(getActivity(), R.layout.fragment_content,null);

        rg_framgentcontent_bottom = (RadioGroup) view.findViewById(R.id.rg_framgentcontent_bottom);

        vp_fragment_content = (ViewPager) view.findViewById(R.id.vp_fragment_content);
        //找到之后新建Adapter

        //循环数组
        /*for (int i=0;i<5;i++){

           *//* TextView textView = new TextView(getActivity());
            textView.setText("page"+i);
            pageList.add(textView);*//*

            *//*View view_page_content = View.inflate(getActivity(), R.layout.page_content, null);
            pageList.add(view_page_content);*//*

            //封装View函数，传入上下文
            MyPage myPage = new MyPage(getActivity());
            pageList.add(myPage);

        }*/
        //因为不是加入相同的信息，所以不具备for循环，Day02AM

        /*MyPage myPage = pageList.get(0);
        myPage.setPageTitle("首页");*/

        HomePage homePage = new HomePage(getActivity());
        pageList.add(homePage);
        //等同于pageList.add(new HomePage(getActivity()))
        NewsPage newsPage = new NewsPage(getActivity());
        pageList.add(newsPage);
        SmartServicePage smartServicePage = new SmartServicePage(getActivity());
        pageList.add(smartServicePage);
        GovermentPage govermentPage = new GovermentPage(getActivity());
        pageList.add(govermentPage);
        SettingPage settingPage = new SettingPage(getActivity());
        pageList.add(settingPage);


        vp_fragment_content.setAdapter(new MyContentAdapter());

        //进入时默认选中首页
        rg_framgentcontent_bottom.check(R.id.rb_fragmentcontent_home);


        //设置RadioGroup点击事件
        rg_framgentcontent_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){

                    case R.id.rb_fragmentcontent_home:
                        vp_fragment_content.setCurrentItem(0,false);
                        //点击后调用决定是否启用侧边栏SlidingMenu
                        pageList.get(0).setSlidingMenuEnable(false);
                    break;

                    case R.id.rb_fragmentcontent_news:
                        vp_fragment_content.setCurrentItem(1,false);
                        //点击后调用决定是否启用侧边栏SlidingMenu
                        pageList.get(1).setSlidingMenuEnable(true);
                        //在点击RB进入新闻中心页面后，调用JSON解析方法
                        NewsPage newsPage= (NewsPage) pageList.get(1);
                        newsPage.getDataFromServer();
                        break;

                    case R.id.rb_fragmentcontent_service:
                        vp_fragment_content.setCurrentItem(2,false);
                        //点击后调用决定是否启用侧边栏SlidingMenu
                        pageList.get(2).setSlidingMenuEnable(false);
                        break;

                    case R.id.rb_fragmentcontent_goverment:
                        vp_fragment_content.setCurrentItem(3,false);
                        //点击后调用决定是否启用侧边栏SlidingMenu
                        pageList.get(3).setSlidingMenuEnable(false);
                        break;

                    case R.id.rb_fragmentcontent_setting:
                        vp_fragment_content.setCurrentItem(4,false);
                        //点击后调用决定是否启用侧边栏SlidingMenu
                        pageList.get(4).setSlidingMenuEnable(false);
                        break;

                }

            }
        });


        return view;
    }

    class MyContentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //View view =pageList.get(position);
            MyPage myPage =pageList.get(position);
            //container.addView(view);
            container.addView(myPage.mPageView);

            //return view;//super.instantiateItem(container, position);
            return myPage.mPageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
            // super.destroyItem(container, position, object);
        }
    }
}
