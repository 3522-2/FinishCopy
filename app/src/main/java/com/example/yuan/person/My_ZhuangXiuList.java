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

import com.example.yuan.Dao.ProjectDAO;
import com.example.yuan.R;
import com.example.yuan.modle.Project;

import java.util.List;

public class My_ZhuangXiuList extends AppCompatActivity {
    public static final String FLAG = "id";// 定义一个常量，用来作为请求码
    ListView lvinfo;// 创建ListView对象
    private ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__zhuang_xiu_list);
        /**
         * 返回上一页
         */
        fanhui = (ImageView) findViewById(R.id.re);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(My_ZhuangXiuList.this, PersonMain.class);
                startActivity(intent);
            }
        });

        lvinfo=(ListView)findViewById(R.id.Projectinfo) ;
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
                String strInfo = String.valueOf(((TextView) view).getText());// 记录收入信息
                Log.i("NAME的值",strInfo);
                intent.setClass(My_ZhuangXiuList.this,Show_ZhuangXiu.class);
                intent.putExtra("id",strInfo);
                startActivity(intent);
            }
        });
    }

    private void ShowInfo() {
        String[] strInfos = null;// 定义字符串数组，用来存储收入信息
        ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
        ProjectDAO projectDAO = new ProjectDAO(My_ZhuangXiuList.this);
        // 获取所有收入信息，并存储到List泛型集合中
        List<Project> listinfos = projectDAO.getScrollData(0,
                (int) projectDAO.getCount());
        strInfos = new String[listinfos.size()];// 设置字符串数组的长度
        int m = 0;// 定义一个开始标识
        for (Project project : listinfos) {// 遍历List泛型集合
            // 将收入相关信息组合成一个字符串，存储数组的相应位置
            strInfos[m] =  project.getProject_Name();
            m++;// 标识加1
        }
        // 使用字符串数组初始化ArrayAdapter对象
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strInfos);
        lvinfo.setAdapter(arrayAdapter);// 为ListView列表设置数据源
    }


}
