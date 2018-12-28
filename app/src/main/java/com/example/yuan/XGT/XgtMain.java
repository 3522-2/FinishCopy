package com.example.yuan.XGT;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;
import com.example.yuan.person.MyDialogPerson;


import java.util.ArrayList;
import java.util.List;


public class XgtMain extends AppCompatActivity {
    private Spinner spinner1,spinner2,spinner3;
    private TextView F,M,H;
    private ImageView fanhui,search;
    private String[] imagel=new String[1000] ;
    private String[] Data=new String[1000];
    private String[] imager=new String[1000];

    private List<XGTAdapt.ListItemModel> myListItem;
    private XGTAdapt adApter;
    private ListView listView;

    private MyDialogPerson myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgt_main);


        /**
         * 返回上一个页面
         */

        fanhui = (ImageView) findViewById(R.id.return1);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(XgtMain.this, MainActivity.class);
                startActivity(intent);
            }
        });


        listView = (ListView) findViewById(R.id.ListView1);

        final EffectDAO effectDAO = new EffectDAO(XgtMain.this);
        // 获取所有收入信息，并存储到List泛型集合中
        List<Effect> listinfos = effectDAO.getScrollData(0,
                (int) effectDAO.getCount());
        int m = 0;// 定义一个开始标识

        for (Effect effect : listinfos) {// 遍历List泛型集合
            // 将收入相关信息组合成一个字符串，存储数组的相应位置
            Data[m] = effect.getEffect_name();
            imagel[m] = effect.getEffect_keting();
            imager[m] = effect.getEffect_woshi();
            Log.i("m的值", String.valueOf(m));
            m++;// 标识加1
        }
        myListItem = new ArrayList<XGTAdapt.ListItemModel>();
        for(int i = 0;i<m;i++){
            Log.i("Data[m]的值", Data[i]);
            Log.i(" imagel[m]的值",  imagel[i]);
            Log.i("imager[m]的值", imager[i]);
            XGTAdapt.ListItemModel listItemModel = new XGTAdapt.ListItemModel();
            listItemModel.setImagel( imagel[i]);
            listItemModel.setTitle(Data[i]);
            listItemModel.setImager(imager[i]);
            myListItem.add(listItemModel);
        }
        adApter = new XGTAdapt(XgtMain.this);
        adApter.setListItems(myListItem);
        listView.setAdapter(adApter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(XgtMain.this,"点击的值"+position,Toast.LENGTH_SHORT).show();
                String i = String.valueOf(position + 1);
              Intent intent = new Intent();
              intent.setClass(XgtMain.this,ShowXGT.class);
              intent.putExtra("id",i);
              startActivity(intent);
            }
        });
        F=findViewById(R.id.F);
        spinner1 = (Spinner)findViewById(R.id.style1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              String resule = parent.getItemAtPosition(position).toString();
              F.setText(resule);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        H=findViewById(R.id.H);
        spinner2 = (Spinner)findViewById(R.id.housetype);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                H.setText(resule);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        M=findViewById(R.id.M);

        spinner3 = (Spinner)findViewById(R.id.area);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resule = parent.getItemAtPosition(position).toString();
                M.setText(resule);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /**
         * 搜索
         */
        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fengge = F.getText().toString().trim();//风格
                String huxing = H.getText().toString().trim();//户型
                String mianji = M.getText().toString().trim();//面积

                EffectDAO effectDAO1 = new EffectDAO(XgtMain.this);
                boolean is = effectDAO1.check(fengge,huxing,mianji);
                Log.i("是否存在",String.valueOf(effectDAO1.check(fengge,huxing,mianji)));
                if(is==false){
                    myDialog=new MyDialogPerson(XgtMain.this,R.style.MyDialog);
                    myDialog.setMessage("没有查询结果");
                    myDialog.setYesOnclickListener("确定", new MyDialogPerson.onYesOnclickListener() {
                        @Override
                        public void onYesOnclick() {
                            myDialog.dismiss();
                        }
                    });
                    myDialog.show();
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("F",fengge);
                    intent.putExtra("H",huxing);
                    intent.putExtra("M",mianji);
                    intent.setClass(XgtMain.this,XGTSou.class);
                    startActivity(intent);
                }

            }
        });
    }

}
