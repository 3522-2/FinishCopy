package com.example.yuan.Budge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

public class XiangBudge extends AppCompatActivity {
private ImageView fanhui;
private TextView p1,pw2,pc2,pw3,pc3,pw4,pc4,pw5,pc5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_budge);
        /**
         * 返回上一个页面
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(XiangBudge.this,ShowBudge.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();//获取传来的intent对象
        String huxing = intent.getStringExtra("户型");
        String fengge = intent.getStringExtra("风格");
        String mianji = intent.getStringExtra("面积");
        SchemeDAO schemeDAO = new SchemeDAO(XiangBudge.this);

        Log.i("户型",huxing);
        Log.i("风格",fengge);
        Log.i("面积",mianji);

        String id1 = String.valueOf(huxing);
        String id2 = String.valueOf(fengge);
        String id3 = String.valueOf(mianji);

        Scheme scheme = schemeDAO.find1(id1,id2,id3);

        p1 = findViewById(R.id.P1);
        pw2 = findViewById(R.id.PW2);
        pc2 =findViewById(R.id.PC2);
        pw3=findViewById(R.id.PW3);
        pc3=findViewById(R.id.PC3);
        pw4=findViewById(R.id.PW4);
        pc4=findViewById(R.id.PC4);
        pw5=findViewById(R.id.PW5);
        pc5=findViewById(R.id.PC5);
        p1.setText(scheme.getScheme_pirceOne());
        pc2.setText(scheme.getScheme_pirceTwoMaterial());
        pw2.setText(scheme.getScheme_pirceTwoWork());
        pc3.setText(scheme.getScheme_pirceThreeMaterial());
        pw3.setText(scheme.getScheme_pirceThreeWork());
        pc4.setText(scheme.getScheme_pirceFourMaterial());
        pw4.setText(scheme.getScheme_pirceFourWork());
        pc5.setText(scheme.getScheme_pirceFiveMaterial());
        pw5.setText(scheme.getScheme_pirceFivework());
    }
}
