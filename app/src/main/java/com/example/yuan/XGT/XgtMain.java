package com.example.yuan.XGT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;


import com.example.yuan.R;



public class XgtMain extends AppCompatActivity {
    private RelativeLayout border1;
    private RelativeLayout border2;
    private RelativeLayout border3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgt_main);
        border1 = findViewById(R.id.border1);
        border1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(XgtMain.this, Firstactivity.class);
                startActivity(intent);
            }
        });
        border2 = findViewById(R.id.border2);
        border2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(XgtMain.this, Secondactivity.class);
                startActivity(intent);
            }
        });
        border3 = findViewById(R.id.border3);
        border3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = new Intent(XgtMain.this, Thirdactivity.class);
                startActivity(intent);
            }
        });
    }
}
