package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Information;

import java.util.ArrayList;
import java.util.List;


public class InformationDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public InformationDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }
    /**
     * 添加活动信息
     * @Data
     * @param information
     */
    public void add(Information information)
    {
        //执行insert into information(information_id,information_user,information_userTelephon" +
        ////                        ",information_address,information_Area,information_Type,information_Stytle) values (?,?,?,?,?,?,?
        values.put("information_user",information.getInformation_user());
        values.put("information_userTelephon",information.getInformation_userTelephon());
        values.put("information_address",information.getInformation_address());
        values.put("information_Area",information.getInformation_Area());
        values.put("information_Type",information.getInformation_Type());
        values.put("information_Stytle",information.getInformation_Stytle());
        db.insert("activity",null,values);
        db.close();

    }

    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(int id){
        //执行delete from  activity where activity_id
        db.delete("information","information_id=?",new String[]{id+""});
        db.close();
    }

    /**
     * 更新活动信息
     *
     * @param information
     */
    public void update(Information information) {

        values.put("information_user",information.getInformation_user());
        values.put("information_userTelephon",information.getInformation_userTelephon());
        values.put("information_address",information.getInformation_address());
        values.put("information_Area",information.getInformation_Area());
        values.put("information_Type",information.getInformation_Type());
        values.put("information_Stytle",information.getInformation_Stytle());
        db.update("information",values,"information_id="+information.getInformation_id(),null);
        db.close();
    }
    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Information> getAll(){
        //执行select * from activity
        List<Information> list = new ArrayList<Information>();
        Cursor cursor = db.query("information",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int information_id = cursor.getInt(0);
            String information_user = cursor.getString(1);
            String information_userTelephon = cursor.getString(2);
            String information_address = cursor.getString(3);
            String information_Area = cursor.getString(4);
            String information_Type = cursor.getString(5);
            String information_Stytle = cursor.getString(6);
            list.add(new Information(information_id,information_user,information_userTelephon,information_address,
                    information_Area,information_Type,information_Stytle));
        }
        cursor.close();
        db.close();
        return  list;
    }
    /**
     * 根据ID查找
     * @param id
     * @return
     */

    public Information find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select information_user,information_userTelephon" +
                        ",information_address,information_Area,information_Type,information_Stytle" +
                        "from information where information_id ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Activity类中
            return new Information(
                    cursor.getInt(cursor.getColumnIndex("information_id")),
                    cursor.getString(cursor.getColumnIndex("information_user")),
                    cursor.getString(cursor.getColumnIndex("information_userTelephon")),
                    cursor.getString(cursor.getColumnIndex("information_address")),
                    cursor.getDouble(cursor.getColumnIndex("information_Area")),
                    cursor.getString(cursor.getColumnIndex("information_Type")),
                    cursor.getString(cursor.getColumnIndex("information_Stytle")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }

    /**
     * 获得总信息数
     * @return
     */
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(information_id) from information", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}

