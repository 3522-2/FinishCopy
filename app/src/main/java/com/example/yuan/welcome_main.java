package com.example.yuan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class welcome_main extends AppCompatActivity {
    /**
     *
     * 1.声明界面
     * 2.定义变量
     * 3.调用类Animation
     * 4.写方法让它动起来
     * @author Rain
     *
     */

    // 声明控件对象
    private TextView textView;
    //声明时间有多少;
    private int count = 4;
    private Animation animation,animation1;
    private LinearLayout linearLayout;
    private TextView b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_main);


                // 初始化控件对象textView
                textView = (TextView) findViewById(R.id.textView);
                linearLayout = findViewById(R.id.lin);
                animation = AnimationUtils.loadAnimation(this, R.anim.animation_text);
                animation1 = AnimationUtils.loadAnimation(this, R.anim.animition_scale);
                handler.sendEmptyMessageDelayed(0, 1000);
            }
            //咱在写一个计算Welcome界面的广告时间结束后进入主界面的方法

            private int getCount() {
                count--;

                if (count == 0) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (count == 2){
                    linearLayout.startAnimation(animation1);
                    animation.reset();
                }
                return count;
            }

            //进行一个消息的处理
            @SuppressLint("HandlerLeak")
            private Handler handler = new Handler() {
                public void handleMessage(android.os.Message msg) {
                    if (msg.what == 0) {
                        textView.setText(getCount()+"");
                        handler.sendEmptyMessageDelayed(0, 1000);
                        animation.reset();
                        textView.startAnimation(animation);
                    }
                };
            };
    }
