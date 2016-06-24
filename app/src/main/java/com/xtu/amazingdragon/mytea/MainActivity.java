package com.xtu.amazingdragon.mytea;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xtu.amazingdragon.mytea.adapter.MyFragmentPagerAdapter;
import com.xtu.amazingdragon.mytea.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;
    private String[] titles;
    private Fragment[] fragments;

    String slideImages = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow";
    String headLines ="http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines";
    String content = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType&type=";
    int [] page = {16,52,53,54};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTitleFragmentData();

        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);


    }
    private void initTitleFragmentData() {
        titles = new String[]{"头条","百科","资讯","经营","数据"};
        fragments = new Fragment[titles.length];
            for (int i = 0; i < titles.length; i++) {
                fragments[i] = new ContentFragment();
                Bundle bundle = new Bundle();
                if (i==0){
                    bundle.putString("url",headLines);
                    bundle.putString("imageUrl",slideImages);
                }else {
                    bundle.putString("url",content+page[i-1]);
                }
                fragments[i].setArguments(bundle);
                //测试2
        }
    }


    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        pager = (ViewPager) findViewById(R.id.main_viewpager);
    }

}
