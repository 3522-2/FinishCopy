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

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

public class AddScheme extends AppCompatActivity {
        private ImageView fanhui;
        private EditText style,area,type,priceOne,priceTwoW,priceTwoC,priceThreeW,priceThreeC,priceFourW,priceFourC,priceFiveW,priceFiveC,priceSum;
        private Button add;
        private Spinner spinnerH,spinnerA,spinnerT;
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
                intent.setClass(AddScheme.this, gaunliyuanMain.class);
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

        spinnerH = (Spinner)findViewById(R.id.spinnerT);
        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                type.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerA = (Spinner)findViewById(R.id.spinnerA);
        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                area.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerT = (Spinner)findViewById(R.id.spinnerF);
        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                style.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        add = (Button)findViewById(R.id.login_in);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 SchemeDAO schemeDAO = new SchemeDAO(AddScheme.this);
                 Scheme scheme = new Scheme();

                 String area1 = area.getText().toString();
                 scheme.setScheme_houseArea(area1);//面积

                String type1 = type.getText().toString();
                scheme.setScheme_houseType(type1);//户型

                String style1 = style.getText().toString();
                scheme.setScheme_houseStyle(style1);//风格

                String priceOne1 = priceOne.getText().toString();
                scheme.setScheme_pirceOne(priceOne1);

                String priceTwoW1 = priceTwoW.getText().toString();
                scheme.setScheme_pirceTwoWork(priceTwoW1);

                String priceTwoC1 = priceTwoC.getText().toString();
                scheme.setScheme_pirceTwoMaterial(priceTwoC1);

                String priceThreeW1 = priceThreeW.getText().toString();
                scheme.setScheme_pirceThreeWork(priceThreeW1);

                String priceThreeC1 = priceThreeC.getText().toString();
                scheme.setScheme_pirceThreeMaterial(priceThreeC1);


                String priceFourW1 = priceFourW.getText().toString();
                scheme.setScheme_pirceFourWork(priceFourW1);

                String priceFourC1 = priceFourC.getText().toString();
                scheme.setScheme_pirceFourMaterial(priceFourC1);

                String priceFiveW1 = priceFiveW.getText().toString();
                scheme.setScheme_pirceFivework(priceFiveW1);

                String priceFiveC1 = priceFiveC.getText().toString();
               scheme.setScheme_pirceFiveMaterial(priceFiveC1);

                String priceSum1 = priceSum.getText().toString();
                scheme.setScheme_pirceSum(priceSum1);
                schemeDAO.add(scheme);

                    Toast.makeText(AddScheme.this, "添加成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(AddScheme.this, AddScheme.class);
                    startActivity(intent);


            }
        });
    }
}
