package com.example.yuan.person;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yuan.Dao.UserDAO;
import com.example.yuan.SavePicture.SavePicture;
import com.example.yuan.SavePicture.XiangCeSave;
import com.example.yuan.modle.User;
import com.example.yuan.person.MyDialogPerson;
import com.example.yuan.MainActivity;
import com.example.yuan.R;

import java.util.ArrayList;
import java.util.List;

public class PersonMain extends AppCompatActivity {
    private SharedPreferences sp;
    private ImageView cirLog;
    private LinearLayout Canal;
    private TextView textView;
    private MyDialogPerson myDialog;
    private ListView listView;
    private RelativeLayout relativeLayout;
    private int[] title = new int[]{R.mipmap.person1, R.mipmap.person3, R.mipmap.person4, R.mipmap.person5, R.mipmap.youhui3};
    private String[] Data = new String[]{"我的装修", "更新装修进度", "联系我们", "设置", "我的优惠"};
    private int[] imageld = new int[]{R.mipmap.jiantou, R.mipmap.jiantou, R.mipmap.jiantou, R.mipmap.jiantou, R.mipmap.jiantou};
    private List<PersonListAdapt.ListItemModel> myListItem;
    private PersonListAdapt adApter;
    private ImageView fanhui;
    private static final String IMAGE_UNSPECIFIED = "image/*";
    private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
    public static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_main);

        textView = (TextView) findViewById(R.id.textView);
        SharedPreferences sharedPreferences = this.getSharedPreferences("yonghu", MODE_PRIVATE);
        final String name = sharedPreferences.getString("用户名", "未登录");
        textView.setText(name);

        cirLog = (ImageView) findViewById(R.id.Cirimageview);
        SharedPreferences sharedPreferences1 = this.getSharedPreferences("yonghu", MODE_PRIVATE);

        fanhui = (ImageView) findViewById(R.id.re);
        listView = (ListView) findViewById(R.id.ListView);
        myListItem = new ArrayList<PersonListAdapt.ListItemModel>();
        for (int i = 0; i < imageld.length; i++) {
            PersonListAdapt.ListItemModel listItemModel = new PersonListAdapt.ListItemModel();
            listItemModel.setTitle(title[i]);
            listItemModel.setData(Data[i]);
            listItemModel.setRid(imageld[i]);
            myListItem.add(listItemModel);
        }
        adApter = new PersonListAdapt(PersonMain.this);
        adApter.setListItems(myListItem);
        listView.setAdapter(adApter);

        final String zhuangTai = sharedPreferences.getString("用户名", "");
        Log.i("zhuangTai",zhuangTai);
       final UserDAO userDAO = new UserDAO(PersonMain.this);


       final  User user = userDAO.find(zhuangTai);


        boolean isname = userDAO.isCheckall(zhuangTai);//判断用户是否存在
        Log.i("isname",String.valueOf(isname));
        if (isname == true){
            String touxiang=user.getUser_touxiang();
          if (touxiang.equals("0")==false){
              String path = user.getUser_touxiang();
            Log.i("path",path);
            userDAO.addtouxiang(path,zhuangTai);
            Bitmap bm = BitmapFactory.decodeFile(path);
            cirLog.setImageBitmap(bm);
          }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = getSharedPreferences("yonghu", 0);

                if (id == 0) {
                    if (zhuangTai.equals("未登录") || zhuangTai == null) {
                        Toast.makeText(PersonMain.this, "请登录后查看", Toast.LENGTH_SHORT).show();
                    } else if (zhuangTai.equals("你好，管理员")) {
                        Toast.makeText(PersonMain.this, "管理员无法查看该内容", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(PersonMain.this, My_ZhuangXiuList.class);
                        startActivity(intent);
                        finish();
                    }

                }
                if (id == 1) {

                    if (zhuangTai.equals("你好，管理员")) {
                        Intent intent = new Intent();
                        intent.setClass(PersonMain.this, GengXinJinDu.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(PersonMain.this, "您不是管理员，或者请管理员登录后查看", Toast.LENGTH_SHORT).show();
                    }

                }
                if (id == 2) {
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this, LianXi.class);
                    startActivity(intent);
                    finish();
                }
                if (id == 3) {
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this, SheZhi.class);
                    startActivity(intent);
                    finish();
                }
                if (id == 4) {
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this, ShowHongBao.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        /**
         * 注销
         */
        Canal = (LinearLayout) findViewById(R.id.canal);
        Canal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1：得到sp对象
                sp = getSharedPreferences("yonghu", Context.MODE_PRIVATE);
                //2：得到editor对象
                SharedPreferences.Editor editor = sp.edit();
                //3：得到输入的key/vaule
                String key = "用户名";
                String value = "未登录";
                String key3 = "是否登录";
                String value3 = "点此登录";
                //4:用editor保存key/vaule
                editor.putString(key, value).commit();
                editor.putString(key3, value3).commit();
                myDialog = new MyDialogPerson(PersonMain.this, R.style.MyDialog);

                myDialog.setMessage("点击确定注销登录");

                myDialog.setYesOnclickListener("确定", new MyDialogPerson.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        Intent intent = new Intent();
                        intent.setClass(PersonMain.this, PersonMain.class);
                        startActivity(intent);
                        finish();
                        myDialog.dismiss();
                    }
                });
                myDialog.setNoOnclickListener("取消", new MyDialogPerson.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {

                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });
        /**
         * 读取修改用户信息
         */
        relativeLayout = findViewById(R.id.imageView3);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("你好，管理员") || name.equals("未登录")) {
                    Toast.makeText(PersonMain.this, "只能用户修改信息", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(PersonMain.this, ShowInfor.class);
                    intent.putExtra("用户名", name);
                    Log.i("name", name);
                    startActivity(intent);
                    finish();
                }
            }
        });
        /**
         * 返回上一页
         */
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonMain.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 进入选择登录页面
         */
        cirLog.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonMain.this, login.class);
                startActivityForResult(intent, 777);
                return true;
            }
        });
        cirLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"相册", "相机"};
                AlertDialog.Builder builder = new AlertDialog.Builder(PersonMain.this);
                builder.setTitle("请选择头像获取方式");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PersonMain.this, items[which], Toast.LENGTH_SHORT).show();
                        if (items[which] == "相册") {
                            setImage();
                        }
                        if (items[which] == "相机"){
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
                        }
                    }
                });
                builder.create().show();
            }
        });


    }
    private void setImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
        startActivityForResult(intent, IMAGE_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断请求码和返回码是不是正确的，这两个码都是我们自己设置的
        if (requestCode == 777 && resultCode == 333) {
            String name = data.getStringExtra("name");// 拿到返回过来的输入的账号
            String btn = data.getStringExtra("button");
            // 把得到的数据显示到输入框内
            textView.setText(name);
        }
        final User user = new User();
        UserDAO userDAO = new UserDAO(PersonMain.this);
        if (requestCode == IMAGE_CODE) {
            XiangCeSave xiangCeSave = new XiangCeSave(PersonMain.this);
            String path = xiangCeSave.save(data, cirLog);
            SharedPreferences sharedPreferences = this.getSharedPreferences("yonghu", MODE_PRIVATE);
            String zhuangTai = sharedPreferences.getString("用户名", "");
            Log.i("用户名", zhuangTai);
            userDAO.addtouxiang(path,zhuangTai);
        }
        if (resultCode == RESULT_OK) {  //如果拍好了照

            Bundle bundle = data.getExtras();
            SavePicture savePicture = new SavePicture();  //保存图片
            final String name = "/sdcard/Image/"+savePicture.savePicture(bundle, cirLog);
            Log.i("更新进度的name", name);
            SharedPreferences sharedPreferences = this.getSharedPreferences("yonghu", MODE_PRIVATE);
            String zhuangTai = sharedPreferences.getString("用户名", "");
            Log.i("用户名", zhuangTai);
            userDAO.addtouxiang(name,zhuangTai);
        }
    }


}