package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Scheme;

import java.util.ArrayList;
import java.util.List;


public class SchemeDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public SchemeDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }

    /**
     * 添加
     * @param scheme
     */

    public void add(Scheme scheme)
    {
        //insert into scheme(scheme_id,scheme_houseType,scheme_houseArea" +
        //",scheme_houseStyle,scheme_pirceOne,scheme_pirceTwoWork,scheme_pirceTwoMaterial,scheme_pirceThreeWork" +
        // ",scheme_pirceThreeMaterial,scheme_pirceFourWork,scheme_pirceFourMaterial,scheme_pirceFivework," +
        // scheme_pirceFiveMaterial,scheme_pirceSum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        values.put("scheme_houseType",scheme.getScheme_houseType());
        values.put("scheme_houseArea",scheme.getScheme_houseArea());
        values.put("scheme_houseStyle",scheme.getScheme_houseStyle());
        values.put("scheme_pirceOne",scheme.getScheme_pirceOne());
        values.put("scheme_pirceTwoWork",scheme.getScheme_pirceTwoWork());
        values.put("scheme_pirceTwoMaterial",scheme.getScheme_pirceTwoMaterial());
        values.put("scheme_pirceThreeWork",scheme.getScheme_pirceThreeWork());
        values.put("scheme_pirceThreeMaterial",scheme.getScheme_pirceThreeMaterial());
        values.put("scheme_pirceFourWork",scheme.getScheme_pirceFourWork());
        values.put("scheme_pirceFourMaterial",scheme.getScheme_pirceFourMaterial());
        values.put("scheme_pirceFivework",scheme.getScheme_pirceFivework());
        values.put("scheme_pirceFiveMaterial",scheme.getScheme_pirceFiveMaterial());
        values.put("scheme_pirceSum",scheme.getScheme_pirceSum());
        db.insert("scheme",null,values);
        db.close();

    }
    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(String id){
        db.delete("scheme","scheme_id=?",new String[]{id+""});

        db.close();
    }
    /**
     * 更新方案信息
     *
     * @param scheme
     */
    public void update(Scheme scheme) {
        values.put("scheme_houseType",scheme.getScheme_houseType());
        values.put("scheme_houseArea",scheme.getScheme_houseArea());
        values.put("scheme_houseStyle",scheme.getScheme_houseStyle());
        values.put("scheme_pirceOne",scheme.getScheme_pirceOne());
        values.put("scheme_pirceTwoWork",scheme.getScheme_pirceTwoWork());
        values.put("scheme_pirceTwoMaterial",scheme.getScheme_pirceTwoMaterial());
        values.put("scheme_pirceThreeWork",scheme.getScheme_pirceThreeWork());
        values.put("scheme_pirceThreeMaterial",scheme.getScheme_pirceThreeMaterial());
        values.put("scheme_pirceFourWork",scheme.getScheme_pirceFourWork());
        values.put("scheme_pirceFourMaterial",scheme.getScheme_pirceFourMaterial());
        values.put("scheme_pirceFivework",scheme.getScheme_pirceFivework());
        values.put("scheme_pirceFiveMaterial",scheme.getScheme_pirceFiveMaterial());
        values.put("scheme_pirceSum",scheme.getScheme_pirceSum());
        db.update("scheme",values,"scheme_id="+scheme.getScheme_id(),null);
        db.close();

    }

    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Scheme> getAll(){
        //执行select * from activity
        List<Scheme> list = new ArrayList<Scheme>();
        Cursor cursor = db.query("scheme",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            String scheme_id = cursor.getString(0);
            String scheme_houseType = cursor.getString(1);
            String scheme_houseArea = cursor.getString(2);
            String scheme_houseStyle = cursor.getString(3);
            String scheme_pirceOne = cursor.getString(4);
            String scheme_pirceTwoWork = cursor.getString(5);
            String scheme_pirceTwoMaterial = cursor.getString(6);
            String scheme_pirceThreeWork = cursor.getString(7);
            String scheme_pirceThreeMaterial = cursor.getString(8);
            String scheme_pirceFourWork = cursor.getString(9);
            String scheme_pirceFourMaterial = cursor.getString(10);
            String scheme_pirceFivework = cursor.getString(11);
            String scheme_pirceFiveMaterial = cursor.getString(12);
            String scheme_pirceSum = cursor.getString(13);
            list.add(new Scheme(scheme_id,scheme_houseType,scheme_houseArea
                    ,scheme_houseStyle,scheme_pirceOne,scheme_pirceTwoWork,scheme_pirceTwoMaterial,scheme_pirceThreeWork,
                    scheme_pirceThreeMaterial,scheme_pirceFourWork,scheme_pirceFourMaterial,scheme_pirceFivework,
                    scheme_pirceFiveMaterial,scheme_pirceSum));
        }
        cursor.close();
        db.close();
        return  list;
    }
    /**
     * 根据id查找方案信息
     *
     * @return
     * @param id
     */
    public  Scheme find(String id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select * from scheme where scheme_id=? ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Activity类中
            return new Scheme(cursor.getString(cursor.getColumnIndex("scheme_id")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseType")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseArea")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseStyle")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceOne")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceTwoWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceTwoMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceThreeWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceThreeMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFourWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFourMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFivework")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFiveMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceSum")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(scheme_id) from scheme", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }

    public List<Scheme> getScrollData(int start, int count) {

        List<Scheme> scheme = new ArrayList<Scheme>();// 创建集合对象
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        // 获取所有收入信息
        Cursor cursor = db.rawQuery("select * from scheme limit ? , ?",//limit表示范围
                new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()){// 遍历所有的收入信息
            // 将遍历到的收入信息添加到集合中
            scheme.add(new Scheme(cursor.getString(cursor.getColumnIndex("scheme_id")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseArea")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseStyle")),
                    cursor.getString(cursor.getColumnIndex("scheme_houseType")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceOne")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceTwoWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceTwoMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceThreeWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceThreeMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFourWork")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFourMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFivework")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceFiveMaterial")),
                    cursor.getString(cursor.getColumnIndex("scheme_pirceSum"))));

        }
        cursor.close();// 关闭游标
        return scheme;// 返回集合
    }
    /**
     * 获取收入最大编号
     *
     * @return
     */
    public String getMaxId() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(scheme_id) from scheme", null);// 获取收入信息表中的最大编号
        while (cursor.moveToLast()) {// 访问Cursor中的最后一条数据
            return cursor.getString(0);// 获取访问到的数据，即最大编号
        }
        cursor.close();// 关闭游标
        return "wu";
    }
}

