package com.example.yuan.person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.AdministratorDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.Administrator;

public class guanliyuanLogin extends AppCompatActivity {
    private SharedPreferences sp;
    private ImageView fanhui1;
    private ImageView home;
    private TextView btn1,btn2;
    private EditText regname,regpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanliyuan_login);

        /**
         * 返回上一页
         */
        fanhui1 = (ImageView)findViewById(R.id.re);
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(guanliyuanLogin.this,PersonMain.class);
                startActivity(intent);
            }
        });
        /**
         * 返回首页
         */
        home = (ImageView)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(guanliyuanLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 管理员跳转注册页面
         */
        btn2 = (TextView) findViewById(R.id.reg);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(guanliyuanLogin.this,gaunliyuanReg.class);
                startActivityForResult(intent,777);
            }
        });
        /**
         * 管理员登录
         */
        regname= (EditText)findViewById(R.id.accountEdittext);
        regpwd= (EditText)findViewById(R.id.pwdEdittext);
        btn1 = (TextView) findViewById(R.id.login_in) ;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regName = regname.getText().toString();
                String regPwd = regpwd.getText().toString();
                AdministratorDAO administratorDAO = new AdministratorDAO(guanliyuanLogin.this);
                boolean is= administratorDAO.findPwd(regName,regPwd);

                if (regName == null || "".equals(regName) || regPwd == null || "".equals(regPwd)) {
                    Toast.makeText(guanliyuanLogin.this, "账号与密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(administratorDAO.CheckIsDataAlreadyInDBorNot(regName)==1&&is==false){
                        Toast.makeText(guanliyuanLogin.this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                    if(administratorDAO.CheckIsDataAlreadyInDBorNot(regName)==1&&is==true){

                        Toast.makeText(guanliyuanLogin.this, "登录成功", Toast.LENGTH_SHORT).show();
                        // 1：得到sp对象
                        sp = getSharedPreferences("yonghu", Context.MODE_PRIVATE);
                        //2：得到editor对象
                        SharedPreferences.Editor editor = sp.edit();
                        //3：得到输入的key/vaule
                        String key = "用户名";
                        String value = "你好，管理员";
                        String key3 = "是否登录";
                        String value3 = "已登录";
                        //4:用editor保存key/vaule
                        editor.putString(key,value).commit();
                        editor.putString(key3,value3).commit();
                        Intent intent = new Intent();
                        intent.setClass(guanliyuanLogin.this,gaunliyuanMain.class);
                        startActivity(intent);
                    }else if (administratorDAO.CheckIsDataAlreadyInDBorNot(regName)==-1){

                        /*
                         * 带返回值的跳转方法，参数1：intent意图， 第二个参数请求码，是一个requestCode值，如果有多个按钮都要启动Activity，
                         * 则requestCode标志着每个按钮所启动的Activity
                         */
                        Intent intent =new Intent();
                        intent.setClass(guanliyuanLogin.this,gaunliyuanReg.class);
                        startActivityForResult(intent, 222);
                        Toast.makeText(guanliyuanLogin.this, "该账户不存在,请注册", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断请求码和返回码是不是正确的，这两个码都是我们自己设置的
        if (requestCode == 777 && resultCode == 888) {
            String name = data.getStringExtra("name");// 拿到返回过来的输入的账号
            String pwd = data.getStringExtra("pwd");// 拿到返回过来的输入的账号
            // 把得到的数据显示到输入框内
            regname.setText(name);
            regpwd.setText(pwd);

        }
    }

}
