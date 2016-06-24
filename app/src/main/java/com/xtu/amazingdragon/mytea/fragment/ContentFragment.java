package com.xtu.amazingdragon.mytea.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xtu.amazingdragon.mytea.Bean.ImageBean;
import com.xtu.amazingdragon.mytea.Bean.TeaBean;
import com.xtu.amazingdragon.mytea.R;
import com.xtu.amazingdragon.mytea.Utils.ImageGsonUtils;
import com.xtu.amazingdragon.mytea.Utils.LoadUtils;
import com.xtu.amazingdragon.mytea.Utils.TeaGsonUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class ContentFragment extends Fragment{
    private String url;
    private String firstImg;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,null);
        Bundle bundle = getArguments();

        url =   bundle.getString("url");
        firstImg = bundle.getString("imageUrl","no");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonString = LoadUtils.loadUrl(url);
                String jsonStringFirst = LoadUtils.loadUrl(firstImg);


                TeaBean teaBean = TeaGsonUtils.GsonFrom(jsonString);
                ImageBean imageBean = ImageGsonUtils.GsonFrom(jsonStringFirst);
                List<TeaBean.DataBean> datas = teaBean.getData();
                List<ImageBean.DataBean> imageDatas = imageBean.getData();
            }
        }).start();



        return view;
    }
}
