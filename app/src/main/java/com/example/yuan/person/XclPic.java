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
import android.widget.Toast;

import com.example.yuan.Dao.MaterialDAO;
import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.Material;

public class XclPic extends AppCompatActivity {

    private EditText miao;
    private ImageView fanhui;
    private ImageView btn,queding;
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xcl_pic);
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
                intent.setClass(XclPic.this,gaunliyuanMain.class);
                startActivity(intent);
                finish();
            }
        });
        /**
         * 添加描述
         */
        miao = findViewById(R.id.te);
        queding = findViewById(R.id.btn);
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String miao1 = miao.getText().toString();
                Material material = new Material();
                MaterialDAO materialDAO = new MaterialDAO(XclPic.this);
                material.setMaterial_photoDes(miao1);
                materialDAO.addPhotoDes(material,name);

                Toast.makeText(XclPic.this,"图片添加成功",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(XclPic.this,gaunliyuanMain.class);
                startActivity(intent1);

            }
        });

        /**
         * 添加图片
         */
        btn = findViewById(R.id.clBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        final Material material = new Material();
        MaterialDAO materialDAO = new MaterialDAO(XclPic.this);
        if (requestCode == IMAGE_CODE) {
                XiangCeSave xiangCeSave = new XiangCeSave(XclPic.this);
                String  path = xiangCeSave.save(data,btn);
//                Log.i("path的值",path);
                material.setMaterial_photo(path);
                Intent intent = getIntent();
                final String name = intent.getStringExtra("name");
//                Log.i("解析后的name",name);
             materialDAO.addPhoto(material,name);

            }

        }

}
