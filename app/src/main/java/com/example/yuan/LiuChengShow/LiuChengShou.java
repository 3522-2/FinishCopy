package com.example.yuan.LiuChengShow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

public class LiuChengShou extends AppCompatActivity {

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu_cheng_shou);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LiuChengShou.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
