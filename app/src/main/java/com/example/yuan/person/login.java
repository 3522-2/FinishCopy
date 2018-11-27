package com.example.yuan.person;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Dao.UserDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.User;

public class login extends AppCompatActivity {

    private ImageView fanhui1;
    private ImageView home;
    private Button login,login1;
    private  EditText username;
    private EditText userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


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
                startActivity(intent);
            }
        });
        username= (EditText)findViewById(R.id.accountEdittext);
        userpwd= (EditText)findViewById(R.id.pwdEdittext);


        login = (Button)findViewById(R.id.login_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString();
                String pwd = userpwd.getText().toString();
                UserDAO userDAO = new UserDAO(login.this);
                User user = new User();

                if (name == null || "".equals(name) || pwd == null || "".equals(pwd)){
                    Toast.makeText(login.this, "账号与密码不能为空", Toast.LENGTH_SHORT).show();
                }else{if(name != null && pwd != null && userDAO.CheckIsDataAlreadyInDBorNot(name)){
                    Toast.makeText(login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //拿到一个intent把需要返回的值放进去
                    Intent intent = new Intent();

                    intent.putExtra("name", "你好："+ name);
                    intent.putExtra("button","已登录");
                    /*
                     * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                     * 参数1：resultCode返回码，跳转之前的activity根据是这个resultCode，区分是哪一个activity返回的
                     * 参数2：数据源
                     */

                    setResult(333, intent);
                    finish();//结束当前activityint
                }else{

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
        login1 = (Button)findViewById(R.id.login_in1);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(login.this,regist.class);
                startActivityForResult(intent, 222);

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