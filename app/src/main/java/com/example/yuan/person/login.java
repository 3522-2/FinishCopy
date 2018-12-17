package com.example.yuan.person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.UserDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.dialog.loginDia;
import com.example.yuan.modle.User;

public class login extends AppCompatActivity {

    private ImageView fanhui1;
    private ImageView home;
    private TextView login;
    private  EditText username;
    private EditText userpwd;
    private SharedPreferences sp;
    private RelativeLayout relativeLayout;
    private loginDia myDialog;
    private TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

/**
 * 长按
 */
        relativeLayout=(RelativeLayout)findViewById(R.id.LongTouch) ;
        relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                myDialog=new loginDia(login.this,R.style.MyDialog);

                myDialog.setYesOnclickListener("管理员登录", new loginDia.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        Intent intent = new Intent();
                        intent.setClass(login.this,guanliyuanLogin.class);
                        startActivity(intent);
                        finish();
                        myDialog.dismiss();
                    }
                });

                myDialog.show();
                         /**
                                  * 点击消息是否进行拦截？
                                  * 如果是true   不会触发后续事件
                                  * 如果是false  会触发后续事件 比如说单击事件
                                  */
                         return true;

            }
        });

        /**
         * 新用户注册
         */
        reg = (TextView)findViewById(R.id.login_in1);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(login.this,regist.class);
                startActivity(intent);
                finish();
            }
        });
        /**
         * 返回上一页
         */
        fanhui1 = (ImageView)findViewById(R.id.re);
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(login.this,PersonMain.class);
                startActivity(intent);
                finish();
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
                intent.setClass(login.this, MainActivity.class);
                startActivityForResult(intent,222);
                finish();
            }
        });
        username= (EditText)findViewById(R.id.accountEdittext);
        userpwd= (EditText)findViewById(R.id.pwdEdittext);

/**
 * 登录
 */
        login = (TextView) findViewById(R.id.login_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regName = username.getText().toString().trim();
                String regPwd = userpwd.getText().toString().trim();
                UserDAO userDAO = new UserDAO(login.this);
                boolean is= userDAO.findPwd(regName,regPwd);

                if (regName == null || "".equals(regName) || regPwd == null || "".equals(regPwd)) {
                    Toast.makeText(login.this, "账号与密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(userDAO.CheckIsDataAlreadyInDBorNot(regName)==1&&is==false){
                        Toast.makeText(login.this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                    if(userDAO.CheckIsDataAlreadyInDBorNot(regName)==1&&is==true){

                        Toast.makeText(login.this, "登录成功", Toast.LENGTH_SHORT).show();
                        // 1：得到sp对象
                        sp = getSharedPreferences("yonghu", Context.MODE_PRIVATE);
                        //2：得到editor对象
                        SharedPreferences.Editor editor = sp.edit();
                        //3：得到输入的key/vaule
                        String key = "用户名";
                        String value = regName;
                        String key3 = "是否登录";
                        String value3 = "已登录";
                        //4:用editor保存key/vaule
                        editor.putString(key,value).commit();
                        editor.putString(key3,value3).commit();
                        Intent intent = new Intent();
                        intent.setClass(login.this,PersonMain.class);
                        startActivity(intent);
                        finish();
                    }else if (userDAO.CheckIsDataAlreadyInDBorNot(regName)==-1){

                        /*
                         * 带返回值的跳转方法，参数1：intent意图， 第二个参数请求码，是一个requestCode值，如果有多个按钮都要启动Activity，
                         * 则requestCode标志着每个按钮所启动的Activity
                         */
                        Intent intent =new Intent();
                        intent.setClass(login.this,regist.class);
                        startActivityForResult(intent, 222);
                        Toast.makeText(login.this, "该账户不存在,请注册", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断请求码和返回码是不是正确的，这两个码都是我们自己设置的
        if (requestCode == 222 && resultCode == 111) {
            String name = data.getStringExtra("name");// 拿到返回过来的输入的账号
            String pwd = data.getStringExtra("pwd");// 拿到返回过来的输入的账号
            // 把得到的数据显示到输入框内
            username.setText(name);
            userpwd.setText(pwd);

        }
    }
}
