package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.R;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

public class cl extends Activity implements View.OnClickListener {

    private CommonTitleBar titleBar;
    private TextView frame_first;
    private TextView frame_second;
    private TextView frame_third;
    private TextView frame_fourth;
    private int columnWidth;
  //  private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl);
       // lv = findViewById(R.id.lv);
        titleBar = findViewById(R.id.title);
        frame_first = findViewById(R.id.qwe) ;  //板材
        frame_second = findViewById(R.id.frame_second);  //油漆
        frame_third = findViewById(R.id.frame_third);  //砖
        frame_fourth = findViewById(R.id.frame_fourth);   //灯具
   // lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mString));
   // lv.setTextFilterEnabled(true);  //设置List启用过滤
    //    lv.clearTextFilter();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //由一屏幕显示的项数决定
        columnWidth = dm.widthPixels;
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                (columnWidth-160)/4, (columnWidth-160)/4);
        params1.setMargins(20,0,20,15);
        frame_first.setLayoutParams(params1);//设置宽和高
        frame_second.setLayoutParams(params1);//设置宽和高
        frame_third.setLayoutParams(params1);//设置宽和高
        frame_fourth.setLayoutParams(params1);//设置宽和高

        // 4. 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
//        titleBar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(cl.this, "点击搜索", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(cl.this,Search_Activity.class));
//            }
//        });
//
//        // 5. 设置点击返回按键后的操作（通过回调接口）
//        titleBar.setOnClickBack(new bCallBack() {
//            @Override
//            public void BackAciton() {
//                finish();
//            }
//        });
        titleBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cl.this, "点击搜索", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(cl.this,Search_Activity.class));
            }
        });
        titleBar.setListener(new CommonTitleBar.OnTitleBarListener() {

            @Override
            public void onClicked(View v, int action, String extra){
                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                    onBackPressed();
                }
                if(action==CommonTitleBar.ACTION_RIGHT_TEXT||action==CommonTitleBar.ACTION_RIGHT_BUTTON){
                    startActivity(new Intent(cl.this,Search_Activity.class));
                }
            }
        });
        frame_first.setOnClickListener(this);
        frame_second.setOnClickListener(this);
        frame_third.setOnClickListener(this);
        frame_fourth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qwe:
                startActivity(new Intent(cl.this,boardActivity.class));
                break;
            case R.id.frame_second:
                startActivity(new Intent(cl.this,oilActivity.class));
                break;
            case R.id.frame_third:
                startActivity(new Intent(cl.this,brickActivity.class));
                break;
            case R.id.frame_fourth:
                startActivity(new Intent(cl.this,lampActivity.class));
                break;
        }
    }
}
