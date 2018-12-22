package com.example.yuan.person;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.yuan.Dao.MaterialDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class AddCl extends AppCompatActivity {
    private ImageView fanhui;

    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;     //适配器
    private Button btnadd;
    private EditText CaiName, CaiP, CaiPin, CaiJ, CaiGong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cl);
        /**
         * 返回上一页
         */

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddCl.this, gaunliyuanMain.class);
                startActivity(intent);
            }
        });


        /**
         * 添加
         */
        btnadd = (Button) findViewById(R.id.add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaiName = (EditText) findViewById(R.id.CaiName);//名字
                CaiP = (EditText) findViewById(R.id.XiaoP);//类型
                CaiPin = (EditText) findViewById(R.id.CaiPin);//品牌
                CaiJ = (EditText) findViewById(R.id.CaiJ);//价格
                CaiGong = (EditText) findViewById(R.id.XiaoGong);//供应商


                String CaiName1 = CaiName.getText().toString();//名字
                String CaiP1 = CaiP.getText().toString();//类型
                String CaiPin1 = CaiPin.getText().toString();//品牌
                String CaiJ1 = CaiJ.getText().toString();//价格
                String CaiGong1 = CaiGong.getText().toString();//供应商

                Material material = new Material();
                MaterialDAO materialDAO = new MaterialDAO(AddCl.this);

                material.setMaterial_name(CaiName1);
                material.setMaterial_type(CaiP1);
                material.setMaterial_brand(CaiPin1);
                material.setMaterial_provider(CaiGong1);
                material.setMaterial_price(CaiJ1);


                materialDAO.add(material);
                Toast.makeText(AddCl.this, "基本信息添加成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("name",CaiName1);
                intent.setClass(AddCl.this,XclPic.class);
                startActivity(intent);

            }
        });

    }
}

