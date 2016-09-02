package com.example.administrator.newsclient;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.newsclient.fragment.ContentFragment;
import com.example.administrator.newsclient.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //引入slidemenu开源框架，将页面分为两部分，用fragement实现，操作基于两个fragement
        //首先设定slidingMenu显示的内容
        setBehindContentView(R.layout.slidingmenu);

        slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  //TOUCHMODE_FULLSCREEN
        slidingMenu.setBehindOffset(4*(getWindowManager().getDefaultDisplay().getWidth())/5);

        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fl_homeactivity_content,new ContentFragment());
        fragmentTransaction.replace(R.id.fl_homeactivity_leftmenu,new LeftMenuFragment());

        fragmentTransaction.commit();
    }
    //enable = ture  可以拖动，false 无法拖动 侧边栏
    public void setSlidingMenuEnable(boolean enable){
        if (enable){
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }

}
