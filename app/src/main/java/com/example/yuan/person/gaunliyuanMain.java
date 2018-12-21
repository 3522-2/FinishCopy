package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

public class gaunliyuanMain extends AppCompatActivity {

    private ImageView fanhui;
    private Button addCL,updateCL;
    private Button addX,updateX;
    private Button addF,updateF;
    private  ImageView home1;

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

        home1 = (ImageView)findViewById(R.id.home) ;
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this, MainActivity.class);
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
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this,AddXiao.class);
                startActivity(intent);
            }
        });

        /**
         * updateX修改效果图
         */
        updateX = (Button)findViewById(R.id.updatexiaoguotu);
        updateX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this,ChangeXiao.class);
                startActivity(intent);
            }
        });
        /**
         * addC,增加材料
         */
        addCL = (Button)findViewById(R.id.addCL);
        addCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this,AddCl.class);
                startActivity(intent);
            }
        });

        /**
         * 更新材料
         */
        updateCL = (Button)findViewById(R.id.updateCL);
        updateCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent  = new Intent();
               intent.setClass(gaunliyuanMain.this,ChangeCl.class);
               startActivity(intent);
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
         * updateC,更新方案
         */
        updateF = (Button)findViewById(R.id.updateS);
        updateF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanMain.this,ChangeSchem.class);
                startActivity(intent);
            }
        });
    }

}
