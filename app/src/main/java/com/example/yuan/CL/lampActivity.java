package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.yuan.R;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

/**
 * Created by lenovo on 2018/12/9.
 * 灯
 */

public class lampActivity extends Activity implements  View.OnClickListener{

    private TextView lamp_first;
    private TextView lamp_second;
    private TextView lamp_third;
    private TextView lamp_fourth;
    private TextView lamp_fifth;
    private TextView lamp_sixth;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);
        lamp_first = findViewById(R.id.lamp_first);
        lamp_second = findViewById(R.id.lamp_second);
        lamp_third = findViewById(R.id.lamp_third);
        lamp_fourth = findViewById(R.id.lamp_fourth);
        lamp_fifth = findViewById(R.id.lamp_fifth);
        lamp_sixth = findViewById(R.id.lamp_sixth);
        CommonTitleBar titleBar_board=findViewById(R.id.lamp_title);
        titleBar_board.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                    onBackPressed();
                }
            }
        });

        lamp_first.setOnClickListener(this);
                lamp_second.setOnClickListener(this);
        lamp_third.setOnClickListener(this);
                lamp_fourth.setOnClickListener(this);
        lamp_fifth.setOnClickListener(this);
                lamp_sixth.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.lamp_first:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.xiding);
                intent.putExtra("introduce",R.string.xidingdeng);
                intent.putExtra("title","吸顶灯");
                startActivity(intent);
                break;
            case R.id.lamp_second:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.diaodeng);
                intent.putExtra("introduce",R.string.diaodeng);
                intent.putExtra("title","吊灯");
                startActivity(intent);
                break;
            case R.id.lamp_third:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.bideng);
                intent.putExtra("introduce",R.string.bideng);
                intent.putExtra("title","壁灯");
                startActivity(intent);
                break;
            case R.id.lamp_fourth:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.shedeng);
                intent.putExtra("introduce",R.string.shedeng);
                intent.putExtra("title","射灯");
                startActivity(intent);
                break;
            case R.id.lamp_fifth:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.taideng);
                intent.putExtra("introduce",R.string.taideng);
                intent.putExtra("title","台灯");
                startActivity(intent);
                break;
            case R.id.lamp_sixth:
                intent=new Intent(lampActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.luodideng);
                intent.putExtra("introduce",R.string.luodideng);
                intent.putExtra("title","落地灯");
                startActivity(intent);
                break;
        }
    }
}
