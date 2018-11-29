package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yuan.Dao.UserDAO;
import com.example.yuan.MainActivity;

import com.example.yuan.modle.User;
import com.example.yuan.R;
public class regist extends AppCompatActivity {

    private EditText regUsername;
    private  EditText regPwd,regIsPwd,regTel,regAdr,regAer,regStyle;
    private ImageView fanhui1;
    private ImageView shouye1;

    private Button reg;
    private String stytle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        /**
         * 返回上一页
         */
        fanhui1 = (ImageView)findViewById(R.id.re);
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(regist.this,login.class);
                startActivity(intent);
            }
        });
        /**
         * 回到主页
         */
        shouye1 = (ImageView)findViewById(R.id.home);
        shouye1.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(regist.this,MainActivity.class);
                startActivity(intent);
            }
        });


        reg = (Button)findViewById(R.id.login_in) ;
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regStyle = (EditText)findViewById(R.id.HouseStytle1);//户型
                regUsername = (EditText)findViewById(R.id.accountEdittext) ;//用户名
                regPwd = (EditText)findViewById(R.id.pwdEdittext) ;//密码
                regIsPwd= (EditText)findViewById(R.id.ispwdEdittext) ;//确认密码
                regTel= (EditText)findViewById(R.id.telephone) ;//电话号码
                regAdr= (EditText)findViewById(R.id.adr1) ;//地址
                regAer= (EditText)findViewById(R.id.are1) ;//面积
                String regUsername1 = regUsername.getText().toString();
                String regPwd1 = regPwd.getText().toString();
                String regIsPwd1 = regIsPwd.getText().toString();
                String regTel1 = regTel.getText().toString();
                String regAdr1 = regAdr.getText().toString();
                String regStyle1 = regStyle.getText().toString();
                String regAer1 = regAer.getText().toString();
                UserDAO userDAO = new UserDAO(regist.this);
                User user = new User();
                if(userDAO.CheckIsDataAlreadyInDBorNot(regUsername1)==1){
                    Toast.makeText(regist.this,"该用户名已存在",Toast.LENGTH_SHORT).show();

                }else if(regUsername1.equals("") || regPwd1.equals("") || regIsPwd1.equals("") || regTel1.equals("")||regAdr1.equals("")||regAer1.equals("")){
                    Toast.makeText(regist.this,"不能有空值",Toast.LENGTH_SHORT).show();

                }else if(regPwd1.equals(regIsPwd1)==false){
                    Toast.makeText(regist.this,"密码与确认密码不一致",Toast.LENGTH_SHORT).show();
                }else {
                    user.setUser_name(regUsername1);
                    user.setUser_password(regPwd1);
                    user.setUser_telephone(regTel1);
                    user.setUser_adr(regAdr1);
                    user.setUser_houseType(regStyle1);
                    user.setUser_houseArea(regAer1);
                    userDAO.add(user);
                    Toast.makeText(regist.this,"注册成功",Toast.LENGTH_SHORT).show();
                    //拿到一个intent把需要返回的值放进去

                    Intent intent = new Intent();
                    intent.putExtra("name", regUsername1);
                    intent.putExtra("pwd", regPwd1);
                    /*
                     * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                     * 参数1：resultCode返回码，跳转之前的activity根据是这个resultCode，区分是哪一个activity返回的
                     * 参数2：数据源
                     */
                    setResult(111, intent);
                    finish();//结束当前activity

                }
            }
        });

    }



}
