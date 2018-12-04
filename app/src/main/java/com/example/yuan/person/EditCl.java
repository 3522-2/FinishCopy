package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Dao.MaterialDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Material;

public class EditCl extends AppCompatActivity {
    private ImageView fanhui;
    private Button xiugai, shanchu;
    private EditText CaiName, CaiP, CaiPin, CaiJ, CaiGong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cl);

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditCl.this, ChangeCl.class);
                startActivity(intent);
            }
        });

        getItem();

        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
//        Log.i("解析后的id",id);
        final MaterialDAO materialDAO = new MaterialDAO(EditCl.this);
        final Material material = materialDAO.find(id);

        CaiName.setText(material.getMaterial_name());
        CaiP.setText(material.getMaterial_type());
        CaiPin.setText(material.getMaterial_brand());
        CaiJ.setText(material.getMaterial_price());
        CaiGong.setText(material.getMaterial_provider());
        /**
         * 修改
         */
        xiugai = (Button)findViewById(R.id.xiugai);
        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem();
                String CaiName1 = CaiName.getText().toString();
                material.setMaterial_name(CaiName1);

                String CaiP1 = CaiP.getText().toString();
                material.setMaterial_type(CaiP1);

                String CaiPin1 = CaiPin.getText().toString();
                material.setMaterial_brand(CaiP1);

                String CaiJ1 = CaiJ.getText().toString();
                material.setMaterial_price(CaiJ1);

                String CaiGong1 = CaiGong.getText().toString();
                material.setMaterial_provider(CaiGong1);

                materialDAO.update(material);
                Toast.makeText(EditCl.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 删除
         */
        shanchu = (Button)findViewById(R.id.shanchu);
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDAO.deleteById(id);
                Intent intent1 = new Intent();
                intent1.setClass(EditCl.this,ChangeCl.class);
                startActivity(intent1);
                Toast.makeText(EditCl.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });


    }
        private void getItem () {
            CaiName = (EditText) findViewById(R.id.CaiName);//名字
            CaiP = (EditText) findViewById(R.id.XiaoP);//类型
            CaiPin = (EditText) findViewById(R.id.CaiPin);//品牌
            CaiJ = (EditText) findViewById(R.id.CaiJ);//价格
            CaiGong = (EditText) findViewById(R.id.XiaoGong);//供应商

        }
    }

