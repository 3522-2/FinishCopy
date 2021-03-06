package com.example.yuan.XGT;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.Budge.MyDialog;
import com.example.yuan.Budge.ShowBudge;
import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;
import com.example.yuan.person.login;

public class XGTBudge extends AppCompatActivity {
    private ImageView fanhui;
    private EditText area;
    private  TextView sum,btn;
    private MyDialog myDialog;
    private Float Main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgtbudge);
        /**
         * 返回上一个页面
         */
        final Intent intent =getIntent();
        final String id = intent.getStringExtra("id");
        Log.i("解析后的值",id);

        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("id",id);
                intent.setClass(XGTBudge.this, ShowXGT.class);
                startActivity(intent);
            }
        });

        sum = findViewById(R.id.sum1);
        btn = findViewById(R.id.btn1111);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EffectDAO effectDAO = new EffectDAO(XGTBudge.this);
                Effect effect = effectDAO.find(id);
                String DanDudge = effect.getEffect_PriceSum();
                Log.i("DanDudge",DanDudge);
                String DanMian = effect.getEffect_area();
                Log.i("DanMian",DanMian);

                Float danSum = Float.parseFloat(DanDudge);

                if (DanMian.equals("0-60")){
                    Main =Float.parseFloat("60");
                }if (DanMian.equals("60-75")) {
                    Main = Float.parseFloat("75");
                }if (DanMian.equals("76-90")) {
                    Main = Float.parseFloat("90");
                }if (DanMian.equals("91-120")) {
                    Main = Float.parseFloat("120");
                }if (DanMian.equals("121-145")) {
                    Main = Float.parseFloat("145");
                }if (DanMian.equals("146-200")) {
                    Main = Float.parseFloat("200");
                }if (DanMian.equals("200-")) {
                    Main = Float.parseFloat("200");
                }

                area = findViewById(R.id.area3);
                String getMain = area.getText().toString().trim();
                Float getM= Float.parseFloat(getMain);

                SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);
                String zhuangTai = sharedPreferences.getString("用户名","");


                if(zhuangTai.equals("未登录") || zhuangTai==null){
                    myDialog=new MyDialog(XGTBudge.this,R.style.MyDialog);
                    myDialog.setTitle("通知！");
                    myDialog.setMessage("您还未登录，请点击\"确认\"前往登录,点击\"取消\"忽略这条信息");

                    myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
                        @Override
                        public void onYesOnclick() {
                            Intent intent = new Intent();
                            intent.setClass(XGTBudge.this,login.class);
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
                    if (Main<=60){
                        Float a = (danSum/60)*getM;
                        sum.setText(String.valueOf(a));
                    }else if(60<Main && Main<=75){
                        Float a = (danSum/75)*getM;
                        sum.setText(String.valueOf(a));
                    }else if(75<Main && Main<=90) {
                        Float a = (danSum / 90) * getM;
                        sum.setText(String.valueOf(a));
                    }else if(90<Main && Main<=120) {
                        Float a = (danSum / 120) * getM;
                        sum.setText(String.valueOf(a));
                    } else if(121<Main && Main<=145) {
                        Float a = (danSum / 145) * getM;
                        sum.setText(String.valueOf(a));
                    } else if(145<Main && Main<=200) {
                        Float a = (danSum / 200) * getM;
                        sum.setText(String.valueOf(a));
                    }else if( Main>200) {
                        Float a = (danSum / Main) * getM;
                        sum.setText(String.valueOf(a));
                    }
                }
            }
        });

        }
}
