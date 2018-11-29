package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

public class AddScheme extends AppCompatActivity {
        private ImageView fanhui;
        private EditText style,area,type,priceOne,priceTwoW,priceTwoC,priceThreeW,priceThreeC,priceFourW,priceFourC,priceFiveW,priceFiveC,priceSum;
        private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scheme);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddScheme.this, guanliyuanLogin.class);
                startActivity(intent);
            }
        });
        type=(EditText)findViewById(R.id.accountEdittext);//户型
        area =(EditText)findViewById(R.id.pwdEdittext);//面积
        style =(EditText)findViewById(R.id.ispwdEdittext);//风格
        priceOne=(EditText)findViewById(R.id.telephone);
        priceTwoW=(EditText)findViewById(R.id.adr1);
        priceTwoC=(EditText)findViewById(R.id.HouseStytle1);
        priceThreeW=(EditText)findViewById(R.id.threeP);
        priceThreeC=(EditText)findViewById(R.id.threeC);
        priceFourW=(EditText)findViewById(R.id.threeP1);
        priceFourC=(EditText)findViewById(R.id.FoureP1);
        priceFiveW=(EditText)findViewById(R.id.FourePm);
        priceFiveC=(EditText)findViewById(R.id.FineP);
        priceSum = (EditText)findViewById(R.id.Sum);
        final SchemeDAO schemeDAO = new SchemeDAO(AddScheme.this);
        final Scheme scheme = new Scheme();

        add = (Button)findViewById(R.id.login_in);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String style1=style.getText().toString();
                String area1 = area.getText().toString();
                String type1 = type.getText().toString();
                String priceOne1 = priceOne.getText().toString();
                String priceTwoW1=priceTwoW.getText().toString();
                String priceTwoC1=priceTwoC.getText().toString();
                String priceThreeW1=priceThreeW.getText().toString();
                String priceThreeC1=priceThreeC.getText().toString();
                String priceFourW1=priceFourW.getText().toString();
                String priceFourC1=priceFourC.getText().toString();
                String priceFiveW1=priceFiveW.getText().toString();
                String priceFiveC1=priceFiveC.getText().toString();
                String priceSum1 =priceSum.getText().toString();
                scheme.setScheme_houseStyle(style1);
                scheme.setScheme_houseArea(area1);
                scheme.setScheme_houseType(type1);
                scheme.setScheme_pirceOne(priceOne1);
                scheme.setScheme_pirceTwoWork(priceTwoW1);
                scheme.setScheme_pirceTwoMaterial(priceTwoC1);
                scheme.setScheme_pirceThreeWork(priceThreeW1);
                scheme.setScheme_pirceThreeMaterial(priceThreeC1);
                scheme.setScheme_pirceFourWork(priceFourW1);
                scheme.setScheme_pirceFourMaterial(priceFourC1);
                scheme.setScheme_pirceFivework(priceFiveW1);
                scheme.setScheme_pirceFiveMaterial(priceFiveC1);
                scheme.setScheme_pirceSum(priceSum1);
                schemeDAO.add(scheme);
                if(style1==null || ("").equals(style1) || area1==null || area1.equals(area1)||type1==null||("").equals(type1)){
                    Toast.makeText(AddScheme.this,"请检查前三栏是否为空",Toast.LENGTH_SHORT).show();
                }
               Toast.makeText(AddScheme.this,"添加成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(AddScheme.this,AddScheme.class);
                startActivity(intent);

            }
        });
    }
}
