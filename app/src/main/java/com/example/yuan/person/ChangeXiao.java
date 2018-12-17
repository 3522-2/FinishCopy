package com.example.yuan.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yuan.Dao.EffectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Effect;

import java.util.List;

public class ChangeXiao extends AppCompatActivity {

    public static final String FLAG = "id";// 定义一个常量，用来作为请求码
    ListView lvinfo;// 创建ListView对象
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_xiao);

        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChangeXiao.this, gaunliyuanMain.class);
                startActivity(intent);


            }
        });
        lvinfo = (ListView) findViewById(R.id.schemeinfo);// 获取布局文件中的ListView组件

        ShowInfo();// 调用自定义方法显示方案信息


        /**
         * listview点击事件，将id打包送到下一个页面
         */
        lvinfo.setOnItemClickListener(new AdapterView.OnItemClickListener(){// 为ListView添加项单击事件
            // 重写onItemClick方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent();
                String strInfo = String.valueOf(((TextView) view).getText());// 记录
                String strid = strInfo.substring(0, strInfo.indexOf('|'));// 从信息中截取收入编号
                Log.i("i的值",strid);
                intent.setClass(ChangeXiao.this,EditXiao.class);
                intent.putExtra("id",strid);
                startActivity(intent);
                finish();
            }
        });
    }

    private void ShowInfo() {
        String[] strInfos = null;// 定义字符串数组，用来存储信息
        ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
        EffectDAO effectDAO = new EffectDAO(ChangeXiao.this);
        // 获取所有收入信息，并存储到List泛型集合中
        List<Effect> listinfos = effectDAO.getScrollData(0,
                (int) effectDAO.getCount());
        strInfos = new String[listinfos.size()];// 设置字符串数组的长度
        int m = 0;// 定义一个开始标识
        for (Effect effect : listinfos) {// 遍历List泛型集合
            // 将收入相关信息组合成一个字符串，存储数组的相应位置
            strInfos[m] =  effect.getEffect_id()+"    |    " +effect.getEffect_name()
                        +"     "+effect.getEffect_describe();
            m++;// 标识加1
        }
        // 使用字符串数组初始化ArrayAdapter对象
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strInfos);
        lvinfo.setAdapter(arrayAdapter);// 为ListView列表设置数据源
    }


}



