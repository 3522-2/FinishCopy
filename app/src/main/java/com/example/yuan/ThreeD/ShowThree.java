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

public class ShowThree extends AppCompatActivity {
    private ImageView fanhui;
    private Custom3DView custom3DView;
    private TextView tv;

    private String[] title = new String[]{"客厅:\n" +
            "\n" +
            "没有浮夸的造型，没有突兀的标新立异，唯有随意流淌的舒适与惬意。简约风格中融入北欧自然风之下的一缕惬意，一抹灵动，\n" +
            "悠然宁静，充满活力。在家具的选择上，设计师精心搭配了北欧款，地板做了拆除更换，\n" +
            "L型沙发让整个客厅层次更为饱满。在软装上，使用了个性的装饰画，纹理型的抱枕，\n" +
            "亲肤的麻料窗帘，让整个空间的北欧感觉更加强烈。\n",
            "卧室\n" +
                    "\n" +
                    "沙发背景墙上的个性装饰画，都展示出家中主人一丝不苟的细节，和对舒缓生活的美好追求",
            "客厅:\n" +
                    "\n" +
                    "没有浮夸的造型，没有突兀的标新立异，唯有随意流淌的舒适与惬意。简约风格中融入北欧自然风之下的一缕惬意，一抹灵动，\n" +
                    "悠然宁静，充满活力。在家具的选择上，设计师精心搭配了北欧款，地板做了拆除更换，\n" +
                    "L型沙发让整个客厅层次更为饱满。在软装上，使用了个性的装饰画，纹理型的抱枕，\n" +
                    "亲肤的麻料窗帘，让整个空间的北欧感觉更加强烈。\n",
            "餐厅\n" +
                    "\n" +
                    "设计师用一排可储物的卡座代替传统的椅子，餐桌的重心向东移，留出一条宽敞的通道。"};
    private int[] mipmap = new int[]{R.drawable.view31,R.drawable.view32,R.drawable.view33,R.drawable.view34};
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
                intent.setClass(ShowThree.this, ThreeShow.class);
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
