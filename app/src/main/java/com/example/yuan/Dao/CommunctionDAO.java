package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Communction;

import java.util.ArrayList;
import java.util.List;


public class CommunctionDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public CommunctionDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }
    /**
     * 添加活动信息
     * @Data
     * @param communction
     */
    public void add(Communction communction)
    {
        //执行insert into communction(communction_user,communction_head,communction_id" +
        //                        ",communctions,communction_isAccept,communction_time) values (?,?,?,?,?,?)
        values.put("communction_user",communction.getCommunction_user());
        values.put("communction_head",communction.getCommunction_head());
        values.put("communctions",communction.getCommunctions());
        values.put("communction_isAccept",communction.isCommunction_isAccept());
        values.put("communction_time", communction.getCommunction_time());
        db.insert("activity",null,values);
        db.close();

    }
    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(int id){
        //执行delete from  activity where activity_id
        db.delete("communction","communction_id=?",new String[]{id+""});
        db.close();
    }

    /**
     * 更新活动信息
     *
     * @param communction
     */
    public void update(Communction communction) {
        values.put("communction_user",communction.getCommunction_user());
        values.put("communction_head",communction.getCommunction_head());
        values.put("communctions",communction.getCommunctions());
        values.put("communction_isAccept",communction.isCommunction_isAccept());
        values.put("communction_time", communction.getCommunction_time());
        db.update("activity",values,"activity_id="+communction.getCommunction_id(),null);
        db.close();
    }

    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Communction> getAll(){
        //执行select * from activity
        List<Communction> list = new ArrayList<Communction>();
        Cursor cursor = db.query("Communction",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int communction_id = cursor.getInt(0);
            String communction_user = cursor.getString(1);
            String communction_head = cursor.getString(2);
            String communctions = cursor.getString(3);
            String communction_isAccept = cursor.getString(4);
            String communction_time = cursor.getString(5);
            list.add(new Communction(communction_id,communction_user ,communction_head,communctions,
                    communction_isAccept,communction_time));
        }
        cursor.close();
        db.close();
        return  list;
    }
//    /**
//     * 查找管理员信息
//     *
//     * @return
//     */
//    public Communction find(int id) {
////		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
//        Cursor cursor = db.rawQuery(
//                "select communction_user,communction_head,communctions,communction_isAccept,communction_time" +
//                        "from communction where communction_id=? ",
//                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
//        if (cursor.moveToNext()){// 遍历查找到的支出信息
//            // 将遍历到的支出信息存储到Activity类中
//            return new Communction(
//                    cursor.getInt(cursor.getColumnIndex("communction_id")),
//                    cursor.getString(cursor.getColumnIndex("communction_user")),
//                    cursor.getString(cursor.getColumnIndex("communction_head")),
//                    cursor.getString(cursor.getColumnIndex("communction_isAccept")),
//                    cursor.getString(cursor.getColumnIndex("communction_time")),
//                    cursor.getString(cursor.getColumnIndex("communctions")));
//        }
//        cursor.close();// 关闭游标
//        return null;// 如果没有信息，则返回null
//    }

    /**
     *获得消息总数
     * @return
     */
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(communction_id) from communction", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}