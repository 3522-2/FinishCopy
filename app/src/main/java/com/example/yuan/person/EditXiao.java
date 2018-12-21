package com.example.yuan.person;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.Effect;

public class EditXiao extends AppCompatActivity {
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    private Button XiuGai, ShanChu;
    private ImageView fanhui;
    private EditText XiaoName, XiaoFeng, XiaoMian, XiaoHu,
            XiaoOne, XiaoTwo, XiaoThree, XiaoFour, XiaoFive,
            ketingT, woshiT, shufangT, cantingT, weishengjianT, qitaT;
    private String item;
    private ImageView keting1, woshi1, shufang1, canting1, weishengjian1, qita1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_xiao);

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.return1);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditXiao.this, ChangeXiao.class);
                startActivity(intent);
                finish();
            }
        });
        item();
        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        final EffectDAO effectDAO = new EffectDAO(EditXiao.this);
        final Effect effect = effectDAO.find(id);
        final String name = effect.getEffect_name();

        XiaoName.setText(effect.getEffect_name());
        XiaoFeng.setText(effect.getEffect_stytle());
        XiaoMian.setText(effect.getEffect_area());
        XiaoHu.setText(effect.getEffect_type());
        XiaoOne.setText(effect.getEffect_PriceOne());
        XiaoTwo.setText(effect.getEffect_PriceTwo());
        XiaoThree.setText(effect.getEffect_PriceThree());
        XiaoFour.setText(effect.getEffect_PriceFour());
        XiaoFive.setText(effect.getEffect_PriceFive());
        ketingT.setText(effect.getEffect_ketingDes());
        woshiT.setText(effect.getEffect_woshiDes());
        shufangT.setText(effect.getEffect_shufangDes());
        cantingT.setText(effect.getEffect_cantingDes());
        weishengjianT.setText(effect.getEffect_weishengjianDes());
        qitaT.setText(effect.getEffect_qitaDes());
        ;

        keting1 = (ImageView) findViewById(R.id.keting1);
        String filePath = effect.getEffect_keting();
        Log.i("keting1的路径", filePath);
        Bitmap bm = BitmapFactory.decodeFile(filePath);
        keting1.setImageBitmap(bm);

        woshi1 = (ImageView) findViewById(R.id.woshi1);
        String filePath1 = effect.getEffect_woshi();
        Bitmap bm1 = BitmapFactory.decodeFile(filePath1);
        woshi1.setImageBitmap(bm1);

        shufang1 = (ImageView) findViewById(R.id.shufang1);
        String filePath2 = effect.getEffect_shufang();
        Bitmap bm2 = BitmapFactory.decodeFile(filePath2);
        shufang1.setImageBitmap(bm2);

        canting1 = (ImageView) findViewById(R.id.canting1);
        String filePath3 = effect.getEffect_canting();
        Bitmap bm3 = BitmapFactory.decodeFile(filePath3);
        canting1.setImageBitmap(bm3);

        weishengjian1 = (ImageView) findViewById(R.id.weishengjian1);
        String filePath4 = effect.getEffect_weishengjian();
        Bitmap bm4 = BitmapFactory.decodeFile(filePath4);
        weishengjian1.setImageBitmap(bm4);

        qita1 = (ImageView) findViewById(R.id.qita1);
        String filePath5 = effect.getEffect_qita();
        Bitmap bm5 = BitmapFactory.decodeFile(filePath5);
        qita1.setImageBitmap(bm5);

        /**
         * 客厅
         */

        keting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "客厅";
                Log.i("点击事件中的的name", name);
                setImage(name);
            }
        });

        /**
         * 卧室
         */
        woshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "卧室";
                setImage(name);
            }
        });
        /**
         * 书房
         */

        shufang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "书房";
                setImage(name);
            }
        });
        /**
         * 餐厅
         */

        canting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "餐厅";
                setImage(name);
            }
        });
        /**
         * 卫生间
         */

        weishengjian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "卫生间";
                setImage(name);
            }
        });
        /**
         * 其他
         */

        qita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = "其他";
                setImage(name);
            }
        });

        /**
         * 修改
         */
        XiuGai = (Button) findViewById(R.id.xiugai1);
        XiuGai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item();
                String XiaoName1 = XiaoName.getText().toString();
                effect.setEffect_name(XiaoName1);

                String XiaoFeng1 = XiaoFeng.getText().toString();
                effect.setEffect_stytle(XiaoFeng1);

                String XiaoArea1 = XiaoMian.getText().toString();
                effect.setEffect_area(XiaoArea1);

                String XiaoHu1 = XiaoHu.getText().toString();
                effect.setEffect_type(XiaoHu1);

                String XiaoOne1 = XiaoOne.getText().toString();
                effect.setEffect_PriceOne(XiaoOne1);

                String XiaoTwo1 = XiaoTwo.getText().toString();
                effect.setEffect_PriceTwo(XiaoTwo1);

                String XiaoTheee1 = XiaoThree.getText().toString();
                effect.setEffect_PriceThree(XiaoTheee1);

                String XiaoFour1 = XiaoFour.getText().toString();
                effect.setEffect_PriceFour(XiaoFour1);

                String XiaoFive1 = XiaoFive.getText().toString();
                effect.setEffect_PriceFive(XiaoFive1);


                float XiaoSum1 =Float.parseFloat(XiaoOne1)+Float.parseFloat(XiaoTwo1)+Float.parseFloat(XiaoTheee1)
                        +Float.parseFloat(XiaoFour1)+Float.parseFloat(XiaoFive1);
                String XiaoSum2 = String.valueOf(XiaoSum1);
                Log.i("XiaoSum",XiaoSum2);
                effect.setEffect_PriceSum(XiaoSum2);

                effectDAO.update(effect);

                Toast.makeText(EditXiao.this, "修改成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditXiao.this, ChangeXiao.class);
                startActivity(intent1);
                finish();

            }
        });

        /**
         * 删除
         */
        ShanChu = (Button) findViewById(R.id.shanchu1);
        ShanChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                effectDAO.deleteById(id);
                Toast.makeText(EditXiao.this, "删除成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.setClass(EditXiao.this, ChangeXiao.class);
                startActivity(intent1);
                finish();

            }
        });
    }
    private void item(){
        XiaoName = (EditText)findViewById(R.id.name1);
        XiaoFeng=(EditText)findViewById(R.id.fengge1);
        XiaoMian=(EditText)findViewById(R.id.mainji1);
        XiaoHu=(EditText)findViewById(R.id.huxing1);
        XiaoOne=(EditText)findViewById(R.id.one);
        XiaoTwo=(EditText)findViewById(R.id.two);
        XiaoThree=(EditText)findViewById(R.id.three);
        XiaoFour=(EditText)findViewById(R.id.four);
        XiaoFive=(EditText)findViewById(R.id.five);
        ketingT = (EditText)findViewById(R.id.ketingT1);
        woshiT = (EditText)findViewById(R.id.woshiT1);
        shufangT = (EditText)findViewById(R.id.shufangT1);
        cantingT = (EditText)findViewById(R.id.cantingT1);
        weishengjianT = (EditText)findViewById(R.id.weishengjianT1);
        qitaT = (EditText)findViewById(R.id.qitaT1);

    }
    private void setImage(String name) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        intent.putExtra("biao",name);
        startActivityForResult(intent, IMAGE_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Effect effect = new Effect();
        EffectDAO effectDAO = new EffectDAO(EditXiao.this);
        if (requestCode == IMAGE_CODE) {
            Log.i("item的值", item);
            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            Effect effect1 = effectDAO.find(id);
            String name = effect1.getEffect_name();
            if (item == "客厅") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, keting1);
//                Log.i("path的值",path);
                effect.setEffect_keting(path);
                Intent intent1 = getIntent();

                Log.i("解析后的name", name);
                effectDAO.addKeting(effect, name);

            }
            if (item == "书房") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, shufang1);
                Log.i("path的值", path);
                effect.setEffect_shufang(path);
                Intent intent1 = getIntent();
