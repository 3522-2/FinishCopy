package com.example.yuan.Budge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

public class ShowBudge extends AppCompatActivity {
private ImageView fanhui;
private TextView HuXing,FengGe,Main;
private Spinner spinner1,spinner2,spinner3;
private LinearLayout Get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_budge);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowBudge.this,MainActivity.class);
                startActivity(intent);
            }
        });

        HuXing = (TextView) findViewById(R.id.huxing);
        spinner1 = (Spinner)findViewById(R.id.spinnerT);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                HuXing.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        FengGe = (TextView) findViewById(R.id.fengge);
        spinner2 = (Spinner)findViewById(R.id.spinnerS);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                FengGe.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Main = (TextView) findViewById(R.id.mian);
        spinner3 = (Spinner)findViewById(R.id.spinnerA);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                Main.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Scheme scheme = new Scheme();
//        SchemeDAO schemeDAO = new SchemeDAO(ShowBudge.this);
        Get = (LinearLayout) findViewById(R.id.Get);
        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String huxing = HuXing.getText().toString();
                scheme.setScheme_houseType(huxing);

                String fengge = FengGe.getText().toString();
                scheme.setScheme_houseType(fengge);

                String mianji = Main.getText().toString();
                scheme.setScheme_houseArea(mianji);

                Toast.makeText(ShowBudge.this,"登录后查看",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
