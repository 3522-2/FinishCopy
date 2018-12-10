package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.ProjectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Project;

public class Show_ZhuangXiu extends AppCompatActivity {

    private  ImageView fanhui;
    private TextView jieduan,people,StartET,FinishET,Jindu;
    private EditText pinJia;
    private Button TiJiao,JiaoLiu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_zhuang_xiu);

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Show_ZhuangXiu.this, PersonMain.class);
                startActivity(intent);
            }
        });
        final Intent intent = getIntent();
        final String name = intent.getStringExtra("id");
     //  Log.i("解析后的id",name);

        item();
        final ProjectDAO projectDAO = new ProjectDAO(Show_ZhuangXiu.this);
        final Project project = projectDAO.find(name);
     //   Log.i("负责人描述：",project.getProject_Des());

        jieduan.setText(project.getProject_Name());
        people.setText(project.getProject_principle());
        StartET.setText(project.getProject_StartTime());
        FinishET.setText(project.getProject_FinishTime());
        Jindu.setText( "负责人描述："+ project.getProject_Des());

//提交用户评价
        TiJiao = (Button)findViewById(R.id.button1);
        pinJia = (EditText)findViewById(R.id.pin);
        TiJiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UserPin = pinJia.getText().toString();
                String id = project.getProject_id();
                project.setProject_UserEvaluation(UserPin);

                project.setProject_UserAcceptance("验收");
                projectDAO.Insert(project,id);
                Toast.makeText(Show_ZhuangXiu.this,"确定验收",Toast.LENGTH_SHORT).show();
            }
        });
        //交流
        JiaoLiu = (Button)findViewById(R.id.button2);
        JiaoLiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(Show_ZhuangXiu.this,User_JiaoLiu.class);
                startActivity(intent1);
            }
        });


    }

    private void item() {
        jieduan = (TextView) findViewById(R.id.jieduan);
        people = (TextView)findViewById(R.id.people);
        StartET = (TextView)findViewById(R.id.StartET);
        FinishET = (TextView)findViewById(R.id.FinishET);
        Jindu = (TextView)findViewById(R.id.jindu);
    }
}
