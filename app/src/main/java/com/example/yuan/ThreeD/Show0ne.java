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

public class Show0ne extends AppCompatActivity {
    private ImageView fanhui;
    private Custom3DView custom3DView,custom3DView1;
    private TextView tv;


    private String[] title = new String[]{"餐厅\n" +
            "\n" +
            "整个餐厅区域我们也采用和客厅一样的灰色调为主，与明度较高的颜色形成对比，让空间更有张力。入户为了解决餐厅储物问题，\n" +
            "我们在餐厅东墙设计一组嵌入式酒柜，既增加了储藏功能，又使空间富有趣味性",
            "玄关\n" +
                    "\n" +
                    "走廊尽头北卧室把单开门扩大成双移门，使走廊采光和通风更加良好。。",
            "客厅\n" +
                    "\n" +
                    "整个客厅区域，我们均采用灰色为大基调配布芯沙发，局部则用一些装饰画作点缀，希望在大气稳重的同时平添几分时尚。\n" +
                    "电视墙我们不再采用传统的有边框设计，而是采用无边框设计，用爵士白天然石搭配KD板不对称处理，让电视墙有延伸性，\n" +
                    "显示的更大气沉稳。",
            "客厅\n" +
                    "\n" +
                    "整个客厅区域，我们均采用灰色为大基调配布芯沙发，局部则用一些装饰画作点缀，希望在大气稳重的同时平添几分时尚。\n" +
                    "电视墙我们不再采用传统的有边框设计，而是采用无边框设计，用爵士白天然石搭配KD板不对称处理，让电视墙有延伸性，\n" +
                    "显示的更大气沉稳。",
            "餐厅\n" +
                    "\"整个餐厅区域我们也采用和客厅一样的灰色调为主，与明度较高的颜色形成对比，让空间更有张力。入户为了解决餐厅储物问题，\\n\" +\n" +
                    "\"我们在餐厅东墙设计一组嵌入式酒柜，既增加了储藏功能，又使空间富有趣味性\",",
            "卧室\n" +
                    "\n" +
                    "卧室区没有做太多的装饰，只是在细节处做了处理。开放式衣帽间做成隐藏式双移门，打开时看不到门，\n" +
                    "关闭时又形成屏风遮挡了里面的卫生间门，让卫生间不再对床。"};
    private int[] mipmap = new int[]{R.drawable.view11,R.drawable.view12,R.drawable.view13,R.drawable.view14,
            R.drawable.view15,R.drawable.view16};
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
                intent.setClass(Show0ne.this, ThreeShow.class);
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
                           }else if (position == 4){
                               tv.setText(title[4]);
                           }else if (position == 5){
                               tv.setText(title[5]);
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
