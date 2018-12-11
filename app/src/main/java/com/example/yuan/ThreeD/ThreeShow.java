package com.example.yuan.ThreeD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

public class ThreeShow extends AppCompatActivity {
private ImageView fanhui;
private RelativeLayout R1,R2,R3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_show);

        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ThreeShow.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 第一个3d展示
         */
        R1 = (RelativeLayout)findViewById(R.id.R1);
        R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ThreeShow.this,Show0ne.class);
                startActivity(intent);
            }
        });
        /**
         * 第二个3d展示
         */
        R2 = (RelativeLayout)findViewById(R.id.R2);
        R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ThreeShow.this,ShowTwo.class);
                startActivity(intent);
            }
        });
        /**
         * 第三个3d展示
         */
        R3 = (RelativeLayout)findViewById(R.id.R3);
        R3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ThreeShow.this,ShowThree.class);
                startActivity(intent);
            }
        });
    }
}
