package com.example.yuan.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yuan.modle.Effect;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class EffectDAO {
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象
    private ContentValues values;

    public EffectDAO(Context context) {// 定义构造函数
        helper = new DBOpenHelper(context,1);// 初始化DBOpenHelper对象
        db = helper.getReadableDatabase();// 初始化SQLiteDatabase对象
        values = new ContentValues();
    }

    /**
     * 添加效果图信息
     * @param effect
     */

    public void add(Effect effect){
        //执行insert into communction(effect_id,effect_name,effect_stytle" +
        ////                        ",effect_area,effect_type,effect_describe,effect_photo,effect_recommand" +
        ////                        ",effect_UserSee,effect_PriceOne,effect_PriceTwo,effect_PriceThree," +
        ////                        "effect_PriceFour,effect_PriceFive,effect_PriceSum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
        values.put("effect_name",effect.getEffect_name());
        values.put("effect_stytle",effect.getEffect_stytle());
        values.put("effect_area",effect.getEffect_area());
        values.put("effect_type",effect.getEffect_type());
        values.put("effect_photo",effect.getEffect_photo());
        values.put("effect_recommand",effect.getEffect_recommand());
        values.put("effect_PriceOne",effect.getEffect_PriceOne());
        values.put("effect_PriceTwo",effect.getEffect_PriceTwo());
        values.put("effect_PriceThree",effect.getEffect_PriceThree());
        values.put("effect_PriceFour",effect.getEffect_PriceFour());
        values.put("effect_PriceFive",effect.getEffect_PriceFive());
        values.put("effect_PriceSum",effect.getEffect_PriceSum());
        db.insert("effect",null,values);
        db.close();

    }
//    public void add(Effect effect) {
//        // 执行添加消息操作
//        db.execSQL("insert into communction(effect_id,effect_name,effect_stytle" +
//                        ",effect_area,effect_type,effect_describe,effect_photo,effect_recommand" +
//                        ",effect_UserSee,effect_PriceOne,effect_PriceTwo,effect_PriceThree," +
//                        "effect_PriceFour,effect_PriceFive,effect_PriceSum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
//                new Object[]{effect.getEffect_id(), effect.getEffect_name(), effect.getEffect_stytle(),
//                effect.getEffect_area(),effect.getEffect_type(),effect.getEffect_describe(),effect.getEffect_photo(),effect.getEffect_recommand(),
//                effect.getEffect_UserSee(),effect.getEffect_PriceOne(),effect.getEffect_PriceTwo(),effect.getEffect_PriceThree(),
//                        effect.getEffect_PriceFour(),effect.getEffect_PriceFive()});
//    }
    /**
     * 根据id删除一条纪录
     * @param id
     */
    public void deleteById(int id){
        //执行delete from  activity where activity_id
        db.delete("effect","effect_id=?",new String[]{id+""});
        db.close();
    }
    /**
     * 更新效果图信息
     *
     * @param effect
     */
    public void update(Effect effect) {

        //执行update activity set activity_name = ?,activity_StartTime = ?,
        // ctivity_FinishTime = ?,activity_people = ?,activity_content=? where activity_id = ? where activity_id=?
        values.put("effect_name",effect.getEffect_name());
        values.put("effect_stytle",effect.getEffect_stytle());
        values.put("effect_area",effect.getEffect_area());
        values.put("effect_type",effect.getEffect_type());
        values.put("effect_photo",effect.getEffect_photo());
        values.put("effect_recommand",effect.getEffect_recommand());
        values.put("effect_PriceOne",effect.getEffect_PriceOne());
        values.put("effect_PriceTwo",effect.getEffect_PriceTwo());
        values.put("effect_PriceThree",effect.getEffect_PriceThree());
        values.put("effect_PriceFour",effect.getEffect_PriceFour());
        values.put("effect_PriceFive",effect.getEffect_PriceFive());
        values.put("effect_PriceSum",effect.getEffect_PriceSum());
        db.update("effect",values,"effect_id="+effect.getEffect_id(),null);
        db.close();
    }

//    public void update(Effect effect){
//        //执行更新操作
//        db.execSQL("update effect set effect_name=?,effect_stytle=?,effect_area=?,effect_type=?" +
//                ",effect_describe=?,effect_photo=?,effect_recommand=?,effect_UserSee=?," +
//                "effect_PriceOne=?,effect_PriceTwo=?,effect_PriceThree=?,effect_PriceFour=?," +
//                "effect_PriceFive=?,effect_PriceSum=? where effect_id=?",
//        new Object[]{effect.getEffect_name(),effect.getEffect_stytle(),effect.getEffect_area(),effect.getEffect_type(),
//        effect.getEffect_describe(),effect.getEffect_photo(),effect.getEffect_recommand(),effect.getEffect_UserSee(),
//        effect.getEffect_PriceOne(),effect.getEffect_PriceTwo(),effect.getEffect_PriceThree(),effect.getEffect_PriceFour(),
//                effect.getEffect_PriceFive(),effect.getEffect_PriceSum(),});
//    }
    /**
     * 查询所有记录封装成List<Activity></>
     * @return
     */
    public List<Effect> getAll(){
        //执行select * from effect
        List<Effect> list = new ArrayList<Effect>();
        Cursor cursor = db.query("effect",null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            int effect_id = cursor.getInt(0);
            String effect_name = cursor.getString(1);
            String effect_stytle = cursor.getString(2);
            String effect_area = cursor.getString(3);
            String effect_type = cursor.getString(4);
            String effect_describe = cursor.getString(5);
            byte[] effect_photo = cursor.getBlob(6);
            String effect_recommand = cursor.getString(7);
            String effect_UserSee = cursor.getString(8);
            String effect_PriceOne = cursor.getString(9);
            String effect_PriceTwo = cursor.getString(10);
            String effect_PriceThree = cursor.getString(11);
            String effect_PriceFour = cursor.getString(12);
            String effect_PriceFive = cursor.getString(13);
            String effect_PriceSum = cursor.getString(14);
            list.add(new Effect(effect_id,effect_name,effect_stytle,effect_area,effect_type,effect_describe,
                    effect_photo,effect_recommand,effect_UserSee,effect_PriceOne,effect_PriceTwo,effect_PriceThree,
                    effect_PriceFour,effect_PriceFive,effect_PriceSum));
        }
        cursor.close();
        db.close();
        return  list;
    }

    /**
     * 根据id查找效果图信息
     *
     * @return
     */
    public Effect find(int id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery(
                "select effect_name,effect_stytle,effect_area," +
                        "effect_type,effect_describe,effect_photo," +
                        "effect_recommand,effect_UserSee,effect_PriceOne," +
                        "effect_PriceTwo,effect_PriceThree,effect_PriceFour,effect_PriceFive,effect_PriceSum" +
                        "from eccect where effect_id=? ",
                new String[] { String.valueOf(id) });// 根据编号查找支出信息，并存储到Cursor类中
        // 遍历查找到的支出信息
// 将遍历到的支出信息存储到Activity类中
        if (cursor.moveToNext()) {
            return new Effect(
                    cursor.getInt(cursor.getColumnIndex("effect_id")),
                    cursor.getString(cursor.getColumnIndex("effect_name")),
                    cursor.getString(cursor.getColumnIndex("effect_stytle")),
                    cursor.getDouble(cursor.getColumnIndex("effect_area")),
                    cursor.getString(cursor.getColumnIndex("effect_type")),
                    cursor.getString(cursor.getColumnIndex("effect_describe")),
                    cursor.getBlob(cursor.getColumnIndex("effect_photo")),
                    cursor.getString(cursor.getColumnIndex("effect_recommand")),
                    cursor.getString(cursor.getColumnIndex("effect_UserSee")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceOne")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceTwo")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceThree")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceFour")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceFive")),
                    cursor.getDouble(cursor.getColumnIndex("effect_PriceSum")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }
    public long getCount() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(effect_id) from effect", null);// 获取活动信息的记录数
        if (cursor.moveToNext()){// 判断Cursor中是否有数据
            return cursor.getLong(0);// 返回总记录数
        }
        cursor.close();// 关闭游标
        return 0;// 如果没有数据，则返回0
    }
}