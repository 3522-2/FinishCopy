package com.example.yuan.CL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuan.CL.BoardAdapter;
import com.example.yuan.CL.Board;
import com.example.yuan.R;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/2.
 */

public class boardActivity extends Activity {

    private ListView list_view;
    private ArrayList<Board> list;
    //细工板，装饰板，胶合板，集合板，防火板，刨花板，石膏板，铝扣板
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        final CommonTitleBar titleBar_board=findViewById(R.id.titlebar_board);
        list_view = findViewById(R.id.list_view);
        titleBar_board.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if(action==CommonTitleBar.ACTION_LEFT_TEXT||action==CommonTitleBar.ACTION_LEFT_BUTTON){
                    onBackPressed();
                }
            }
        });
        list=new ArrayList<>();
        list.add(new Board("细工板",R.drawable.xigong));
        list.add(new Board("装饰板",R.drawable.zhuangshi));
        list.add(new Board("胶合板",R.drawable.jiaohe));
        list.add(new Board("集合版",R.drawable.jihe));
        list.add(new Board("防火板",R.drawable.fanhuo));
        list.add(new Board("刨花板",R.drawable.paohua));
        list.add(new Board("石膏板",R.drawable.shigao));
        list.add(new Board("铝扣板",R.drawable.lvkou));
        list.add(new Board("铝塑板",R.drawable.lvshuo));

        BoardAdapter boardAdapter=new BoardAdapter(boardActivity.this,list);
        list_view.setAdapter(boardAdapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.xigong);
                    intent.putExtra("introduce",R.string.xigong);
                    intent.putExtra("title","细工板");
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.zhuangshi);
                    intent.putExtra("introduce",R.string.zhuangshi);
                    intent.putExtra("title","装饰板");
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.jiaohe);
                    intent.putExtra("introduce",R.string.jiaohe);
                    intent.putExtra("title","胶合板");
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.jihe);
                    intent.putExtra("introduce",R.string.jihe);
                    intent.putExtra("title","集合板");
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.fanhuo);
                    intent.putExtra("introduce",R.string.fanghuo);
                    intent.putExtra("title","防火板");
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.paohua);
                    intent.putExtra("introduce",R.string.paohua);
                    intent.putExtra("title","刨花板");
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.shigao);
                    intent.putExtra("introduce",R.string.shigao);
                    intent.putExtra("title","石膏板");
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.lvkou);
                    intent.putExtra("introduce",R.string.lvkou);
                    intent.putExtra("title","铝扣板");
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent=new Intent(boardActivity.this,cl_child_Activity.class);
                    intent.putExtra("picture",R.drawable.lvshuo);
                    intent.putExtra("introduce",R.string.lvsu);
                    intent.putExtra("title","铝塑板");
                    startActivity(intent);
                }
            }
        });
    }
}

