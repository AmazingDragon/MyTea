package com.xtu.amazingdragon.mytea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AdvertiseActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager pager;
    private LinearLayout container;
    private List<ImageView> images;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);

        initView();
        initData();
        MyPagerAdapter adapter =new MyPagerAdapter(images);
        pager.setAdapter(adapter);
        initDot();
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < images.size() ; i++) {
                    ImageView imageView = (ImageView) container.getChildAt(i);
                    if (i==position){
                        imageView.setImageResource(R.mipmap.page_now);
                    }else {
                        imageView.setImageResource(R.mipmap.page);
                    }
                }
                if (position == images.size()-1){
                    button.setVisibility(View.VISIBLE);
                }else {
                    button.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDot() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin =10;
        params.rightMargin =10;
        for (int i = 0; i < images.size() ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            if (i==0){
                imageView.setImageResource(R.mipmap.page_now);
            }else {
                imageView.setImageResource(R.mipmap.page);
            }
            container.addView(imageView);
        }
    }

    private void initData() {
        images = new ArrayList<>();
        ImageView image1 = new ImageView(this);
        image1.setImageResource(R.mipmap.slide1);
        image1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView image2 = new ImageView(this);
        image2.setImageResource(R.mipmap.slide2);
        image2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView image3 = new ImageView(this);
        image3.setImageResource(R.mipmap.slide3);
        image3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        images.add(image1);
        images.add(image2);
        images.add(image3);
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.advertise_viewpager);
        container = (LinearLayout) findViewById(R.id.container_dot);
        button = (Button) findViewById(R.id.advertise_button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        SharedPreferences sp = getSharedPreferences("first_run", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isFirst",false);
        editor.commit();

        Intent intent = new Intent(AdvertiseActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private class MyPagerAdapter extends PagerAdapter{
        List<ImageView> images;
        public MyPagerAdapter(List<ImageView> images) {
            this.images=images;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(images.get(position));
            return images.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
