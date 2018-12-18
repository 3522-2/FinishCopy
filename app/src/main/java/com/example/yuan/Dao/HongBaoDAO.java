package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.yuan.modle.HongBao;

import java.util.ArrayList;
import java.util.List;


public class HongBaoDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public HongBaoDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }

    /**
     * 添加活动信息
     * @Data
     * @param hongbao
     */
   public void add(HongBao hongbao) {
       //执行insert into activity(activity_id,activity_name,activity_StartTime" +
       //           ",activity_FinishTime,activity_people,activity_content) values (?,?,?,?,?,?)"

       values.put("hong_name",hongbao.getHong_name());
       values.put("hong_thou",hongbao.getHong_thou());
       values.put("hong_three",hongbao.getHong_three());
       values.put("hong_nametel",hongbao.getHong_nametel());
       db.insert("hongbao",null,values);
       db.close();

   }

    /**
     * 更新活动信息
     *
     * @param hongbao
     */
//    public void update(User user) {
////		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
//        // 执行修改密码操作
//        db.execSQL("update User set password = ?",
//                new Object[] { user.getUserpwd() });
//    }
//}

    public void update(HongBao hongbao) {
        db.execSQL("update hongbao set hong_three=?,hong_thou=?,hong_nametel=? where hong_name=?",
                             new Object[]{hongbao.getHong_three(),hongbao.getHong_thou(),hongbao.getHong_nametel(),hongbao.getHong_name(),});

//        values.put("hong_thou",hongbao.getHong_thou());
//        values.put("hong_three",hongbao.getHong_three());
//        values.put("hong_nametel",hongbao.getHong_nametel());
//        db.update("hongbao",values,"hong_name"=hongbao.getHong_name(),null);
//        db.close();
    }

    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<HongBao> getAll(){
        //执行select * from activity
        List<HongBao> list = new ArrayList<HongBao>();
        Cursor cursor = db.query("hongbao",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){

            String hong_name = cursor.getString(0);
            String hong_thou = cursor.getString(1);
            String hong_three = cursor.getString(2);
            String hong_nametel = cursor.getString(3);
            list.add(new HongBao(hong_name,hong_thou,hong_three,hong_nametel));
        }
        cursor.close();
        db.close();
        return  list;
    }
    public HongBao find(String name){

        Cursor cursor = db.rawQuery("select * from hongbao where hong_name=?",new String[]{String.valueOf(name)});
        if (cursor.moveToNext()){
            return new HongBao( cursor.getString(cursor.getColumnIndex("hong_name")),
                    cursor.getString(cursor.getColumnIndex("hong_thou")),
                    cursor.getString(cursor.getColumnIndex("hong_three")),
                    cursor.getString(cursor.getColumnIndex("hong_nametel"))
                    );
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null

    }
    /**
     * 根据id查找活动信息
     *
     * @return
     * @param name
     */

    public int CheckIsDataAlreadyInDBorNot(String name) {
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        String Query = "Select * from hongbao where hong_name=?";
        Cursor cursor = db.rawQuery(Query, new String[]{String.valueOf(name)});
        if (cursor.getCount() > 0) {
            cursor.close();
            return 1;
        }
        cursor.close();
        return -1;
    }

    /**
     * 获得总活动数
     * @return
     */
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(hong_name) from hongbao", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}
