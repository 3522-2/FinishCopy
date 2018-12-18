package com.example.yuan.person;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yuan.Budge.MyDialog;
import com.example.yuan.Dao.HongBaoDAO;
import com.example.yuan.Dao.MaterialDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.HongBao;
import com.example.yuan.modle.Material;

import java.util.List;

public class ShowHongBao extends AppCompatActivity {
    ListView lvinfo;
    private ImageView fanhui;
    private MyDialog myDialog;
    private RelativeLayout OneB,TwoB;
    private TextView TVthree,TVthreeH,TVthreeTel,TVthou,TVthouH,TVthouTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hong_bao);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowHongBao.this, PersonMain.class);
                startActivity(intent);
                finish();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);
        final String name = sharedPreferences.getString("用户名", "");
        HongBaoDAO hongBaoDAO = new HongBaoDAO(ShowHongBao.this);
        HongBao hongBao = hongBaoDAO.find(name);
        String three = hongBao.getHong_three();
        String thou = hongBao.getHong_thou();
        String tel = hongBao.getHong_nametel();
        TVthree = findViewById(R.id.TVthree);
        TVthreeH= findViewById(R.id.TVthreeH);
        TVthreeTel= findViewById(R.id.TVthreeTel);
        TVthou= findViewById(R.id.TVthou);
        TVthouH= findViewById(R.id.TVthouH);
        TVthouTel= findViewById(R.id.TVthouTel);
//        Toast.makeText(ShowHongBao.this,"thou的值:"+thou+" three的值："+three,Toast.LENGTH_SHORT).show();
        if (name.equals("未登录")){
            myDialog = new MyDialog(ShowHongBao.this, R.style.MyDialog);
            myDialog.setTitle("通知！");
            myDialog.setMessage("您还未登录，请点击\"确认\"前往登录,点击\"取消\"忽略这条信息");

            myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
                @Override
                public void onYesOnclick() {
                    Intent intent = new Intent();
                    intent.setClass(ShowHongBao.this, MainActivity.class);
                    startActivity(intent);
                    myDialog.dismiss();
                }
            });
            myDialog.setNoOnclickListener("取消", new MyDialog.onNoOnclickListener() {
                @Override
                public void onNoClick() {

                    myDialog.dismiss();
                }
            });
            myDialog.show();
        }else {//已经登录
            if (thou.equals("0") && three.equals("0")) {
                myDialog = new MyDialog(ShowHongBao.this, R.style.MyDialog);
                myDialog.setTitle("温馨提示！");
                myDialog.setMessage("您还未领取红包，前往首页领取");

                myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        Intent intent = new Intent();
                        intent.setClass(ShowHongBao.this, MainActivity.class);
                        startActivity(intent);
                        myDialog.dismiss();
                    }
                });
                myDialog.setNoOnclickListener("取消", new MyDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {

                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            } else if (thou.equals("1000") && three.equals("0")) {//领取了一个1000的红包
                setthou(thou,"年终钜惠","限用手机号码"+tel);
                TVthree.setText("");
                TVthreeH.setText("");
                TVthreeTel.setText("");
                Toast.makeText(ShowHongBao.this, "thou的值:" + thou + " three的值：" + three, Toast.LENGTH_SHORT).show();
            } else if (thou.equals("0") && three.equals("300")) {//领取了一个300的红包
                setthou(three,"新人红包","限用手机号码"+tel);
                TVthree.setText("");
                TVthreeH.setText("");
                TVthreeTel.setText("");
                Toast.makeText(ShowHongBao.this, "thou的值:" + thou + " three的值：" + three, Toast.LENGTH_SHORT).show();
            } else if (thou.equals("1000") && three.equals("300")) {//两个都领取了
                setthou(thou,"年终钜惠","限用手机号码"+tel);
                setthree(three,"新人红包","限用手机号码"+tel);
                Toast.makeText(ShowHongBao.this, "thou的值:" + thou + " three的值：" + three, Toast.LENGTH_SHORT).show();
            }
        }

    }
    @SuppressLint("ResourceAsColor")
    private void setthree(String HongBao, String HongBaoName, String HongBaoTel){
        TVthree = findViewById(R.id.TVthree);
        TVthreeH= findViewById(R.id.TVthreeH);
        TVthreeTel= findViewById(R.id.TVthreeTel);
        TVthou= findViewById(R.id.TVthou);
        TVthouH= findViewById(R.id.TVthouH);

        TwoB = findViewById(R.id.TwoR);
        TVthree.setText(HongBao);
        TVthreeH.setText(HongBaoName);
        TVthreeTel.setText(HongBaoTel);
        TwoB.setBackgroundColor(R.color.colorAccent);

    }
    @SuppressLint("ResourceAsColor")
    private void setthou(String HongBao, String HongBaoName, String HongBaoTel){
        OneB =findViewById(R.id.OneR);
        TVthou= findViewById(R.id.TVthou);
        TVthouH= findViewById(R.id.TVthouH);
        TVthouTel= findViewById(R.id.TVthouTel);
        TVthou.setText(HongBao);
        TVthouH.setText(HongBaoName);
        TVthouTel.setText(HongBaoTel);
        OneB.setBackgroundColor(R.color.colorAccent);

    }
}
