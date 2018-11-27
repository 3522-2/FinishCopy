package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.User;

import java.util.ArrayList;
import java.util.List;


public class UserDAO {

        private DBOpenHelper helper;// 创建DBOpenHelper对象
        private SQLiteDatabase db;// 创建SQLiteDatabase对象
        ContentValues values;

        public UserDAO(Context context) {// 定义构造函数
            helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
            db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
            values = new ContentValues();
        }
        /**
         * 添加用户信息
         * @Data
         * @param user
         */
        public void add(User user)
        {
            //执行insert into user(user_id,user_name,user_password" +
            //",user_telephone,user_adr,user_houseType,user_houseArea) values (?,?,?,?,?,?,?)"
            values.put("user_name",user.getUser_name());
            values.put("user_password",user.getUser_password());
            values.put("user_telephone",user.getUser_telephone());
            values.put("user_adr",user.getUser_adr());
            values.put("user_houseType",user.getUser_houseType());
            values.put("user_houseArea",user.getUser_houseArea());
            db.insert("user",null,values);
            db.close();

        }

        /**
         * 根据id删除一条纪录
         * @param id
         */
        public void deleteById(int id){
            //执行delete from  activity where activity_id
            db.delete("user","user_id=?",new String[]{id+""});
            db.close();
        }
        /**
         * @param user
         */
        /**
         * 更新活动信息
         *
         * @param user
         */
        public void update(User user) {

            //执行update activity set activity_name = ?,activity_StartTime = ?,
            // ctivity_FinishTime = ?,activity_people = ?,activity_content=? where activity_id = ? where activity_id=?
            values.put("user_name",user.getUser_name());
            values.put("user_password",user.getUser_password());
            values.put("user_telephone",user.getUser_telephone());
            values.put("user_adr",user.getUser_adr());
            values.put("user_houseType",user.getUser_houseType());
            values.put("user_houseArea",user.getUser_houseArea());
            db.update("user",values,"activity_id="+user.getUser_id(),null);
            db.close();
        }

        /**
         * 查询所有记录封装成List<Activity></>
         * @return
         */
        public List<User> getAll(){
            //执行select * from activity
            List<User> list = new ArrayList<User>();
            Cursor cursor = db.query("activity",null,null,null,
                    null,null,null);
            while (cursor.moveToNext()){
                int user_id = cursor.getInt(0);
                String user_name = cursor.getString(1);
                String user_password = cursor.getString(2);
                String user_telephone = cursor.getString(3);
                String user_adr = cursor.getString(4);
                String user_houseType = cursor.getString(5);
                String user_houseArea = cursor.getString(6);
                list.add(new User(user_id,user_name,user_password,
                        user_telephone,user_adr,user_houseType,user_houseArea));
            }
            cursor.close();
            db.close();
            return  list;
        }
        /**
         * 根据查找管理员信息
         *
         * @return
         */
        public User find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
            Cursor cursor = db.rawQuery(
                    "select user_name,user_password,user_telephone,user_adr,user_houseType,user_houseArea" +
                            "from user where user_id=? ",
                    new String[]{String.valueOf(id)});// 根据编号查找支出信息，并存储到Cursor类中
            if (cursor.moveToNext()) {// 遍历查找到的支出信息
                // 将遍历到的支出信息存储到Activity类中
                return new User(
                        cursor.getInt(cursor.getColumnIndex("user_id")),
                        cursor.getString(cursor.getColumnIndex("user_name")),
                        cursor.getString(cursor.getColumnIndex("user_password")),
                        cursor.getString(cursor.getColumnIndex("user_telephone")),
                        cursor.getString(cursor.getColumnIndex("user_adr")),
                        cursor.getString(cursor.getColumnIndex("user_houseType")),
                        cursor.getString(cursor.getColumnIndex("user_houseArea")));
            }
            cursor.close();// 关闭游标
            return null;// 如果没有信息，则返回null
        }


        public boolean CheckIsDataAlreadyInDBorNot(String value) {
            String Query = "Select * from user where user_name =?";
            Cursor cursor = db.rawQuery(Query, new String[]{value});
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
            cursor.close();
            return false;
        }

        public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
            Cursor cursor = db.rawQuery("select count(user_id) from user", null);// 获取活动信息的记录数
            if (cursor.moveToNext()) {// 判断Cursor中是否有数据
                return cursor.getLong(0);// 返回总记录数
            }
            cursor.close();// 关闭游标
            return 0;// 如果没有数据，则返回0
        }
    }