//                Log.i("解析后的name",name);
                effectDAO.addshufang(effect, name);

            }
            if (item == "卧室") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, woshi1);
                Log.i("path的值", path);
                effect.setEffect_woshi(path);
                Intent intent1 = getIntent();
//                Log.i("解析后的name",name);
                effectDAO.addwoshi(effect, name);

            }
            if (item == "餐厅") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, canting1);
                Log.i("path的值", path);
                effect.setEffect_canting(path);
                Intent intent1 = getIntent();

//                Log.i("解析后的name",name);
                effectDAO.addcanting(effect, name);

            }
            if (item == "卫生间") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, weishengjian1);
                Log.i("path的值", path);
                effect.setEffect_weishengjian(path);
                Intent intent1 = getIntent();

//                Log.i("解析后的name",name);
                effectDAO.addweishengjian(effect, name);

            }
            if (item == "其他") {
                XiangCeSave xiangCeSave = new XiangCeSave(EditXiao.this);
                String path = xiangCeSave.save(data, qita1);
                Log.i("path的值", path);
                effect.setEffect_qita(path);
                Intent intent1 = getIntent();

//                Log.i("解析后的name",name);
                effectDAO.addqita(effect, name);

            }


//            XiangCeSave xiangCeSave = new XiangCeSave(AddXiao.this);
//           String  path = xiangCeSave.save(data,keting);
//            Log.i("path的值",path);
        }


    }
}
