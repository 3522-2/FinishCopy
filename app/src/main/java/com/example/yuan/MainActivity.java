package com.example.yuan;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.Budge.ShowBudge;
import com.example.yuan.CL.cl;
import com.example.yuan.ThreeD.ThreeShow;
import com.example.yuan.XGT.XgtMain;
import com.example.yuan.person.PersonMain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_title;
    private LinearLayout ll_point_group;

    private ImageView textView1,textView2,textView3,textView4;
    private ImageView CL,budge,XGT;

    private ArrayList<ImageView> imageViews;
    private final int[] imageIds={R.drawable.a,
            R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    private final String[] imageDescription = {"公司介绍","活动一","活动二","活动三","活动四"};
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            int item = viewPager.getCurrentItem()+1;
            viewPager.setCurrentItem(item);
            //延迟发消息
            handler.sendEmptyMessageDelayed(0,4000);
        }
    };
    /**
     * 上一次高亮显示的位置
     *
     */
    private int prePosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (ImageView) findViewById(R.id.textview1);
        textView2 = (ImageView) findViewById(R.id.textview2);
        textView3 = (ImageView) findViewById(R.id.textview3);
        textView4 = (ImageView) findViewById(R.id.textview4);
        /**
         * 跳转到效果图
         */
        XGT = (ImageView)findViewById(R.id.effect_picture) ;
        XGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,XgtMain.class);
                startActivity(intent);
            }
        });


        /**
         * 跳转到CL
         */
        CL= (ImageView)findViewById(R.id.meterials_picture);
        CL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,cl.class);
                startActivity(intent);
            }
        });
        /**
         * 跳转到预算
         */
        budge = (ImageView)findViewById(R.id.budget);
        budge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ShowBudge.class);
                startActivity(intent);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"首页", Toast.LENGTH_SHORT).show();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"案例", Toast.LENGTH_SHORT).show();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this, ThreeShow.class);
               startActivity(intent);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"我的", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PersonMain.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tv_title = (TextView)findViewById(R.id.tv_title);
        ll_point_group = (LinearLayout)findViewById(R.id.ll_point_group);
        //ViewPager的使用
        //1：在布局文件中定义ViewPager
        //2：在代码中实例化ViewPager
        //3：准备数据
        imageViews = new ArrayList<>();
        for (int i=0;i<imageIds.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            //添加到集合中
            imageViews.add(imageView);

            //添加点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_selector);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8,8);
            if(i==0){
                point.setEnabled(true);//显示红色
            }else{
                point.setEnabled(false);//显示灰色
                params.leftMargin=8;
            }

            point.setLayoutParams(params);
            ll_point_group.addView(point);
            }
        //4：设置设配器（PagerAdapter）-item布局-绑定数据
        //4：设置设配器（PagerAdapter）-item布局-绑定数据
        viewPager.setAdapter(new MyPagerAdapter());
        //设置监听viewPager页面的改变
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());

        //设置中间的位置
        int item = Integer.MAX_VALUE/2 - Integer.MAX_VALUE/2%imageViews.size();//要保证imageView的整数倍


        viewPager.setCurrentItem(item);
        tv_title.setText(imageDescription[prePosition]);

        //发消息
        handler.sendEmptyMessageDelayed(0,3000);

    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        /**
         * 当页面滚动了的时候回调这个方法
         * @param position 当前页面的位置
         * @param positionOffset 滑动页面的百分比
         * @param positionOffsetPixels 在我们屏幕上滑动的像素
         */
        @Override

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         *当某个页面被选中了的时候的页面
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            int realPosition = position%imageViews.size();
            //设置当前页面的文本信息
            tv_title.setText(imageDescription[realPosition]);
            //把上一个高亮的设置默认-灰色
            ll_point_group.getChildAt(prePosition).setEnabled(false);
            //当前设置为高亮-红色
            ll_point_group.getChildAt(realPosition).setEnabled(true);
            prePosition = realPosition;
        }

        /**
         * 当页面滚动状态变化的时候回调这个方法
         * 静止->滑动
         * 滑动-->静止
         * 静止-->拖拽
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {


        }
    }

    /**
     * 设置viewPager适配器
     */
    class MyPagerAdapter extends PagerAdapter {
        /**
         *
         * 得到图片总数
         * @return
         */
        @Override
        public int getCount() {
            // return imageViews.size();
            return Integer.MAX_VALUE;
        }

        /**
         * 比较view和obiect是否为同一个实例
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
//            if(view == object){
//                return true;
//            }else{
//                return false;
//            }
            return view ==object;
        }

        /**
         * 相当于getView方法
         * @param container viewPager自身
         * @param position  当前实例化页面
         * @return
         */

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int realPosition = position%imageViews.size();
            final ImageView imageView = imageViews.get(realPosition);
            container.addView(imageView);//添加到ViewPager中
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN://按下
                            handler.removeCallbacksAndMessages(null);
                            break;

                        case MotionEvent.ACTION_MOVE://手指在这个空间上移动
                            break;

                        case MotionEvent.ACTION_CANCEL:
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessageDelayed(0,4000);
                            break;

                        case  MotionEvent.ACTION_UP://手指离开
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessageDelayed(0,4000);
                            break;
                    }
                    return false;
                }
            });

            imageView.setTag(position);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int)v.getTag()%imageViews.size();

                    String text= imageDescription[position];

                    //在此设置跳转意图
                    Toast.makeText(MainActivity.this,"text=="+text, Toast.LENGTH_SHORT).show();
                }
            });
            return imageView;
        }

        /**
         * 释放资源
         * @param container viewpager
         * @param position 要释放的位置
         * @param object 要释放的页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position,Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
