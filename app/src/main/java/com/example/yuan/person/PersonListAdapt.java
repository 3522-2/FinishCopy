package com.example.yuan.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.R;

import java.util.List;

public class PersonListAdapt extends BaseAdapter {
    private List<ListItemModel> listItems;
    private LayoutInflater layoutInflater;

    public PersonListAdapt(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public List<ListItemModel> getListItems() {
        return listItems;
    }

    public void setListItems(List<ListItemModel> listItems) {
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView myListItemView;
        if (convertView == null) {
            myListItemView = new ListItemView();
            // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null

            convertView = layoutInflater.inflate(R.layout.personitem, null);
            myListItemView.setTv_title((ImageView) convertView.findViewById(R.id.item_image));
            myListItemView.setTv_data((TextView) convertView.findViewById(R.id.item_title));
            myListItemView.setIv_image((ImageView) convertView.findViewById(R.id.item_image2));
            //通过setTag将convertView与myListItemView关联
            convertView.getTag();
        } else {
            //如果缓存池中有对应的view缓存，则直接通过getTag取出myListItemView
            myListItemView = (ListItemView) convertView.getTag();
        }
        myListItemView.getTv_title().setImageResource(listItems.get(position).getTitle());
        myListItemView.getTv_data().setText(listItems.get(position).getData());
        myListItemView.getIv_image().setImageResource(listItems.get(position).getRid());
        return convertView;
    }

    public static class ListItemModel {

        private int title;
        private String data;
        private int rid;

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

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
        private ImageView tv_title;
        private TextView tv_data;
        private ImageView iv_image;

        public ImageView getTv_title() {
            return tv_title;
        }

        public void setTv_title(ImageView tv_title) {
            this.tv_title = tv_title;
        }

        public TextView getTv_data() {
            return tv_data;
        }

        public void setTv_data(TextView tv_data) {
            this.tv_data = tv_data;
        }

        public ImageView getIv_image() {
            return iv_image;
        }

        public void setIv_image(ImageView iv_image) {
            this.iv_image = iv_image;
        }
    }

}