package com.xtu.amazingdragon.mytea.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xtu.amazingdragon.mytea.Bean.TeaBean;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class MyBaseAdapter extends BaseAdapter {
    Context context;
    TeaBean teaBean;
    public void MyBaseAdapter(Context context,TeaBean teaBean){
        this.context=context;
        this.teaBean =teaBean;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
