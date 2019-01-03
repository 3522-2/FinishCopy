package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

public class EditScheme extends AppCompatActivity {
    private ImageView fanhui;
    private EditText style,area,type,priceOne,priceTwoW,priceTwoC,priceThreeW,priceThreeC,priceFourW,priceFourC,priceFiveW,priceFiveC;
    private TextView priceSum;
    private Button xiugai,shanchu;
//    private Spinner spinnerH,spinnerA,spinnerT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_scheme);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditScheme.this, ChangeSchem.class);
                startActivity(intent);
                finish();
            }
        });

        getItem();

        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
//        Log.i("解析后的id",id);
        SchemeDAO schemeDAO = new SchemeDAO(EditScheme.this);
        final Scheme scheme =schemeDAO.find(id);
//        Log.i("面积",scheme.getScheme_houseArea());
        type.setText(scheme.getScheme_houseType());
        area.setText(scheme.getScheme_houseArea());
        style.setText(scheme.getScheme_houseStyle());
        priceOne.setText(scheme.getScheme_pirceOne());
        priceTwoW.setText(scheme.getScheme_pirceTwoWork());
        priceTwoC.setText(scheme.getScheme_pirceTwoMaterial());
        priceThreeW.setText(scheme.getScheme_pirceThreeWork());
        priceThreeC.setText(scheme.getScheme_pirceThreeMaterial());
        priceFourW.setText(scheme.getScheme_pirceFourWork());
        priceFourC.setText(scheme.getScheme_pirceFourMaterial());
        priceFiveW.setText(scheme.getScheme_pirceFivework());
        priceFiveC.setText(scheme.getScheme_pirceFiveMaterial());
        priceSum.setText(scheme.getScheme_pirceSum());

//        spinnerH = (Spinner)findViewById(R.id.spinnerT);
//        spinnerH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                type.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerA = (Spinner)findViewById(R.id.spinnerA);
//        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                area.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerT = (Spinner)findViewById(R.id.spinnerF);
//        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String resule = parent.getItemAtPosition(position).toString();
//                style.setText(resule);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        /**
         * 修改
         */
        final SchemeDAO schemeDAO1 = new SchemeDAO(EditScheme.this);
        xiugai = (Button)findViewById(R.id.xiugai);
        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem();

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
                schemeDAO1.update(scheme);
                Toast.makeText(EditScheme.this, "修改成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditScheme.this,ChangeSchem.class);
                startActivity(intent1);
                finish();
            }
        });
        /**
         * 删除
         */
        shanchu = (Button)findViewById(R.id.shanchu);
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            schemeDAO1.deleteById(id);
                Toast.makeText(EditScheme.this, "删除成功", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent();
            intent1.setClass(EditScheme.this,ChangeSchem.class);
            startActivity(intent1);
            finish();

            }
        });
    }

    private void getItem() {

        type = (EditText) findViewById(R.id.accountEdittext);//户型
        area = (EditText) findViewById(R.id.pwdEdittext);//面积
        style = (EditText) findViewById(R.id.ispwdEdittext);//风格
        priceOne = (EditText) findViewById(R.id.telephone);
        priceTwoW = (EditText) findViewById(R.id.adr1);
        priceTwoC = (EditText) findViewById(R.id.HouseStytle1);
        priceThreeW = (EditText) findViewById(R.id.threeP);
        priceThreeC = (EditText) findViewById(R.id.threeC);
        priceFourW = (EditText) findViewById(R.id.threeP1);
        priceFourC = (EditText) findViewById(R.id.FoureP1);
        priceFiveW = (EditText) findViewById(R.id.FourePm);
        priceFiveC = (EditText) findViewById(R.id.FineP);
        priceSum = (TextView) findViewById(R.id.Sum);
    }

}
