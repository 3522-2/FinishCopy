package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

public class gaunliyuanMain extends AppCompatActivity {

    private ImageView fanhui;
    private Button addCL,updateCL,deletCL;
    private Button addX,updateX,deletX;
    private Button addF,updateF,deletF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaunliyuan_main);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this, guanliyuanLogin.class);
                startActivity(intent);
            }
        });

        /**
         * addX，增加效果图
         */
        addX = (Button)findViewById(R.id.addxiaoguotu);
        addX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * deletX，删除效果图
         */
        deletX = (Button)findViewById(R.id.deletxiaoguotu);
        deletX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * updateX修改效果图
         */
        updateX = (Button)findViewById(R.id.updatexiaoguotu);
        updateX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * addC,增加材料
         */
        addCL = (Button)findViewById(R.id.addCL);
        addCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * deletC,删除材料
         */
        deletCL = (Button)findViewById(R.id.addCL);
        deletCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 更新材料
         */
        updateCL = (Button)findViewById(R.id.updateCL);
        updateCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /**
         * updateF,增加方案
         */
        addF = (Button)findViewById(R.id.addS);
        addF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this,AddScheme.class);
                startActivity(intent);

            }
        });
        /**
         * deletC,删除方案
         */
        deletF = (Button)findViewById(R.id.deletS);
        deletF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /**
         * updateC,更新方案
         */
        updateF = (Button)findViewById(R.id.updateS);
        updateF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
