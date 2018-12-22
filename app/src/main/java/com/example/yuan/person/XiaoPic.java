package com.example.yuan.person;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.Effect;

public class XiaoPic extends AppCompatActivity {

    private  String item;
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    private ImageView fanhui;
    private ImageView keting,woshi,shufang,canting,weishenjian,qita;
    private EditText ketingT,woshiT,shufangT,cantingT,weishenjianT,qitaT;
    private ImageView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_pic);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        Log.i("解析后的name",name);


        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(XiaoPic.this,gaunliyuanMain.class);
                startActivity(intent);
                finish();
            }
        });

        /**
         * 保存描述
         */
        ketingT = (EditText)findViewById(R.id.ketingT);
        woshiT=(EditText)findViewById(R.id.woshiT);
        shufangT=(EditText)findViewById(R.id.shufangT);
        cantingT=(EditText)findViewById(R.id.cantingT);
        weishenjianT=(EditText)findViewById(R.id.weishengjianT);
        qitaT=(EditText)findViewById(R.id.qitaT);;
        btn = (ImageView) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ke = ketingT.getText().toString();
                String wo = woshiT.getText().toString();
                String shu = shufangT.getText().toString();
                String can = cantingT.getText().toString();
                String wei = weishenjianT.getText().toString();
                String qi = qitaT.getText().toString();
                Effect effect = new Effect();
                EffectDAO effectDAO = new EffectDAO(XiaoPic.this);
                effect.setEffect_ketingDes(ke);
                effect.setEffect_woshiDes(wo);
                effect.setEffect_shufangDes(shu);
                effect.setEffect_cantingDes(can);
                effect.setEffect_weishengjianDes(wei);
                effect.setEffect_qitaDes(qi);
                effectDAO.addDes(effect,name);
                Toast.makeText(XiaoPic.this,"图片信息添加成功",Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 客厅
         */
        keting = findViewById(R.id.keting);
        keting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "客厅";
//                Log.i("点击事件中的的name",name);
                setImage(name);
            }
        });

        /**
         * 卧室
         */
        woshi = findViewById(R.id.woshi);
        woshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "卧室";
                setImage(name);
            }
        });
        /**
         * 书房
         */
        shufang = findViewById(R.id.shufang);
        shufang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "书房";
                setImage(name);
            }
        });
        /**
         * 餐厅
         */
        canting = findViewById(R.id.canting);
        canting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "餐厅";
                setImage(name);
            }
        });
        /**
         * 卫生间
         */
        weishenjian = findViewById(R.id.weishengjian);
        weishenjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "卫生间";
                setImage(name);
            }
        });
        /**
         * 其他
         */
        qita = findViewById(R.id.qita);
        qita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "其他";
                setImage(name);
            }
        });
    }
        private void setImage(String name) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        intent.putExtra("biao",name);
        startActivityForResult(intent, IMAGE_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Effect effect = new Effect();
        EffectDAO effectDAO = new EffectDAO(XiaoPic.this);
        if (requestCode == IMAGE_CODE) {
            Log.i("item的值",item);
            if (item == "客厅"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,keting);
//                Log.i("path的值",path);
                effect.setEffect_keting(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addKeting(effect,name);

            }
            if (item == "书房"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,shufang);
                Log.i("path的值",path);
                effect.setEffect_shufang(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addshufang(effect,name);

            }
            if (item == "卧室"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,woshi);
                Log.i("path的值",path);
                effect.setEffect_woshi(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addwoshi(effect,name);

            }
            if (item == "餐厅"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,canting);
                Log.i("path的值",path);
                effect.setEffect_canting(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addcanting(effect,name);

            }
            if (item == "卫生间"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,weishenjian);
                Log.i("path的值",path);
                effect.setEffect_weishengjian(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addweishengjian(effect,name);

            }
            if (item == "其他"){
                XiangCeSave xiangCeSave = new XiangCeSave(XiaoPic.this);
                String  path = xiangCeSave.save(data,qita);
                Log.i("path的值",path);
                effect.setEffect_qita(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
                effectDAO.addqita(effect,name);

            }


//            XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//           String  path = xiangCeSave.save(data,keting);
//            Log.i("path的值",path);
        }


        }



}
