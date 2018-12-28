package com.example.yuan.XGT;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.yuan.R;

import java.util.List;

public class XGTAdapt extends BaseAdapter {
    private List<ListItemModel> listItems;
    private LayoutInflater layoutInflater;


    public XGTAdapt(Context context) {

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
        ListItemView myListItemView=new ListItemView();;
        if (convertView == null) {

            // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = layoutInflater.inflate(R.layout.xgtitem, null);
            myListItemView.setTv_imagel((ImageView) convertView.findViewById(R.id.imageL));
            myListItemView.setTv_title((TextView) convertView.findViewById(R.id.titleI));
            myListItemView.setTv_imager((ImageView) convertView.findViewById(R.id.imageR));
            //通过setTag将convertView与myListItemView关联
            convertView.getTag();
        } else {
            //如果缓存池中有对应的view缓存，则直接通过getTag取出myListItemView
            myListItemView = (ListItemView) convertView.getTag();

        }
         String filePath = listItems.get(position).getImagel();
        Log.i("图片的获取路径",filePath);
        Bitmap bm = BitmapFactory.decodeFile(filePath);

        String filePath1 = listItems.get(position).getImager();
        Log.i("图片的获取路径",filePath1);
        Bitmap bm1 = BitmapFactory.decodeFile(filePath1 );

        myListItemView.getTv_imagel().setImageBitmap(bm);
        myListItemView.getTv_title().setText(listItems.get(position).getTitle());
        myListItemView.getTv_imager().setImageBitmap(bm1);
        return convertView;

    }

    public static class ListItemModel {

        private String imagel;
        private String title;
        private String imager;

        public String getImagel() {
            return imagel;
        }

        public void setImagel(String imagel) {
            this.imagel = imagel;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImager() {
            return imager;
        }

        public void setImager(String imager) {
            this.imager = imager;
        }
    }
    class ListItemView {
        private ImageView tv_imagel;
        private TextView tv_title;
        private ImageView tv_imager;

        public ImageView getTv_imagel() {
            return tv_imagel;
        }

        public void setTv_imagel(ImageView tv_imagel) {
            this.tv_imagel = tv_imagel;
        }

        public TextView getTv_title() {
            return tv_title;
        }

        public void setTv_title(TextView tv_title) {
            this.tv_title = tv_title;
        }

        public ImageView getTv_imager() {
            return tv_imager;
        }

        public void setTv_imager(ImageView tv_imager) {
            this.tv_imager = tv_imager;
        }
    }
}