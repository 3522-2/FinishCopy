package com.example.yuan.A_test;


import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * MediaStore这个类是android系统提供的一个多媒体数据库
 */

public class tupianTest extends AppCompatActivity implements View.OnClickListener{

    public static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    public static final int CROP_PHOTO = 2; //剪裁照片
    private Button takePhoto;
    private ImageView picture;
    private Uri imageUri;
    public static File tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tupian_test);

        takePhoto = findViewById(R.id.take_photo);
        picture = findViewById(R.id.picture);

        takePhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //获取系統sdk版本
        int currentapiVersion = Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            //设置时间格式
            SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            //获取当前系统时间
            String filename = timeStampFormat.format(new Date());
            //设置照片的文件名为 时间.jpg
            //          tempFile = new File(Environment.getExternalStorageDirectory()+File.separator+"DCIM",filename + ".jpg");
            //         tempFile = new File("/data/data/com.example.yuan/picture/",filename + ".jpg");
            tempFile = new File(Environment.getExternalStorageDirectory(), "/DCIM/Camera/" + System.currentTimeMillis() + ".jpg");
            Log.i("父文件路径", String.valueOf(Environment.getExternalStorageDirectory()));
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
                Log.i("正在创建", "");
            } else{
                Log.i("已经存在", String.valueOf(tempFile));
                if (currentapiVersion < 24) {   // 如果系统的sdk从文件中创建uri

                    //指定输出地址
                    imageUri = Uri.fromFile(tempFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    Toast.makeText(tupianTest.this, "保存在" + imageUri, Toast.LENGTH_LONG).show();

                }
                else {

                    //Android 7.0之后调用相机的方式不允许以file://的方式调用，需要以共享文件的方式content://url
                    ContentValues contentValues = new ContentValues(1);
                    Log.i("执行了", "currentapiVersion 》= 24");
                    /**
                     * 检查是否有存储权限，以免崩溃
                     * ContextCompat 一个检查app是否有某种权限的工具
                     * ContentResolver就是按照一定规则访问内容提供者（ContentProvider）的数据
                     */
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                        return; //如果没有开启存储权限，退出此方法

                    }

                    //MediaStore.Images.Media.EXTERNAL_CONTENT_URI 设备照片存储的uri地址
//                imageUri = FileProvider.getUriForFile(tupianTest.this, "com.example.camera.fileprovider",tempFile );
                    imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    //指定拍照的输出地址
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                }
            }
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
                startActivityForResult(intent, PHOTO_REQUEST_CAREMA);

            }else{
                Toast.makeText(this, "存储卡不可用", Toast.LENGTH_LONG).show();
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case PHOTO_REQUEST_CAREMA:  //拍照
                if (resultCode == RESULT_OK) {  //如果拍好了照
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*"); //设置路径和文件类型为图片
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                }
                break;
            case CROP_PHOTO:
                if (resultCode == RESULT_OK && data != null) {  //如果剪裁好了

                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                        Bitmap bitmap1 =data.getParcelableExtra("data");
                        savePicture(bitmap1);
                        Toast.makeText(tupianTest.this,"保存在"+tempFile.getAbsolutePath(),Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
    public static String savePicture(Bitmap bitmap) {
        //设置时间格式
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        //获取当前系统时间
        String filename = timeStampFormat.format(new Date());
        String fileName = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "DCIM"
                + File.separator
                + filename + ".jpg";
        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();//创建文件夹
        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);//向缓冲区压缩图片
            bos.flush();
            bos.close();
            return fileName;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
}


