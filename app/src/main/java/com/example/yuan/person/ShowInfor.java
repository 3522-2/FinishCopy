package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuan.Dao.UserDAO;
import com.example.yuan.MainActivity;
import com.example.yuan.R;
import com.example.yuan.modle.User;

public class ShowInfor extends AppCompatActivity {
    private ImageView fanhui;
    private ImageView cir;
    private TextView show_name,show_tel,show_adr,show_are,show_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_infor);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("用户名");
        Log.i("用户名",name1);

        cir = findViewById(R.id.show_Cirimageview);
        show_tel = findViewById(R.id.show_tel);
        show_name = findViewById(R.id.show_name);
        show_adr = findViewById(R.id.show_adr);
        show_are = findViewById(R.id.show_are);
        show_type = findViewById(R.id.show_type);

        /**
         * 返回上一页
         */
        fanhui = (ImageView)findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowInfor.this, PersonMain.class);
                startActivity(intent);
            }
        });
        UserDAO userDAO = new UserDAO(ShowInfor.this);
        User user = userDAO.find(name1);

        show_tel.setText(user.getUser_telephone());
        show_name.setText(user.getUser_name());
        show_adr.setText(user.getUser_adr());
        show_type.setText(user.getUser_houseType());
        show_are.setText(user.getUser_houseArea());
    }
}
