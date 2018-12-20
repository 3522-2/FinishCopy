package com.example.yuan.SavePicture;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * create by YUAN
 * on 2018/12/19
 */
public class SavePicture {

    public String savePicture(Bundle bundle, ImageView imageView){
        Bitmap bitmap = (Bitmap) bundle.get("data");// 获取返回的数据，并转换为Bitmap图片格式
        String name = DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";//图片存储路径
        //保存图片
        FileOutputStream b = null;
        File file = new File("/sdcard/Image/");
        file.mkdirs();// 创建文件夹
        String fileName = "/sdcard/Image/" + name;

        try {
            b = new FileOutputStream(fileName);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            imageView.setImageBitmap(bitmap);// 将图片显示在ImageView里
        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }
        return name;
    }

}
