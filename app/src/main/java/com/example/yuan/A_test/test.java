package com.example.yuan.A_test;


import java.io.IOException;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;

public class test extends Activity {
    private Button btnPhone;
    private ImageView imageView;


    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        btnPhone = (Button) findViewById(R.id.btnPhone);
        imageView = (ImageView) findViewById(R.id.imageView);

        tv = (TextView) findViewById(R.id.img_path);//图片路径
        btnPhone.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                setImage(); // 魅族显示风格：最新，照片，图库；华为：包含有相片的一组目录，
            }

        });

    }

    private void setImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, IMAGE_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CODE) {
            XiangCeSave xiangCeSave = new XiangCeSave(test.this);
            xiangCeSave.save(data,imageView);
        }

    }
//public String save(Intent data,ImageView imageView) {
//    String path = null;
//    try {
//        ContentResolver resolver = getContentResolver();
//        Uri originalUri = data.getData(); // 获得图片的uri
//
//        Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);//未报告的异常错误FileNotFoundException; 必须对其进行捕获或声明以便抛出
//
//        imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 100, 100));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示
//        // 显得到bitmap图片
//        // imageView.setImageBitmap(bm);
//
//        String[] proj = {MediaStore.Images.Media.DATA};
//
//        // 好像是android多媒体数据库的封装接口，具体的看Android文档
//        Cursor cursor = getContentResolver().query(originalUri, proj, null, null, null);
//
//        // 按我个人理解 这个是获得用户选择的图片的索引值
//        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        // 将光标移至开头 ，这个很重要，不小心很容易引起越界
//        cursor.moveToFirst();
//        // 最后根据索引值获取图片路径
//        path = cursor.getString(column_index);
//        tv.setText(path);
//
//    } catch (IOException e) {
//        Log.e("TAG-->Error", e.toString());
//
//    } finally {
//        Log.i("图片路径",path);
//        return path;
//
//    }


}