package com.example.yuan.person;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.Effect;

/**
 * create by YUAN
 * on 2018/12/20
 */
public class AddXiao extends AppCompatActivity {
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    private ImageView fanhui;
    private EditText XiaoName,XiaoFeng,XiaoMian,XiaoHu,
            XiaoOne,XiaoTwo,XiaoThree,XiaoFour,XiaoFive,
            XiaoSum,XiaoDes;
    private ImageView keting,woshi,shufang,canting,weishenjian,qita;
    private Button button;
    private Spinner spinnerH,spinnerA,spinnerT;
    private String item ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_xiao);
        XiaoName = (EditText)findViewById(R.id.XiaoName);
        XiaoFeng=(EditText)findViewById(R.id.XiaoFeng);
        XiaoMian=(EditText)findViewById(R.id.XiaoMian);
        XiaoHu=(EditText)findViewById(R.id.XiaoHu);
        XiaoOne=(EditText)findViewById(R.id.XiaoOne);
        XiaoTwo=(EditText)findViewById(R.id.XiaoTwo);
        XiaoThree=(EditText)findViewById(R.id.XiaoThree);
        XiaoFour=(EditText)findViewById(R.id.XiaoFour);
        XiaoFive=(EditText)findViewById(R.id.XiaoFive);

//        XiaoDes=(EditText)findViewById(R.id.XiaoDes);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddXiao.this, gaunliyuanMain.class);
                startActivity(intent);

            }
        });
        /**
         * 获取下拉框的值
         */
        spinnerH = (Spinner)findViewById(R.id.spinnerT);
        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                XiaoHu.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerA = (Spinner)findViewById(R.id.spinnerA);
        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
               XiaoMian.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerT = (Spinner)findViewById(R.id.spinnerF);
        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                XiaoFeng.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        keting = findViewById(R.id.keting);
//        keting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="客厅";
//                setImage();
//            }
//        });
//        shufang = findViewById(R.id.shufang);
//        shufang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="书房";
//                setImage();
//            }
//        });
//        woshi = findViewById(R.id.woshi);
//        woshi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="卧室";
//                setImage();
//            }
//        });
//        canting = findViewById(R.id.canting);
//        canting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="餐厅";
//                setImage();
//            }
//        });
//        weishenjian = findViewById(R.id.weishenjian);
//        weishenjian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="卫生间";
//                setImage();
//            }
//        });
//        qita = findViewById(R.id.qita);
//        qita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                item ="其他";
//                setImage();
//            }
//        });


        final Effect effect = new Effect();
        final EffectDAO effectDAO = new EffectDAO(AddXiao.this);
        button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取除图片之外的资源
                String XiaoName1= XiaoName.getText().toString();
                String XiaoFeng1 = XiaoFeng.getText().toString();
                String XiaoMian1 = XiaoMian.getText().toString();
                String XiaoHu1 = XiaoHu.getText().toString();
                String XiaoOne1 = XiaoOne.getText().toString();
                String Xiaotwo1 = XiaoTwo.getText().toString();
                String XiaoThree1 = XiaoThree.getText().toString();
                String XiaoFour1=XiaoFour.getText().toString();
                String XiaoFive1=XiaoFive.getText().toString();
//                String XiaoSum1 = XiaoSum.getText().toString();
//                String XiaoDes1=XiaoDes.getText().toString();

                float XiaoSum1 =Float.parseFloat(XiaoOne1)+Float.parseFloat(Xiaotwo1)+Float.parseFloat(XiaoThree1)
                        +Float.parseFloat(XiaoFour1)+Float.parseFloat(XiaoFive1);

                String XiaoSum2 = String.valueOf(XiaoSum1);

                Log.i("XiaoSum2",XiaoSum2);
                effect.setEffect_name(XiaoName1);
                effect.setEffect_stytle(XiaoFeng1);
                effect.setEffect_area(XiaoMian1);
                effect.setEffect_type(XiaoHu1);
                effect.setEffect_PriceOne(XiaoOne1);
                effect.setEffect_PriceTwo(Xiaotwo1);
                effect.setEffect_PriceThree(XiaoThree1);
                effect.setEffect_PriceFour(XiaoFour1);
                effect.setEffect_PriceFive(XiaoFive1);
                effect.setEffect_PriceSum(XiaoSum2);



                effectDAO.add(effect);
//
                Toast.makeText(AddXiao.this,"基本信息保存成功",Toast.LENGTH_SHORT).show();
                //添加对话框前往添加案例效果图

                Intent intent = new Intent();
                intent.setClass(AddXiao.this,XiaoPic.class);
                intent.putExtra("name",XiaoName1);
                startActivity(intent);
                finish();
            }
        });
    }



//    private void setImage() {
//        Intent intent = new Intent(Intent.ACTION_PICK, null);
//        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
//        startActivityForResult(intent, IMAGE_CODE);
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        final Effect effect = new Effect();
//
//        if (requestCode == IMAGE_CODE) {
//            Log.i("item的值",item);
//            if (item == "客厅"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,keting);
//                Log.i("path的值",path);
//                effect.setEffect_keting(path);
//
//            }
//            if (item == "书房"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,shufang);
//                Log.i("path的值",path);
//                effect.setEffect_shufang(path);
//
//            }
//            if (item == "卧室"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,woshi);
//                Log.i("path的值",path);
//                effect.setEffect_woshi(path);
//
//            }
//            if (item == "餐厅"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,canting);
//                Log.i("path的值",path);
//                effect.setEffect_canting(path);
//
//            }
//            if (item == "卫生间"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,weishenjian);
//                Log.i("path的值",path);
//                effect.setEffect_weishengjian(path);
//
//            }
//            if (item == "其他"){
//                XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//                String  path = xiangCeSave.save(data,qita);
//                Log.i("path的值",path);
//                effect.setEffect_qita(path);
//
//            }
//
//
////            XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
////           String  path = xiangCeSave.save(data,keting);
////            Log.i("path的值",path);
//        }
//
//
//        }

    }
