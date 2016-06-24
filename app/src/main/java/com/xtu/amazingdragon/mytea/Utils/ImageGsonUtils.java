package com.xtu.amazingdragon.mytea.Utils;

import com.google.gson.Gson;
import com.xtu.amazingdragon.mytea.Bean.ImageBean;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class ImageGsonUtils  {
    public static ImageBean GsonFrom(String jsonStringFirst) {
        Gson gson = new Gson();
        ImageBean imageBean =gson.fromJson(jsonStringFirst,ImageBean.class);
        return imageBean;
    }
}
