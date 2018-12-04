package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;

public class ExitXiao extends AppCompatActivity {
    private Button XiuGai,ShanChu;
    private ImageView fanhui;
    private EditText XiaoName,XiaoFeng,XiaoMian,XiaoHu,
            XiaoOne,XiaoTwo,XiaoThree,XiaoFour,XiaoFive,
            XiaoSum,XiaoDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_xiao);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ExitXiao.this, ChangeXiao.class);
                startActivity(intent);
            }
        });
        item();


        final Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
//        Log.i("解析后的id",id);
        final EffectDAO effectDAO = new EffectDAO(ExitXiao.this);
        final Effect effect = effectDAO.find(id);
        XiaoName.setText(effect.getEffect_name());
        XiaoFeng.setText(effect.getEffect_stytle());
        XiaoMian.setText(effect.getEffect_area());
        XiaoHu.setText(effect.getEffect_type());
        XiaoOne.setText(effect.getEffect_PriceOne());
        XiaoTwo.setText(effect.getEffect_PriceTwo());
        XiaoThree.setText(effect.getEffect_PriceThree());
        XiaoFour.setText(effect.getEffect_PriceFour());
        XiaoFive.setText(effect.getEffect_PriceFive());
        XiaoSum.setText(effect.getEffect_PriceSum());
        XiaoDes.setText(effect.getEffect_describe());

        /**
         * 修改
         */
        XiuGai = (Button)findViewById(R.id.xiugai);
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

                String XiaoTwo1  = XiaoTwo.getText().toString();
                effect.setEffect_PriceOne(XiaoTwo1);

                String XiaoTheee1  = XiaoThree.getText().toString();
                effect.setEffect_PriceOne(XiaoTheee1);

                String XiaoFour1  = XiaoFour.getText().toString();
                effect.setEffect_PriceOne(XiaoFour1);

                String XiaoFive1  = XiaoFive.getText().toString();
                effect.setEffect_PriceOne(XiaoFive1);

                String XiaoSum1  = XiaoSum.getText().toString();
                effect.setEffect_PriceOne(XiaoSum1);

                effectDAO.update(effect);

                Intent intent1 = new Intent();
                intent1.setClass(ExitXiao.this ,ChangeXiao.class);
                startActivity(intent1);
                Toast.makeText(ExitXiao.this,"修改成功",Toast.LENGTH_SHORT);
            }
        });

        /**
         * 删除
         */
        ShanChu = (Button)findViewById(R.id.shanchu);
        ShanChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                effectDAO.deleteById(id);
                Intent intent1 = new Intent();

                intent1.setClass(ExitXiao.this ,ChangeXiao.class);
                startActivity(intent1);
                Toast.makeText(ExitXiao.this,"修改成功",Toast.LENGTH_SHORT);
            }
        });
    }

    private void item(){
        XiaoName = (EditText)findViewById(R.id.XiaoName);
        XiaoFeng=(EditText)findViewById(R.id.XiaoFeng);
        XiaoMian=(EditText)findViewById(R.id.XiaoMian);
        XiaoHu=(EditText)findViewById(R.id.XiaoHu);
        XiaoOne=(EditText)findViewById(R.id.XiaoOne);
        XiaoTwo=(EditText)findViewById(R.id.XiaoTwo);
        XiaoThree=(EditText)findViewById(R.id.XiaoThree);
        XiaoFour=(EditText)findViewById(R.id.XiaoFour);
        XiaoFive=(EditText)findViewById(R.id.XiaoFive);
        XiaoSum=(EditText)findViewById(R.id.XiaoSum);
        XiaoDes=(EditText)findViewById(R.id.XiaoDes);
    }
}
