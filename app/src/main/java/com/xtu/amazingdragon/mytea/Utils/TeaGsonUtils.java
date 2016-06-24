package com.xtu.amazingdragon.mytea.Utils;

import com.google.gson.Gson;
import com.xtu.amazingdragon.mytea.Bean.TeaBean;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class TeaGsonUtils {
    public static TeaBean GsonFrom(String jsonString) {
        Gson gson = new Gson();
        TeaBean teaBean = gson.fromJson(jsonString,TeaBean.class);
        return  teaBean;
    }
}
