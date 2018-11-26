package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Administrator;

import java.util.ArrayList;
import java.util.List;


public class AdministratorDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public AdministratorDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }

    /**
     * 添加管理员
     * @param administrator
     */
    public void add(Administrator administrator)
    {
        //执行insert into administrator(administrator_id,administrator_name,administrator_password" +
        ////                        ",administrator_telephone) values (?,?,?,?)"
        values.put("activity_name",administrator.getAdministrator_name());
        values.put("activity_StartTime",administrator.getAdministrator_password());
        values.put("activity_StartTime",administrator.getAdministrator_telephone());

        db.insert("administrator",null,values);
        db.close();
    }

    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(int id){
        //执行delete from  administrator where administrator_id
        db.delete("administrator","administrator_id=?",new String[]{id+""});
        db.close();
    }

    /**
     * 更新管理员信息
     *
     * @param administrator
     */

    public void update(Administrator administrator) {

        //执行"update administrator set administrator_name=?,administrator_password=?,administrator_telephone=?" +
        //" where administrator_id = ?",
        values.put("activity_name",administrator.getAdministrator_name());
        values.put("activity_StartTime",administrator.getAdministrator_password());
        values.put("activity_StartTime",administrator.getAdministrator_telephone());
        db.update("activity",values,"activity_id="+administrator.getAdministrator_id(),null);
        db.close();
    }
//    public void update(Administrator administrator) {
////		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
//        // 执行修改支出信息操作
//        db.execSQL(
//                "update administrator set administrator_name=?,administrator_password=?,administrator_telephone=?" +
//                        " where administrator_id = ?",
//                new Object[] {administrator.getAdministrator_name(),administrator.getAdministrator_password(),
//                           administrator.getAdministrator_telephone(),administrator.getAdministrator_id()});
//    }
    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Administrator> getAll(){
        //执行select * from activity
        List<Administrator> list = new ArrayList<Administrator>();
        Cursor cursor = db.query("administrator",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int administrator_id = cursor.getInt(0);
            String administrator_name = cursor.getString(1);
            String administrator_password = cursor.getString(2);
            String administrator_telephone = cursor.getString(3);

            list.add(new Administrator(administrator_id,administrator_name ,administrator_password,administrator_telephone));
        }
        cursor.close();
        db.close();
        return  list;
    }
    /**
     * 查找管理员信息
     *
     * @return
     */
    public Administrator find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select administrator_name,administrator_password,administrator_telephone" +
                        "from administrator where administrator_id=? ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Activity类中
            return new Administrator(
                    cursor.getInt(cursor.getColumnIndex("administrator_id")),
                    cursor.getString(cursor.getColumnIndex("administrator_name")),
                    cursor.getString(cursor.getColumnIndex("administrator_password")),
                    cursor.getString(cursor.getColumnIndex("administrator_telephone")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }

    /**
     * 获得管理员总数
     * @return
     */
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(administrator_id) from administrator", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}

