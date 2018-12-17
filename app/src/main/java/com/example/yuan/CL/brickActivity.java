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
 * 砖
 */

public class brickActivity extends Activity implements View.OnClickListener {

    private TextView brick_first;
    private TextView brick_second;
    private TextView brick_third;
    private TextView brick_fourth;
    private TextView brick_fifth;
    private TextView brick_sixth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brick);
        brick_first = findViewById(R.id.brick_first);
        brick_second = findViewById(R.id.brick_second);
        brick_third = findViewById(R.id.brick_third);
        brick_fourth = findViewById(R.id.brick_fourth);
        brick_fifth = findViewById(R.id.brick_fifth);
        brick_sixth = findViewById(R.id.brick_sixth);

        CommonTitleBar titleBar_board=findViewById(R.id.brick_title);
        titleBar_board.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                    onBackPressed();
                }
            }
        });
        brick_first.setOnClickListener(this);
        brick_second.setOnClickListener(this);
        brick_third.setOnClickListener(this);
        brick_fourth.setOnClickListener(this);
        brick_fifth.setOnClickListener(this);
        brick_sixth.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.brick_first:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.bohua);
                intent.putExtra("introduce",R.string.bohua);
                intent.putExtra("title","玻化砖");
                startActivity(intent);
                break;
            case R.id.brick_second:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.tongti);
                intent.putExtra("introduce",R.string.tongti);
                intent.putExtra("title","通体砖");
                startActivity(intent);
                break;
            case R.id.brick_third:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.youmian);
                intent.putExtra("introduce",R.string.youmian);
                intent.putExtra("title","釉面砖");
                startActivity(intent);
                break;
            case R.id.brick_fourth:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.fanggu);
                intent.putExtra("introduce",R.string.fanggu);
                intent.putExtra("title","仿古砖");
                startActivity(intent);
                break;
            case R.id.brick_fifth:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.paoguang);
                intent.putExtra("introduce",R.string.paoguang);
                intent.putExtra("title","抛光砖");
                startActivity(intent);
                break;
            case R.id.brick_sixth:
                intent=new Intent(brickActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.masaike);
                intent.putExtra("introduce",R.string.masaike);
                intent.putExtra("title","马赛克");
                startActivity(intent);
                break;
        }
    }
}
