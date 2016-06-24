package com.xtu.amazingdragon.mytea.Utils;

import com.xtu.amazingdragon.mytea.Bean.TeaBean;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class LoadUtils {

    private static String jsonString;
    public interface OnLoadCompleteListener{
        void onLoadCompleted(String jsonString);
    }


    public static String loadUrl(String url,final  OnLoadCompleteListener listener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonString = response.body().toString();
                if (listener!=null){
                    listener.onLoadCompleted(jsonString);
                }
            }
        });
        return jsonString;
    }
}
