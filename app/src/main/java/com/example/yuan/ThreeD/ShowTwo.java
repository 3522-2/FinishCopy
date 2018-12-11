package com.example.yuan.ThreeD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.R;


import java.util.ArrayList;
import java.util.List;

public class ShowTwo extends AppCompatActivity {
    private ImageView fanhui;
    private Custom3DView custom3DView;
    private TextView tv;
    private List<ThreeAdapt.ListItemModel> myListItem;

    private String[] title = new String[]{"卧室\n" +
            "\n" +
            "主卧室的大飘窗大大提升了室内采光，墙面是灰色调处理，软装采用布艺家具，刚柔并济。",
            "客厅\n" +
            "\n" +
            "电视背景墙面采用白色的生态木做造型搭配造型线条，简约而不简单",
            "儿童房\n" +
                    "\n" +
                    "儿童房采用了灰色调，搭配了灰蓝色的美式家具，跟整体风格遥相呼应，配上机械感的装饰画，有了小男主的生活气息",
            "餐厅\n" +
                    "\n" +
                    "整体选择高级灰的蓝色调，温和的颜色给人温暖的家的感觉，电视墙面的留白处理又不失活泼感。"};
    private int[] mipmap = new int[]{R.drawable.view21,R.drawable.view22,R.drawable.view23,R.drawable.view24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show0ne);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowTwo.this, ThreeShow.class);
                startActivity(intent);
            }
        });

        custom3DView = (Custom3DView) findViewById(R.id.activity_myview_customview);
        tv = (TextView)findViewById(R.id.TV);

        for (int i = 0; i < mipmap.length; i++) {
            ImageView imageView = new ImageView(this);
            TextView textView = new TextView(this);
            imageView.setBackgroundResource(mipmap[i]);

            textView.setText(title[i]);
            final int position = i;
            Log.i("TAG","i的值"+i);
//            tv.setText(title[i]);
            tv.setText(title[1]);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN://按下
                            Log.i("按下","i的值"+position);
                            if(position == 0){
                                tv.setText(title[0]);
                            }else if (position == 1){
                                tv.setText(title[1]);
                            }else if (position == 2){
                                tv.setText(title[2]);
                            }else if (position == 3){
                                tv.setText(title[3]);
                            }
                            break;

                    }
                    return true;
                }
            });
            custom3DView.addView(imageView);
        }


    }
}
