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

import com.example.yuan.Dao.SchemeDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Scheme;

import java.util.List;

public class ChangeSchem extends AppCompatActivity {
    public static final String FLAG = "id";// 定义一个常量，用来作为请求码
    ListView lvinfo;// 创建ListView对象
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_schem);


        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ChangeSchem.this, gaunliyuanMain.class);
                startActivity(intent);
            }
        });
            lvinfo = (ListView) findViewById(R.id.schemeinfo);// 获取布局文件中的ListView组件

            ShowInfo();// 调用自定义方法显示方案信息

            lvinfo.setOnItemClickListener(new AdapterView.OnItemClickListener(){// 为ListView添加项单击事件
                // 重写onItemClick方法
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent intent = new Intent();
                    String strInfo = String.valueOf(((TextView) view).getText());// 记录收入信息
                    String strid = strInfo.substring(0, strInfo.indexOf('|'));// 从信息中截取收入编号
                    Log.i("i的值",strid);
                    intent.setClass(ChangeSchem.this,EditScheme.class);
                    intent.putExtra("id",strid);
                    startActivity(intent);
                }
            });
        }

    private void ShowInfo() {
        String[] strInfos = null;// 定义字符串数组，用来存储收入信息
        ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
        SchemeDAO schemeDAO = new SchemeDAO(ChangeSchem.this);
        // 获取所有收入信息，并存储到List泛型集合中
        List<Scheme> listinfos = schemeDAO.getScrollData(0,
                (int) schemeDAO.getCount());
        strInfos = new String[listinfos.size()];// 设置字符串数组的长度
        int m = 0;// 定义一个开始标识
        for (Scheme scheme : listinfos) {// 遍历List泛型集合
            // 将收入相关信息组合成一个字符串，存储到字符串数组的相应位置
            strInfos[m] =  scheme.getScheme_id()+"|    "
            +scheme.getScheme_houseArea() +"      "+scheme.getScheme_houseStyle()
            +"      " +scheme.getScheme_houseType();
            m++;// 标识加1
        }
        // 使用字符串数组初始化ArrayAdapter对象
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strInfos);
        lvinfo.setAdapter(arrayAdapter);// 为ListView列表设置数据源
    }


}

