package com.example.yuan.A_test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.R;
import com.example.yuan.SavePicture.SavePicture;

import static com.example.yuan.A_test.tupianTest.hasSdcard;

@SuppressLint("SdCardPath")
public class test2 extends Activity {
    public static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private Button button;
    private ImageView view;
    private Uri imageUri;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        button = (Button) findViewById(R.id.button1);
        view = (ImageView) findViewById(R.id.imageView1);


        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

    //拍照            // TODO Auto-generated method stub
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
            }
        });
    }


    @SuppressLint("SdCardPath")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (hasSdcard()) {
            switch (requestCode) {
                case PHOTO_REQUEST_CAMERA:  //拍照
                    if (resultCode == RESULT_OK) {  //如果拍好了照

                        Bundle bundle = data.getExtras();
                        SavePicture savePicture = new SavePicture();  //保存图片
                        savePicture.savePicture(bundle, view);
                    }
                    break;

            }


        } else {
            Toast.makeText(test2.this, "储存卡不可用", Toast.LENGTH_SHORT).show();
        }

    }
}