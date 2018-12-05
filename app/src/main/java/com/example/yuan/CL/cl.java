package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.yuan.R;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

public class cl extends Activity implements View.OnClickListener {

    private CommonTitleBar titleBar;
    private View frame_first;
    private View frame_second;
    private View frame_third;
    private View frame_fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl);
        titleBar = findViewById(R.id.title);
        frame_first = findViewById(R.id.frame_first);
        frame_second = findViewById(R.id.frame_second);
        frame_third = findViewById(R.id.frame_third);
        frame_fourth = findViewById(R.id.frame_fourth);
        titleBar.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
               if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                      onBackPressed();
                 }
            }
        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        frame_first.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.frame_first:
                startActivity(new Intent(cl.this,boardActivity.class));
                break;
        }
    }
}
