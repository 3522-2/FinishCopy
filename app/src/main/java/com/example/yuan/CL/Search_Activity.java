package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuan.R;

import java.util.ArrayList;
import java.util.Iterator;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

/**
 * Created by lenovo on 2018/12/16.
 */

public class Search_Activity extends Activity {

    private SearchView searchView;
      private ListView lv;
      int i;
      private ArrayList<String> lv_list=new ArrayList<>();
    private  String[] mString={"细工板","装饰板","胶合板","集合板","防火板","刨花板","石膏板","铝扣板","铝塑板",
            "玻化砖","通体砖","釉面砖", "仿古砖","抛光砖","马赛克",
            "吸顶灯","吊灯","壁灯","射灯","台灯","落地灯",
            "木器漆","内墙漆","外墙漆","防火漆"};
    private  int[] picture={R.drawable.xigong,R.drawable.zhuangshi,R.drawable.jiaohe,R.drawable.jihe,R.drawable.fanghuo,R.drawable.paohua,R.drawable.shigao,R.drawable.lvkou,R.drawable.lvshuo,
            R.drawable.bohua,R.drawable.tongti,R.drawable.youmian,R.drawable.fanggu,R.drawable.paoguang,R.drawable.masaike,
            R.drawable.xiding, R.drawable.diaodeng,R.drawable.bideng,R.drawable.shedeng,R.drawable.taideng,R.drawable.luodideng,
            R.drawable.muqi, R.drawable.neiqiang,R.drawable.waiqiang,R.drawable.fanghuo};
    private  int[] introduce={R.string.xigong,R.string.zhuangshi,R.string.jiaohe,R.string.jihe,R.string.fanghuo,R.string.paohua,R.string.shigao,R.string.lvkou,R.string.lvsu,
            R.string.bohua,R.string.tongti,R.string.youmian,R.string.fanggu,R.string.paoguang,R.string.masaike,
            R.string.xidingdeng, R.string.diaodeng,R.string.bideng,R.string.shedeng,R.string.taideng,R.string.luodideng,
            R.string.muqi, R.string.neiqiang,R.string.waiqiang,R.string.fanghuo};
    private String[] arr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.search_view_first);
         lv = findViewById(R.id.lv);
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                for( i=0;i<mString.length;i++){
                    if(mString[i].equals(string)){
                        lv_list.add(mString[i]);
                        break;
                    }
                }
                if(lv_list.isEmpty()){
                    Toast.makeText(Search_Activity.this, "很抱歉，暂时查询不到结果", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Search_Activity.this, cl_child_Activity.class);
                    intent.putExtra("picture", picture[i]);
                    intent.putExtra("introduce", introduce[i]);
                    intent.putExtra("title", mString[i]);
                    startActivity(intent);
//                for(String a: mString){
//                    if(a.equals(string)){
//                        lv_list.add(a);
//                    }
//                }
                }
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }
}
