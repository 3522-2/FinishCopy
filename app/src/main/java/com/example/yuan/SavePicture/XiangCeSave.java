package com.example.yuan.SavePicture;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.A_test.test;

import java.io.IOException;

/**
 * create by YUAN
 * on 2018/12/20
 */
public class XiangCeSave {


    private Context context;
    public XiangCeSave(Context context) {
        this.context = context;
    }

        public String save(Intent data, ImageView imageView) {
        String path = null;

            try {
            ContentResolver resolver =context.getContentResolver();
            Uri originalUri = data.getData(); // 获得图片的uri

            Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);//未报告的异常错误FileNotFoundException; 必须对其进行捕获或声明以便抛出

            imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 100, 100));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示
            // 显得到bitmap图片
                imageView.setImageBitmap(bm);

            String[] proj = {MediaStore.Images.Media.DATA};

            // 好像是android多媒体数据库的封装接口，具体的看Android文档
            Cursor cursor = context.getContentResolver().query(originalUri, proj, null, null, null);

            // 按我个人理解 这个是获得用户选择的图片的索引值
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            // 将光标移至开头 ，这个很重要，不小心很容易引起越界
            cursor.moveToFirst();
            // 最后根据索引值获取图片路径
            path = cursor.getString(column_index);
//                textView.setText(path);

        } catch (IOException e) {
            Log.e("TAG-->Error", e.toString());

        } finally {

            return path;

        }

    }


}