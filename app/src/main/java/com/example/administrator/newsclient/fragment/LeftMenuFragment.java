package com.example.administrator.newsclient.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.newsclient.R;


/**
 * Created by Administrator on 2016/8/23.
 */
public class LeftMenuFragment extends Fragment{

    private ListView lv_fragmentleftmenu_menu;

    //新建数组用于测试SlidingMenu
    String[] menuTitles = new String[]{"新闻","专题","组图","互动"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /*TextView textView = new TextView(getActivity());
        textView.setText("LeftMenu");
        return textView;*/
        //return super.onCreateView(inflater, container, savedInstanceState);

        //将布局文件填充到左边的fragment(SlidingMenu)中
        View view = View.inflate(getActivity(), R.layout.fragment_leftmenu, null);
        //找到布局文件fragment_leftMenu中的ListView控件，同时新建适配器
        lv_fragmentleftmenu_menu = (ListView) view.findViewById(R.id.lv_fragmentleftmenu_menu);
        //绑定Adapter
        lv_fragmentleftmenu_menu.setAdapter(new MyLeftMenuAdapter());

        return view;
    }

    //新建适配器
    //新建一个数组用于填充测试
    class MyLeftMenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            //return 0;
            return menuTitles.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return null;
            TextView textView = new TextView(getActivity());
            textView.setText(menuTitles[position]);
            textView.setTextColor(Color.RED);

            return textView;
        }
    }
}
