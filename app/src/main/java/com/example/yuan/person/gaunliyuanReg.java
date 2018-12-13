package com.example.yuan.person;

import android.content.Intent;
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

public class gaunliyuanReg extends AppCompatActivity {
    private EditText regName;
    private EditText regPwd, regIsPwd, regTel;
    private TextView button;
    private ImageView fanhui1;
    private ImageView shouye1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaunliyuan_reg);
        /**
         * 返回上一页
         */
        fanhui1 = (ImageView) findViewById(R.id.re);
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanReg.this, login.class);
                startActivity(intent);
            }
        });
        /**
         * 回到主页
         */
        shouye1 = (ImageView) findViewById(R.id.home);
        shouye1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(gaunliyuanReg.this, guanliyuanLogin.class);
                startActivity(intent);
            }
        });
        button = (TextView) findViewById(R.id.login_in) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                regName = (EditText) findViewById(R.id.accountEdittext);//管理员名
                regPwd = (EditText) findViewById(R.id.pwdEdittext);//密码
                regIsPwd = (EditText) findViewById(R.id.ispwdEdittext);//确认密码
                regTel = (EditText) findViewById(R.id.telephone);//电话号码
                String regUsername1 = regName.getText().toString();
                String regPwd1 = regPwd.getText().toString();
                String regIsPwd1 = regIsPwd.getText().toString();
                String regTel1 = regTel.getText().toString();
                Administrator administrator = new Administrator();
                AdministratorDAO administratorDAO = new AdministratorDAO(gaunliyuanReg.this);
                if (administratorDAO.CheckIsDataAlreadyInDBorNot(regUsername1)==1) {
                    Toast.makeText(gaunliyuanReg.this, "该用户名已存在", Toast.LENGTH_SHORT).show();

                } else if (regUsername1.equals("") || regPwd1.equals("") || regIsPwd1.equals("") || regTel1.equals("")) {
                    Toast.makeText(gaunliyuanReg.this, "不能有空值", Toast.LENGTH_SHORT).show();

                } else if (regPwd1.equals(regIsPwd1) == false) {
                    Toast.makeText(gaunliyuanReg.this, "密码与确认密码不一致", Toast.LENGTH_SHORT).show();
                } else {
                    administrator.setAdministrator_name(regUsername1);
                    administrator.setAdministrator_password(regPwd1);
                    administrator.setAdministrator_telephone(regTel1);
                    administratorDAO.add(administrator);
                    Toast.makeText(gaunliyuanReg.this, "注册成功", Toast.LENGTH_SHORT).show();
                    //拿到一个intent把需要返回的值放进去

                    Intent intent = new Intent();
                    intent.putExtra("name", regUsername1);
                    intent.putExtra("pwd", regPwd1);
                    /*
                     * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                     * 参数1：resultCode返回码，跳转之前的activity根据是这个resultCode，区分是哪一个activity返回的
                     * 参数2：数据源
                     */
                    setResult(888, intent);
                    finish();//结束当前activity

                }
            }
        });
    }
}