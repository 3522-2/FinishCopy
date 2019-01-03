package com.example.yuan.XGT;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

public class Firstactivity extends Activity {
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgt_example1);
        imageView=findViewById(R.id.return1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Firstactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
