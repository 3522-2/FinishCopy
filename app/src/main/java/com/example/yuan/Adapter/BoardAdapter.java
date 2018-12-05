package com.example.yuan.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.Board;
import com.example.yuan.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/2.
 */

public class BoardAdapter extends BaseAdapter {
    private Context mContetx;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Board> boards=new ArrayList<>();
    public BoardAdapter(Context context,ArrayList<Board> userinfo) {
        mContetx=context;
        boards=userinfo;
        mLayoutInflater=(LayoutInflater) mContetx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        //返回某一条对象
        return boards.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //返回一个视图
        ViewHolder viewHolder;
        if(convertView==null) {
            convertView = mLayoutInflater.inflate(R.layout.activity_board_adapter, null); //解析这个layout的xml文件，成为一个contentview视图
            viewHolder = new ViewHolder();
            //获取控件
            viewHolder.nameTextView=convertView.findViewById(R.id.text_adapter);
            viewHolder.avatarImageView=convertView.findViewById(R.id.image_adapter);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();  //不是空的时候，把它取出来
        }

        //和数据之间进行绑定
        viewHolder.nameTextView.setText(boards.get(position).getName());
        viewHolder.avatarImageView.setImageResource( boards.get(position).getPicture());
        return convertView;

    }
    class ViewHolder{
        TextView nameTextView;
        ImageView avatarImageView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        //返回有多少条数据
        return boards.size();
    }


    /*
    刷新数据
     */
    public void refreshData(ArrayList<Board> userinfo){
        boards=userinfo;
        notifyDataSetChanged();

    }
}
