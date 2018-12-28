package com.example.yuan.XGT;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.Budge.ShowBudge;
import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;

public class ShowXGT extends AppCompatActivity {
    private ImageView fanhui;
    private TextView name,mianji,fengge,huxing,keting,woshi,shufang,canting,weishengjian,qita;
    private ImageView ketingI,woshiI,shufangI,cantingI,weishengjianI,qitaI;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_xgt);

        /**
         * 返回上一个页面
         */

        fanhui = (ImageView) findViewById(R.id.return1);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowXGT.this, XgtMain.class);
                startActivity(intent);
            }
        });
        final Intent intent =getIntent();
        final String id = intent.getStringExtra("id");
        Log.i("解析后的值",id);


        EffectDAO effectDAO = new EffectDAO(ShowXGT.this);
        Effect effect = effectDAO.find(id);
        Log.i("name的值",effect.getEffect_name());
        name = findViewById(R.id.name2);
        mianji = findViewById(R.id.mainji2);
        fengge = findViewById(R.id.fengge2);
        huxing = findViewById(R.id.huxing2);
        keting = findViewById(R.id.ketingT2);
        woshi = findViewById(R.id.woshiT2);
        shufang = findViewById(R.id.shufangT2);
        canting = findViewById(R.id.cantingT2);
        weishengjian = findViewById(R.id.weishengjianT2);
        qita = findViewById(R.id.qitaT2);

        name.setText(effect.getEffect_name());
        mianji.setText(effect.getEffect_area());
        fengge.setText(effect.getEffect_stytle());
        huxing.setText(effect.getEffect_type());
        keting.setText(effect.getEffect_ketingDes());
        woshi.setText(effect.getEffect_woshiDes());
        shufang.setText(effect.getEffect_shufangDes());
        canting.setText(effect.getEffect_cantingDes());
        weishengjian.setText(effect.getEffect_weishengjianDes());
        qita.setText(effect.getEffect_qitaDes());

        //获取图片
        ketingI = findViewById(R.id.keting2);
        woshiI = findViewById(R.id.woshi2);
        shufangI = findViewById(R.id.shufang2);
        cantingI = findViewById(R.id.canting2);
        weishengjianI = findViewById(R.id.weishengjian2);
        qitaI = findViewById(R.id.qita2);

        Bitmap bm = BitmapFactory.decodeFile(effect.getEffect_keting());
        ketingI.setImageBitmap(bm);

        Bitmap bm1 = BitmapFactory.decodeFile(effect.getEffect_woshi());
        woshiI.setImageBitmap(bm1);

        Bitmap bm2 = BitmapFactory.decodeFile(effect.getEffect_shufang());
        shufangI.setImageBitmap(bm2);

        Bitmap bm3 = BitmapFactory.decodeFile(effect.getEffect_canting());
        cantingI.setImageBitmap(bm3);

        Bitmap bm4 = BitmapFactory.decodeFile(effect.getEffect_weishengjian());
        weishengjianI.setImageBitmap(bm4);

        Bitmap bm5 = BitmapFactory.decodeFile(effect.getEffect_qita());
        qitaI.setImageBitmap(bm5);

        /**
         * 获取报价
         */
        textView = findViewById(R.id.ex);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(ShowXGT.this, XGTBudge.class);
                intent1.putExtra("id",id);
                startActivity(intent1);
            }
        });
    }
}
