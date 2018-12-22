package com.example.yuan.person;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Dao.MaterialDAO;
import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.Material;

public class EditCl extends AppCompatActivity {
    private ImageView fanhui;
    private Button xiugai, shanchu;
    private EditText CaiName, CaiP, CaiPin, CaiJ, CaiGong,CaiMiao;
    private ImageView CaiPic;
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的

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
                finish();
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
        CaiMiao.setText(material.getMaterial_photoDes());

        CaiPic = (ImageView) findViewById(R.id.CaiPic);
        String filePath = material.getMaterial_photo();
        Log.i("keting1的路径", filePath);
        Bitmap bm = BitmapFactory.decodeFile(filePath);
        CaiPic.setImageBitmap(bm);

        /**
         * 修改图片
         */
        final String name = material.getMaterial_name();
        CaiPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage(name);
            }
        });

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
                Intent intent1 = new Intent();
                intent1.setClass(EditCl.this,ChangeCl.class);
                startActivity(intent1);
                finish();
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
                Toast.makeText(EditCl.this, "删除成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditCl.this,ChangeCl.class);
                startActivity(intent1);
                finish();

            }
        });


    }
        private void getItem () {
            CaiName = (EditText) findViewById(R.id.CaiName);//名字
            CaiP = (EditText) findViewById(R.id.CaiP);//类型
            CaiPin = (EditText) findViewById(R.id.CaiPin);//品牌
            CaiJ = (EditText) findViewById(R.id.CaiJ);//价格
            CaiGong = (EditText) findViewById(R.id.CaiGong);//供应商
            CaiMiao = (EditText)findViewById(R.id.CaiMiao);//材料描述
            CaiPic = (ImageView)findViewById(R.id.CaiPic);

        }
    private void setImage(String name) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        intent.putExtra("biao",name);
        startActivityForResult(intent, IMAGE_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
//        Log.i("解析后的id",id);
        final MaterialDAO materialDAO = new MaterialDAO(EditCl.this);
        final Material material = materialDAO.find(id);
        String name = material.getMaterial_name();
        if (requestCode == IMAGE_CODE) {
            XiangCeSave xiangCeSave = new XiangCeSave(EditCl.this);
            String  path = xiangCeSave.save(data,CaiPic);
//                Log.i("path的值",path);
            material.setMaterial_photo(path);
            materialDAO.addPhoto(material,name);

        }

    }
    }

