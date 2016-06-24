package com.xtu.amazingdragon.mytea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    private boolean isFirst;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sp = getSharedPreferences("first_run", MODE_PRIVATE);
        isFirst = sp.getBoolean("isFirst", true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                if(isFirst){
                    Intent intent = new Intent(WelcomeActivity.this,AdvertiseActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }).start();
    }
}
