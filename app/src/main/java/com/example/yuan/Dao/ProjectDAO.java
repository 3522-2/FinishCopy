package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Project;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class ProjectDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public ProjectDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }
    /**
     * 添加工期
     * @param project
     */

    public void add(Project project)
    {

        values.put("project_StartTime",project.getProject_StartTime());
        values.put("project_FinishTime",project.getProject_FinishTime());
        values.put("proiect_photo",project.getProiect_photo());
        values.put("project_principle",project.getProject_principle());
        values.put("project_UserEvaluation",project.getProject_UserEvaluation());
        values.put("project_UserAcceptance",project.getProject_UserAcceptance());
        db.insert("activity",null,values);
        db.close();

    }

    /**
     *更新工期
     *
     * @param project
     */
    public void update(Project project) {
        values.put("project_StartTime",project.getProject_StartTime());
        values.put("project_FinishTime",project.getProject_FinishTime());
        values.put("proiect_photo",project.getProiect_photo());
        values.put("project_principle",project.getProject_principle());
        values.put("project_UserEvaluation",project.getProject_UserEvaluation());
        values.put("project_UserAcceptance",project.getProject_UserAcceptance());
        db.update("project",values,"project_id="+project.getProject_id(),null);
        db.close();
    }
    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(int id){
        //执行delete from  activity where activity_id
        db.delete("project","project_id=?",new String[]{id+""});
        db.close();
    }

    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Project> getAll(){
        //执行select * from activity
        List<Project> list = new ArrayList<Project>();
        Cursor cursor = db.query("activity",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int project_id = cursor.getInt(0);
            String project_StartTime = cursor.getString(1);
            String project_FinishTime = cursor.getString(2);
            String proiect_photo = cursor.getString(3);
            String project_principle = cursor.getString(4);
            String project_UserEvaluation = cursor.getString(5);
            String project_UserAcceptance = cursor.getString(6);
            String project_address = cursor.getString(7);
            list.add(new Project(project_id,project_StartTime,project_FinishTime,proiect_photo,project_principle,
                    project_UserEvaluation,project_UserAcceptance,project_address));
        }
        cursor.close();
        db.close();
        return  list;
    }
    /**
     * 根据id查找工期信息
     *
     * @return
     */
    public Project find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select project_StartTime,project_FinishTime,proiect_photo," +
                        "project_principle,project_UserEvaluation,project_UserAcceptance,project_address" +
                        "from project where project_id=? ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Activity类中
            return new Project(
                    cursor.getInt(cursor.getColumnIndex("project_id")),
                    cursor.getDouble(cursor.getColumnIndex("project_StartTime")),
                    cursor.getDouble(cursor.getColumnIndex("project_FinishTime")),
                    cursor.getBlob(cursor.getColumnIndex("proiect_photo")),
                    cursor.getString(cursor.getColumnIndex("project_principle")),
                    cursor.getString(cursor.getColumnIndex("project_UserEvaluation")),
                    cursor.getString(cursor.getColumnIndex("project_UserAcceptance")),
                    cursor.getString(cursor.getColumnIndex("project_address")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }

    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(project_id) from project", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}

