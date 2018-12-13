package com.example.yuan.Budge;

import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;
import com.example.yuan.person.login;

public class ShowBudge extends AppCompatActivity {
    private ImageView fanhui;
    private TextView HuXing,FengGe,Main;
    private Spinner spinner1,spinner2,spinner3;
    private TextView Get;
    private TextView Zong;
    private TextView Sum;
    private MyDialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_budge);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowBudge.this,MainActivity.class);
                startActivity(intent);
            }
        });

        HuXing = (TextView) findViewById(R.id.huxing);
        spinner1 = (Spinner)findViewById(R.id.spinnerT);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                HuXing.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        FengGe = (TextView) findViewById(R.id.fengge);
        spinner2 = (Spinner)findViewById(R.id.spinnerS);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                FengGe.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Main = (TextView) findViewById(R.id.mian);
        spinner3 = (Spinner)findViewById(R.id.spinnerA);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                Main.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * 获取详细信息
         */

//        SchemeDAO schemeDAO = new SchemeDAO(ShowBudge.this);
        Get = (TextView) findViewById(R.id.Get1);
        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);
                String zhuangTai = sharedPreferences.getString("用户名","");

                if(zhuangTai.equals("未登录") || zhuangTai==null){
                    myDialog=new MyDialog(ShowBudge.this,R.style.MyDialog);
                    myDialog.setTitle("通知！");
                    myDialog.setMessage("您还未登录，请点击\"确认\"前往登录,点击\"取消\"忽略这条信息");

                    myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
                        @Override
                        public void onYesOnclick() {
                           Intent intent = new Intent();
                           intent.setClass(ShowBudge.this,login.class);
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
                }else{
                 String huxing = HuXing.getText().toString().trim();
                 String fengge = FengGe.getText().toString().trim();
                 String mianji = Main.getText().toString().trim();
                    Intent intent1 = new Intent();
                    intent1.setClass(ShowBudge.this,XiangBudge.class);
                    intent1.putExtra("户型",huxing);
                    intent1.putExtra("风格",fengge);
                    intent1.putExtra("面积",mianji);
                    startActivity(intent1);
                }
               }

        });
        /**
         * 获取总费用
         */

        Sum = (TextView)findViewById(R.id.Sum);
         final SchemeDAO schemeDAO = new SchemeDAO(ShowBudge.this);
        Zong = (TextView)findViewById(R.id.Sum1);
        Zong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String huxing = HuXing.getText().toString().trim();
                 String fengge = FengGe.getText().toString().trim();
                 String mianji = Main.getText().toString().trim();
                if(huxing.equals("户型")==false && fengge.equals("风格")== false && mianji.equals("面积")== false){
                    String id1 = String.valueOf(huxing);
                    String id2 = String.valueOf(fengge);
                    String id3 = String.valueOf(mianji);
                    Toast.makeText(ShowBudge.this,"户型:"+huxing+"  风格:"+fengge+"  面积:"+mianji,Toast.LENGTH_SHORT).show();
                         Scheme scheme = schemeDAO.find1(id1,id2,id3);
//                    Scheme scheme = schemeDAO.find1(huxing,fengge,mianji);
                    Sum.setText(scheme.getScheme_pirceSum());
                }else {
                    Toast.makeText(ShowBudge.this, "请选择", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
