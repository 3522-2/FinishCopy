package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ActivityDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public ActivityDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }


    /**
     * 添加活动信息
     * @Data
     * @param activity
     */
   public void add(Activity activity)
   {
       //执行nsert into activity(activity_id,activity_name,activity_StartTime" +
       //           ",activity_FinishTime,activity_people,activity_content) values (?,?,?,?,?,?)"
       values.put("activity_name",activity.getActivity_name());
       values.put("activity_StartTime",activity.getActivity_StartTime());
       values.put("activity_StartTime",activity.getActivity_FinishTime());
       values.put("activity_people",activity.getActivity_people());
       values.put("activity_content",activity.getActivity_content());
       db.insert("activity",null,values);
       db.close();

   }

    /**
     * 根据id删除一条纪录
     * @param id
     */
       public void deleteById(int id){
       //执行delete from  activity where activity_id
           db.delete("activity","activity_id=?",new String[]{id+""});
           db.close();
       }
    /**
     * 更新活动信息
     *
     * @param activity
     */
    public void update(Activity activity) {

        //执行update activity set activity_name = ?,activity_StartTime = ?,
        // ctivity_FinishTime = ?,activity_people = ?,activity_content=? where activity_id = ? where activity_id=?
        values.put("activity_name",activity.getActivity_name());
        values.put("activity_StartTime",activity.getActivity_StartTime());
        values.put("activity_StartTime",activity.getActivity_FinishTime());
        values.put("activity_people",activity.getActivity_people());
        values.put("activity_content",activity.getActivity_content());
        db.update("activity",values,"activity_id="+activity.getActivity_id(),null);
        db.close();
    }

    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Activity> getAll(){
        //执行select * from activity
        List<Activity> list = new ArrayList<Activity>();
        Cursor cursor = db.query("activity",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int activity_id = cursor.getInt(0);
            String activity_name = cursor.getString(1);
            String activity_StartTime = cursor.getString(2);
            String activity_FinishTime = cursor.getString(3);
            String activity_people = cursor.getString(4);
            String activity_content = cursor.getString(5);
            list.add(new Activity(activity_id,activity_name ,activity_StartTime,activity_FinishTime,
                    activity_people,activity_content));
        }
        cursor.close();
        db.close();
        return  list;
    }

    /**
     * 根据id查找活动信息
     *
     * @return
     */
    public Activity find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select activity_name ,activity_StartTime,activity_FinishTime,activity_people,activity_content" +
                        "from activity where activity_id=? ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Activity类中
            return new Activity(
                    cursor.getInt(cursor.getColumnIndex("activity_id")),
                    cursor.getDouble(cursor.getColumnIndex("activity_name")),
                    cursor.getString(cursor.getColumnIndex("activity_StartTime")),
                    cursor.getString(cursor.getColumnIndex("activity_FinishTime"))
            );
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }

    /**
     * 获得总活动数
     * @return
     */
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(activity_id) from activity", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}
