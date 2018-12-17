package com.example.yuan.person;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;
import com.example.yuan.modle.User;

import java.util.ArrayList;
import java.util.HashMap;

public class AddXiao extends AppCompatActivity {
    private ImageView fanhui;
    private GridView gridView1;              //网格显示缩略图
    private final int IMAGE_OPEN = 1;        //打开图片标记
    private String pathImage;                //选择图片路径
    private Bitmap bmp;                      //导入临时图片
    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;     //适配器
    private  Button btnadd;
    private EditText XiaoName,XiaoFeng,XiaoMian,XiaoHu,
            XiaoOne,XiaoTwo,XiaoThree,XiaoFour,XiaoFive,
            XiaoSum,XiaoDes;
    private Spinner spinnerH,spinnerA,spinnerT;
    @Override
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
        XiaoSum=(EditText)findViewById(R.id.XiaoSum);
        gridView1=(GridView)findViewById(R.id.gridView1);
        XiaoDes=(EditText)findViewById(R.id.XiaoDes);
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
        gridView1 = (GridView) findViewById(R.id.gridView1);

        /*
         * 载入默认图片添加图片加号
         * 通过适配器实现
         * SimpleAdapter参数imageItem为数据源 R.layout.griditem_addpic为布局
         */
        //获取资源图片加号
        bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.home);
        imageItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("itemImage", bmp);
        imageItem.add(map);
        simpleAdapter = new SimpleAdapter(this,
                imageItem, R.layout.griditem_addpic,
                new String[] { "itemImage"}, new int[] { R.id.imageView1});
        /*
         * HashMap载入bmp图片在GridView中不显示,但是如果载入资源ID能显示 如
         * map.put("itemImage", R.drawable.img);
         * 解决方法:
         *              1.自定义继承BaseAdapter实现
         *              2.ViewBinder()接口实现
         *  参考 http://blog.csdn.net/admin_/article/details/7257901
         */
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,String textRepresentation) {
                // TODO Auto-generated method stub
                if(view instanceof ImageView && data instanceof Bitmap){
                    ImageView i = (ImageView)view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });
        gridView1.setAdapter(simpleAdapter);

        /*
         * 监听GridView点击事件
         * 报错:该函数必须抽象方法 故需要手动导入import android.view.View;
         */
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if( imageItem.size() == 10) { //第一张为默认图片
                    Toast.makeText(AddXiao.this, "图片数9张已满", Toast.LENGTH_SHORT).show();
                }
                else if(position == 0) { //点击图片位置为+ 0对应0张图片
                    Toast.makeText(AddXiao.this, "添加图片", Toast.LENGTH_SHORT).show();
                    //选择图片
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, IMAGE_OPEN);
                    //通过onResume()刷新数据
                }
                else {
                    dialog(position);
                    //Toast.makeText(MainActivity.this, "点击第"+(position + 1)+" 号图片",
                    //		Toast.LENGTH_SHORT).show();
                }
            }
        });

        //----------------------------------------------------------------------------------------

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
        /**
         * 添加
         */
        btnadd = (Button)findViewById(R.id.add);
        btnadd.setOnClickListener(new View.OnClickListener() {
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
                String XiaoSum1 = XiaoSum.getText().toString();
                String XiaoDes1=XiaoDes.getText().toString();
                //---------------   获取图片资源------------------------------------------


                //------------------------------------------------------------------------------
                Effect effect = new Effect();
                EffectDAO effectDAO = new EffectDAO(AddXiao.this);


                effect.setEffect_name(XiaoName1);
                effect.setEffect_stytle(XiaoFeng1);
                effect.setEffect_area(XiaoMian1);
                effect.setEffect_type(XiaoHu1);
                effect.setEffect_PriceOne(XiaoOne1);
                effect.setEffect_PriceTwo(Xiaotwo1);
                effect.setEffect_PriceThree(XiaoThree1);
                effect.setEffect_PriceFour(XiaoFour1);
                effect.setEffect_PriceFive(XiaoFive1);
                effect.setEffect_PriceSum(XiaoSum1);
                effect.setEffect_describe(XiaoDes1);
//                Log.i("描述",XiaoDes1);
                effectDAO.add(effect);
                Toast.makeText(AddXiao.this,"添加成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(AddXiao.this,AddXiao.class);
                startActivity(intent);

            }
        });
        //--------------------------------------------------------------------------------------
    }

    //获取图片路径 响应startActivityForResult
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //打开图片
        if(resultCode==RESULT_OK && requestCode==IMAGE_OPEN) {
            Uri uri = data.getData();
            if (!TextUtils.isEmpty(uri.getAuthority())) {
                //查询选择图片
                Cursor cursor = getContentResolver().query(
                        uri,
                        new String[] { MediaStore.Images.Media.DATA },
                        null,
                        null,
                        null);
                //返回 没找到选择图片
                if (null == cursor) {
                    return;
                }
                //光标移动至开头 获取图片路径
                cursor.moveToFirst();
                pathImage = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
            }
        }  //end if 打开图片
    }

    //刷新图片
    @Override
    protected void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(pathImage)){
            Bitmap addbmp=BitmapFactory.decodeFile(pathImage);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", addbmp);
            imageItem.add(map);
            simpleAdapter = new SimpleAdapter(this,
                    imageItem, R.layout.griditem_addpic,
                    new String[] { "itemImage"}, new int[] { R.id.imageView1});
            simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                @Override
                public boolean setViewValue(View view, Object data,
                                            String textRepresentation) {
                    // TODO Auto-generated method stub
                    if(view instanceof ImageView && data instanceof Bitmap){
                        ImageView i = (ImageView)view;
                        i.setImageBitmap((Bitmap) data);
                        return true;
                    }
                    return false;
                }
            });
            gridView1.setAdapter(simpleAdapter);
            simpleAdapter.notifyDataSetChanged();
            //刷新后释放防止手机休眠后自动添加
            pathImage = null;
        }
    }

    /*
     * Dialog对话框提示用户删除操作
     * position为删除图片位置
     */
    protected void dialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddXiao.this);
        builder.setMessage("确认移除已添加图片吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                imageItem.remove(position);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    }

