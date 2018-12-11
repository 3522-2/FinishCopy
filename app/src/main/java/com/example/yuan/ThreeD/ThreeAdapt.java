package com.example.yuan.ThreeD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yuan.R;

import java.util.List;

/**
 * create by YUAN
 * on 2018/12/10
 */
public class ThreeAdapt extends BaseAdapter {
    private List<ThreeAdapt.ListItemModel> listItems;
    private LayoutInflater layoutInflater;

    public ThreeAdapt(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public List<ThreeAdapt.ListItemModel> getListItems() {
        return listItems;
    }

    public void setListItems(List<ThreeAdapt.ListItemModel> listItems) {
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView myListItemView;
        if (convertView == null) {
            myListItemView = new ListItemView();
            // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = layoutInflater.inflate(R.layout.activity_show0ne, null);
            myListItemView.setCustom3DView((Custom3DView) convertView.findViewById(R.id.activity_myview_customview));
//            myListItemView.setTextView((TextView) convertView.findViewById(R.id.TV));

            //通过setTag将convertView与myListItemView关联
            convertView.getTag();
            return null;
        }else {
            //如果缓存池中有对应的view缓存，则直接通过getTag取出myListItemView
            myListItemView = (ListItemView) convertView.getTag();
        }
        myListItemView.setCustom3DView((Custom3DView) convertView.findViewById(R.id.activity_myview_customview));
//        myListItemView.setTextView((TextView) convertView.findViewById(R.id.TV));
        return convertView;
    }
    public static class ListItemModel {


        private String data;
        private int rid;


        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }
    }
    class ListItemView {
        private Custom3DView custom3DView;
        private TextView textView;

        public Custom3DView getCustom3DView() {
            return custom3DView;
        }

        public void setCustom3DView(Custom3DView custom3DView) {
            this.custom3DView = custom3DView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }


}

