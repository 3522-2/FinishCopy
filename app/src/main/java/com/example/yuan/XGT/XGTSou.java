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

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;

public class XGTSou extends AppCompatActivity {
    private ImageView fanhui;
    private TextView name,mianji,fengge,huxing,keting,woshi,shufang,canting,weishengjian,qita;
    private ImageView ketingI,woshiI,shufangI,cantingI,weishengjianI,qitaI;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgtsou);

        final Intent intent = getIntent();
        final String feng = intent.getStringExtra("F");
        final String hu = intent.getStringExtra("H");
        final String mian = intent.getStringExtra("M");
        Log.i("F的值",feng);
        Log.i("H的值",hu);
        Log.i("M的值",mian);

        /**
         * 返回上一个页面
         */

        fanhui = (ImageView) findViewById(R.id.return1);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(XGTSou.this, XgtMain.class);
                startActivity(intent);
            }
        });
        EffectDAO effectDAO = new EffectDAO(XGTSou.this);
        Effect effect = effectDAO.find1(feng,hu,mian);

        Log.i("name的值",effect.getEffect_name());
        name = findViewById(R.id.name3);
        mianji = findViewById(R.id.mainji3);
        fengge = findViewById(R.id.fengge3);
        huxing = findViewById(R.id.huxing3);
        keting = findViewById(R.id.ketingT3);
        woshi = findViewById(R.id.woshiT3);
        shufang = findViewById(R.id.shufangT3);
        canting = findViewById(R.id.cantingT3);
        weishengjian = findViewById(R.id.weishengjianT3);
        qita = findViewById(R.id.qitaT3);

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
        ketingI = findViewById(R.id.keting3);
        woshiI = findViewById(R.id.woshi3);
        shufangI = findViewById(R.id.shufang3);
        cantingI = findViewById(R.id.canting3);
        weishengjianI = findViewById(R.id.weishengjian3);
        qitaI = findViewById(R.id.qita3);

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
                intent1.putExtra("F",feng);
                intent1.putExtra("H",hu);
                intent1.putExtra("M",mian);
                intent1.setClass(XGTSou.this, XGTSouBudge.class);
                startActivity(intent1);
            }
        });
    }
}
