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
 * 油漆
 */

public class oilActivity extends Activity implements View.OnClickListener{

    private TextView oil_first;
    private TextView oil_second;
    private TextView oil_third;
    private TextView oil_fourth;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);
        oil_first = findViewById(R.id.oil_first);
        oil_second = findViewById(R.id.oil_second);
        oil_third = findViewById(R.id.oil_third);
        oil_fourth = findViewById(R.id.oil_fourth);
        CommonTitleBar titleBar_board=findViewById(R.id.oil_title);
        titleBar_board.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                    onBackPressed();
                }

            }
        });
        oil_first.setOnClickListener(this);
        oil_second.setOnClickListener(this);
        oil_third.setOnClickListener(this);
        oil_fourth.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.oil_first:
                 intent=new Intent(oilActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.muqi);
                intent.putExtra("introduce",R.string.muqi);
                intent.putExtra("title","木器漆");
                startActivity(intent);
                break;
            case R.id.oil_second:
                 intent=new Intent(oilActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.neiqiang);
                intent.putExtra("introduce",R.string.neiqiang);
                intent.putExtra("title","内墙漆");
                startActivity(intent);
                break;
            case R.id.oil_third:
                 intent=new Intent(oilActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.waiqiang);
                intent.putExtra("introduce",R.string.waiqiang);
                intent.putExtra("title","外墙漆");
                startActivity(intent);
                break;
            case R.id.oil_fourth:
                 intent=new Intent(oilActivity.this,cl_child_Activity.class);
                intent.putExtra("picture",R.drawable.fanghuo);
                intent.putExtra("introduce",R.string.fanghuoqi);
                intent.putExtra("title","防火漆");
                startActivity(intent);
                break;
        }
    }
}
