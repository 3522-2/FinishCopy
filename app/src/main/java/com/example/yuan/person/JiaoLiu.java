package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.yuan.R;

import java.util.ArrayList;
import java.util.List;

public class JiaoLiu extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiao_liu);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(JiaoLiu.this, GengXinJinDu.class);
                startActivity(intent);
            }
        });
        init();

        final EditText inputText=(EditText)findViewById(R.id.input);
        Button sendBtn=(Button)findViewById(R.id.send);

        final RecyclerView msgRecyclerView=(RecyclerView)findViewById(R.id.msg);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);

        final MsgAdapter adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if("".equals(content))
                    return;

                msgList.add(new Msg(content, Msg.TYPE.SENT));

                //如果有新消息，则设置适配器的长度（通知适配器，有新的数据被插入），并让 RecyclerView 定位到最后一行
                int newSize = msgList.size() - 1;
                adapter.notifyItemInserted(newSize);
                msgRecyclerView.scrollToPosition(newSize);

                //清空输入框中的内容
                inputText.setText("");


            }
        });

    }

    /**
     * 初始化消息数据
     */
    private void init() {


    }
}

