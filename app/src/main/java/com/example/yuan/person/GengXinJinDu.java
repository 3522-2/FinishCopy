package com.example.yuan.person;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.ProjectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Project;


import java.util.Calendar;

public class GengXinJinDu extends AppCompatActivity {
    private ImageView fanhui;
    private Spinner spinner;
    private EditText jieduan,fuze,startET ,finishET;
    private ImageView StartTime,FinishTime;
    private final static int DATE_DIALOG = 0;
    private final static int DATE_DIALOG1 = 1;
    private Button tianJia,Jiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fuze = (EditText)findViewById(R.id.people) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geng_xin_jin_du);

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GengXinJinDu.this, PersonMain.class);
                startActivity(intent);
            }
        });

        //---------------检测字数--------------------------------------------------
        final int maxNum = 500;
        final TextView leftNum = (TextView) findViewById(R.id.leftnum);
        final EditText ed = (EditText) findViewById(R.id.jindu);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                leftNum.setText("剩余字数：" + (maxNum - s.length()));
            }
        });
        //----------------------------------------------------------------------------
        //-------------------------下拉框选择阶段----------------------------------------
        jieduan = (EditText) findViewById(R.id.jieduan);
        spinner = (Spinner)findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                jieduan.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //----------------------下来框选择阶段-------------------------------------------

        //----------------------选择项目开始的时间--------------------------------------
        StartTime=(ImageView)findViewById(R.id.StartTime);
        startET = (EditText) findViewById(R.id.StartET);
        StartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            }
        });
        //------------------------选择项目开始的时间----------------------------------

        //----------------------选择项目结束的时间--------------------------------------
        FinishTime = (ImageView) findViewById(R.id.FinishTime);
        finishET = (EditText) findViewById(R.id.FinishET);
        FinishTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG1);
            }
        });
        //------------------------选择项目结束的时间----------------------------------
/**
 * 提交评价
 */
        tianJia = (Button)findViewById(R.id.button);
        tianJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Project project = new Project();

                EditText jieduan1 = (EditText)findViewById(R.id.jieduan) ;
                String jieduan2 = jieduan1.getText().toString();
                project.setProject_Name(jieduan2);

                EditText fuZe1 = (EditText)findViewById(R.id.people) ;
                String fuZe2 =fuZe1.getText().toString();
                project.setProject_principle(fuZe2);

                EditText sTime = (EditText)findViewById(R.id.StartET);
                String sTime1 = sTime.getText().toString();
                project.setProject_StartTime(sTime1);

                EditText fTime = (EditText)findViewById(R.id.FinishET);
                String fTime1 = fTime.getText().toString();
                project.setProject_FinishTime(fTime1);

                EditText Des = (EditText)findViewById(R.id.jindu);
                String Des1 = Des.getText().toString();
                project.setProject_Des(Des1);

                ProjectDAO projectDAO = new ProjectDAO(GengXinJinDu.this);
                projectDAO.add(project);

                Toast.makeText(GengXinJinDu.this,"提交成功",Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 交流
         */
        Jiao = (Button)findViewById(R.id.button2);
        Jiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GengXinJinDu.this,JiaoLiu.class);
                startActivity(intent);
            }
        });
    }
    //-----------------------------------设置对话框----------------------------------------
    Calendar c = null;

    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch (id) {
            case DATE_DIALOG:
                c = Calendar.getInstance();
                dialog = new DatePickerDialog(
                        this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {
                                startET.setText( year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                            }
                        },
                        c.get(Calendar.YEAR), // 传入年份
                        c.get(Calendar.MONTH), // 传入月份
                        c.get(Calendar.DAY_OF_MONTH) // 传入天数
                );
                break;
            case DATE_DIALOG1:
                c = Calendar.getInstance();
                dialog = new DatePickerDialog(
                        this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {
                                finishET.setText( year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                            }
                        },
                        c.get(Calendar.YEAR), // 传入年份
                        c.get(Calendar.MONTH), // 传入月份
                        c.get(Calendar.DAY_OF_MONTH) // 传入天数
                );
                break;
        }
        return dialog;
    }
    //-----------------------------------设置对话框----------------------------------------
}

