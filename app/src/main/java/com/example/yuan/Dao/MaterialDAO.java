package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Communction;
import com.example.yuan.modle.Material;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class MaterialDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public MaterialDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }

    /**
     * 添加活动信息
     * @Data
     * @param material
     */
    public void add(Material material)
    {
        //执行insert into material(material_id,material_name,gmaterial_type
        // ,material_price,material_provider,material_brand,material_photo) values (?,?,?,?,?,?,?)"
        values.put("material_name",material.getMaterial_name());
        values.put("material_type",material.getMaterial_type());
        values.put("material_price",material.getMaterial_price());
        values.put("material_provider",material.getMaterial_provider());
        values.put("material_brand",material.getMaterial_brand());
        values.put("material_photo",material.getMaterial_photo());
        db.insert("material",null,values);
        db.close();

    }
    public void addPhoto(Material material,String name) {
        db.execSQL("update material set material_photo=? where material_name=?",
                new Object[]{material.getMaterial_photo(),name});
    }
    public void addPhotoDes(Material material,String name) {
        db.execSQL("update material set material_photoDes=? where material_name=?",
                new Object[]{material.getMaterial_photoDes(),name});
    }
    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(String id){
        //执行delete from  activity where activity_id
        db.delete("material","material_id=?",new String[]{id+""});
        db.close();
    }
    /**
     * 更新材料信息
     *
     * @param material
     */
    public void update(Material material) {

        values.put("material_name",material.getMaterial_name());
        values.put("material_type",material.getMaterial_type());
        values.put("material_price",material.getMaterial_price());
        values.put("material_provider",material.getMaterial_provider());
        values.put("material_brand",material.getMaterial_brand());
        values.put("material_photo",material.getMaterial_photo());
        db.update("material",values,"material_id="+material.getMaterial_id(),null);
        db.close();
    }
    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Material> getAll(){
        //执行select * from activity
        List<Material> list = new ArrayList<Material>();
        Cursor cursor = db.query("material",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int material_id = cursor.getInt(0);
            String material_name = cursor.getString(1);
            String gmaterial_type = cursor.getString(2);
            String material_price = cursor.getString(3);
            String material_provider = cursor.getString(4);
            String material_brand = cursor.getString(5);
            String material_photoDes = cursor.getString(6);
            String material_photo = cursor.getString(7);

            list.add(new Material(material_id,material_name,gmaterial_type
                    ,material_price,material_provider,material_brand,material_photo,material_photoDes));
        }
        cursor.close();
        db.close();
        return  list;
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Material find(String id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select * from material where material_id =?",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        if (cursor.moveToNext()){// 遍历查找到的支出信息
            // 将遍历到的支出信息存储到Material类中
            return new Material(
                    cursor.getInt(cursor.getColumnIndex("material_id")),
                    cursor.getString(cursor.getColumnIndex("material_name")),
                    cursor.getString(cursor.getColumnIndex("material_type")),
                    cursor.getString(cursor.getColumnIndex("material_price")),
                    cursor.getString(cursor.getColumnIndex("material_provider")),
                    cursor.getString(cursor.getColumnIndex("material_brand")),
                    cursor.getString(cursor.getColumnIndex("material_photoDes")),
                    cursor.getString(cursor.getColumnIndex("material_photo")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }

    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(material_ID) from material", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
    public List<Material> getScrollData(int start, int count) {

        List<Material> materials = new ArrayList<Material>();// 创建集合对象
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        // 获取所有收入信息
        Cursor cursor = db.rawQuery("select * from material limit ? , ?",//limit表示范围
                new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()){// 遍历所有的收入信息
            // 将遍历到的收入信息添加到集合中
            materials.add(new Material( cursor.getInt(cursor.getColumnIndex("material_id")),
                    cursor.getString(cursor.getColumnIndex("material_name")),
                    cursor.getString(cursor.getColumnIndex("material_type")),
                    cursor.getString(cursor.getColumnIndex("material_price")),
                    cursor.getString(cursor.getColumnIndex("material_provider")),
                    cursor.getString(cursor.getColumnIndex("material_brand")),
                    cursor.getString(cursor.getColumnIndex("material_photoDes")),
                    cursor.getString(cursor.getColumnIndex("material_photo"))));

        }
        cursor.close();// 关闭游标
        return materials;// 返回集合
    }
}

