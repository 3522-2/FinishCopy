package com.example.yuan.CL;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuan.Adapter.BoardAdapter;
import com.example.yuan.Board;
import com.example.yuan.R;
//import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/2.
 */

public class boardActivity extends Activity {

//    private ListView list_view;
//    private ArrayList<Board> list;
////细工板，装饰板，胶合板，集合版，防火板，刨花板，石膏板，铝扣板
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_board);
//        CommonTitleBar titleBar_board=findViewById(R.id.titlebar_board);
//        list_view = findViewById(R.id.list_view);
//        titleBar_board.setListener(new CommonTitleBar.OnTitleBarListener() {
//            @Override
//            public void onClicked(View v, int action, String extra) {
//                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
//                    onBackPressed();
//                }
//            }
//        });
//        list=new ArrayList<>();
//        list.add(new Board("细工板",R.drawable.a));
//        list.add(new Board("装饰板",R.drawable.b));
//        list.add(new Board("胶合板",R.drawable.c));
//        list.add(new Board("集合版",R.drawable.d));
//        list.add(new Board("防火板",R.drawable.e));
//        BoardAdapter boardAdapter=new BoardAdapter(boardActivity.this,list);
//        list_view.setAdapter(boardAdapter);
//
//        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    //新建另外一批新的数据
//                    //替换掉老的数据
//                    //刷新listview，让它更新自己的视图
//                   // list_view.refreshData(userInfos);
//                }
//            }
//        });
//    }
}
