package com.example.yuan.person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.MainActivity;
import com.example.yuan.R;

import java.util.ArrayList;
import java.util.List;

public class PersonMain extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView textView;
    private ListView listView;
    private int[] title = new int[]{R.mipmap.person1,R.mipmap.person3,R.mipmap.person4,R.mipmap.person5,R.mipmap.canal};
    private String[] Data = new String[]{"我的装修","更新装修进度","联系我们","设置","注销登录"};
    private int[] imageld = new int[]{R.mipmap.person2,R.mipmap.person2,R.mipmap.person2,R.mipmap.person2,R.mipmap.person2};
    private List<PersonListAdapt.ListItemModel> myListItem;
    private PersonListAdapt adApter;
    private ImageView fanhui,home;
    private Button reg1,canal;
    private ImageView imageView1,imageView2,imageView4;//底部导航栏
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_main);

        textView = (TextView) findViewById(R.id.textView) ;
        SharedPreferences sharedPreferences = this.getSharedPreferences("yonghu", MODE_PRIVATE);
        textView.setText(sharedPreferences.getString("用户名","未登录"));

        reg1 = (Button)findViewById(R.id.reg);
        SharedPreferences sharedPreferences1 = this.getSharedPreferences("yonghu", MODE_PRIVATE);
        reg1.setText(sharedPreferences1.getString("是否登录","点此登录"));


        fanhui = (ImageView)findViewById(R.id.re);
        listView=(ListView)findViewById(R.id.ListView);
        myListItem = new ArrayList<PersonListAdapt.ListItemModel>();
        for(int i=0;i<imageld.length;i++){
            PersonListAdapt.ListItemModel listItemModel = new PersonListAdapt.ListItemModel();
            listItemModel.setTitle(title[i]);
            listItemModel.setData(Data[i]);
            listItemModel.setRid(imageld[i]);
            myListItem.add(listItemModel);
        }
        adApter = new PersonListAdapt(PersonMain.this);
        adApter.setListItems(myListItem);
        listView.setAdapter(adApter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);
                String zhuangTai = sharedPreferences.getString("用户名","");

                if(id == 0) {
                    if(zhuangTai.equals("未登录") || zhuangTai==null){
                        Toast.makeText(PersonMain.this,"请登录后查看",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent();
                        intent.setClass(PersonMain.this,My_ZhuangXiuList.class);
                        startActivity(intent);
                    }

                }
                if(id == 1) {

                    if(zhuangTai.equals("你好，管理员")){
                        Intent intent = new Intent();
                        intent.setClass(PersonMain.this,GengXinJinDu.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(PersonMain.this,"您不是管理员，或者请管理员登录后查看",Toast.LENGTH_SHORT).show();
                    }

                }
                if(id == 2) {
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this,LianXi.class);
                    startActivity(intent);
                }
                if(id == 3) {
                    Toast.makeText(PersonMain.this, "设置" + position, Toast.LENGTH_SHORT).show();
                }
                if(id == 4) {
                   // 1：得到sp对象
                            sp = getSharedPreferences("yonghu", Context.MODE_PRIVATE);
                    //2：得到editor对象
                    SharedPreferences.Editor editor = sp.edit();
                    //3：得到输入的key/vaule
                    String key = "用户名";
                    String value = "未登录";
                    String key3 = "是否登录";
                    String value3 = "点此登录";
                    //4:用editor保存key/vaule
                    editor.putString(key,value).commit();
                    editor.putString(key3,value3).commit();
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this,PersonMain.class);
                    startActivity(intent);
                }
            }
        });
        /**
         * 返回上一页
         */
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonMain.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 进入选择登录页面
         */
        reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonMain.this,login.class);
                startActivityForResult(intent, 777);
            }
        });
        /**
         * 底部导航栏跳转
         */
        //首页
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonMain.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 案例
         */
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 3D
         */
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断请求码和返回码是不是正确的，这两个码都是我们自己设置的
        if (requestCode == 777 && resultCode == 333) {
            String name = data.getStringExtra("name");// 拿到返回过来的输入的账号
            String btn = data.getStringExtra("button");
            // 把得到的数据显示到输入框内
            textView.setText(name);
            reg1.setText(btn);

        }
    }
}
