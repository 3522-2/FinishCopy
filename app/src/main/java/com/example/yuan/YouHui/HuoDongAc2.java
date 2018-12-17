package com.example.yuan.YouHui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Budge.MyDialog;

import com.example.yuan.Dao.HongBaoDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;

import com.example.yuan.modle.HongBao;
import com.example.yuan.person.PersonMain;
import com.example.yuan.person.login;

public class HuoDongAc2 extends AppCompatActivity {
    private ImageView fanhui;
    private EditText Name,Tel;
    private Button btn;
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong_ac2);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HuoDongAc2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 领取
         */


        Name = (EditText)findViewById(R.id.name) ;
        Tel = (EditText)findViewById(R.id.tel);
        SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);
        final String zhuangTai = sharedPreferences.getString("用户名","");
        btn = (Button)findViewById(R.id.btn);
        final HongBao hongBao = new HongBao();
        final HongBaoDAO hongBaoDAO = new HongBaoDAO(HuoDongAc2.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().trim();
                String tel = Tel.getText().toString().trim();
                Log.i("name的值",name);
                HongBao hongBao1= hongBaoDAO.find(name);
                String three = hongBao1.getHong_three();
                String thou = hongBao1.getHong_thou();
                Log.i("name的值",three);
                if(zhuangTai.equals("未登录") || zhuangTai==null){//未登录
                    myDialog=new MyDialog(HuoDongAc2.this,R.style.MyDialog);
                    myDialog.setTitle("通知！");
                    myDialog.setMessage("您还未登录，请点击\"确认\"前往登录,点击\"取消\"忽略这条信息");

                    myDialog.setYesOnclickListener("确定", new MyDialog.onYesOnclickListener() {
                        @Override
                        public void onYesOnclick() {
                            Intent intent = new Intent();
                            intent.setClass(HuoDongAc2.this,login.class);
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
                }else{//表示已经登录
                    if(zhuangTai.equals(name)==false || name.equals("")){//用户名输入错误，或者用户名为空
                        Toast.makeText(HuoDongAc2.this,"请检查用户名",Toast.LENGTH_SHORT).show();
                    }else if (zhuangTai.equals(name)==true) { //用户名输入正确

                        if (three.equals("0")&&thou.equals("0")) {//该用户领取300红包

                            HongBao hongBao = new HongBao();
                            hongBao.setHong_name(name);
                            hongBao.setHong_three("300");
                            hongBao.setHong_thou("0");
                            hongBao.setHong_nametel(tel);
                            HongBaoDAO activityDAO1 = new HongBaoDAO(HuoDongAc2.this);
                            activityDAO1.update(hongBao);//插入
                            myDialog = new MyDialog(HuoDongAc2.this, R.style.MyDialog);
                            myDialog.setTitle("温馨提示！");
                            myDialog.setMessage("领取成功，请前往“我的”查看");
                            myDialog.setYesOnclickListener("查看", new MyDialog.onYesOnclickListener() {
                                @Override
                                public void onYesOnclick() {
                                    Intent intent = new Intent();
                                    intent.setClass(HuoDongAc2.this, PersonMain.class);
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
                        }else if (three.equals("300")){
                            Toast.makeText(HuoDongAc2.this,"您已领取",Toast.LENGTH_SHORT).show();
                        }else  if (three.equals("0")&&thou.equals("1000")) {//该用户领取300红包

                            HongBao hongBao = new HongBao();
                            hongBao.setHong_name(name);
                            hongBao.setHong_three("300");
                            hongBao.setHong_thou("1000");
                            hongBao.setHong_nametel(tel);
                            HongBaoDAO activityDAO1 = new HongBaoDAO(HuoDongAc2.this);
                            activityDAO1.update(hongBao);//插入
                            myDialog = new MyDialog(HuoDongAc2.this, R.style.MyDialog);
                            myDialog.setTitle("温馨提示！");
                            myDialog.setMessage("领取成功，请前往“我的”查看");
                            myDialog.setYesOnclickListener("查看", new MyDialog.onYesOnclickListener() {
                                @Override
                                public void onYesOnclick() {
                                    Intent intent = new Intent();
                                    intent.setClass(HuoDongAc2.this, PersonMain.class);
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
                        }

                    }//用户名输入正确
                }//用户已经登录

            }
            //
        });
    }
}
