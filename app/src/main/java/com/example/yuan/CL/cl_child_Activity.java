package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.R;

/**
 * Created by lenovo on 2018/12/9.
 */

public class cl_child_Activity extends Activity {

    private SimpleToolbar mSimpleToolbar;
    private TextView text_adapter;
    private ImageView imageView_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        mSimpleToolbar = findViewById(R.id.simple_toolbar);
        text_adapter = findViewById(R.id.text_adapter_child);
        imageView_adapter = findViewById(R.id.image_adapter_child);
        mSimpleToolbar.setLeftTitleClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSimpleToolbar.setRightTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cl_child_Activity.this, "点击了右侧Title", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent=getIntent();
        int number=Integer.parseInt(intent.getStringExtra("number"));
        if(number==1) {
            String name = intent.getStringExtra("xigong");
            mSimpleToolbar.setMainTitle("细工板");
            text_adapter.setText(R.string.xigong);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.xigong));
        }
        if(number==2) {
            String name = intent.getStringExtra("xigong");
            mSimpleToolbar.setMainTitle("装饰板");
            text_adapter.setText(R.string.zhuangshi);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.zhuangshi));
        }
        if(number==3) {
            String name = intent.getStringExtra("jiaohe");
            mSimpleToolbar.setMainTitle("胶合板");
            text_adapter.setText(R.string.jiaohe);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.jiaohe));
        }
        if(number==4) {
            String name = intent.getStringExtra("jihe");
            mSimpleToolbar.setMainTitle("集合板");
            text_adapter.setText(R.string.jihe);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.jihe));
        }
        if(number==5) {
            String name = intent.getStringExtra("fanghuo");
            mSimpleToolbar.setMainTitle("防火板");
            text_adapter.setText(R.string.fanghuo);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.fanhuo));
        }
        if(number==6) {
            String name = intent.getStringExtra("paohua");
            mSimpleToolbar.setMainTitle("刨花板");
            text_adapter.setText(R.string.paohua);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.paohua));
        }
        if(number==7) {
            String name = intent.getStringExtra("shigao");
            mSimpleToolbar.setMainTitle("石膏板");
            text_adapter.setText(R.string.shigao);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.shigao));
        }
        if(number==8) {
            String name = intent.getStringExtra("lvkou");
            mSimpleToolbar.setMainTitle("铝扣板");
            text_adapter.setText(R.string.lvkou);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.lvkou));
        }
        if(number==9) {
            String name = intent.getStringExtra("lvsu");
            mSimpleToolbar.setMainTitle("铝塑板");
            text_adapter.setText(R.string.lvsu);
            imageView_adapter.setImageDrawable( this.getResources().getDrawable(R.drawable.lvshuo));
        }
    }


}
