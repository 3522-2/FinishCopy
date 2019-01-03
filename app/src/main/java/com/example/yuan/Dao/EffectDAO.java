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
        values.put("effect_keting",effect.getEffect_keting());
        values.put("effect_woshi",effect.getEffect_woshi());
        values.put("effect_shufang",effect.getEffect_shufang());
        values.put("effect_canting",effect.getEffect_canting());
        values.put("effect_weishengjian",effect.getEffect_weishengjian());
        values.put("effect_qita",effect.getEffect_qita());
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
    public void deleteById(String id){
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
        values.put("effect_keting",effect.getEffect_keting());
        values.put("effect_woshi",effect.getEffect_woshi());
        values.put("effect_shufang",effect.getEffect_shufang());
        values.put("effect_canting",effect.getEffect_canting());
        values.put("effect_weishengjian",effect.getEffect_weishengjian());
        values.put("effect_qita",effect.getEffect_qita());
        values.put("effect_PriceOne",effect.getEffect_PriceOne());
        values.put("effect_PriceTwo",effect.getEffect_PriceTwo());
        values.put("effect_PriceThree",effect.getEffect_PriceThree());
        values.put("effect_PriceFour",effect.getEffect_PriceFour());
        values.put("effect_PriceFive",effect.getEffect_PriceFive());
        values.put("effect_PriceSum",effect.getEffect_PriceSum());

        db.update("effect",values,"effect_id="+effect.getEffect_id(),null);
        db.close();
    }
    public void addKeting(Effect effect,String name) {
        db.execSQL("update effect set effect_keting=? where effect_name=?",
                new Object[]{effect.getEffect_keting(),name});
    }
    public void addwoshi(Effect effect,String name) {
        db.execSQL("update effect set effect_woshi=? where effect_name=?",
                new Object[]{effect.getEffect_woshi(),name});
    }

    public void addshufang(Effect effect,String name) {
        db.execSQL("update effect set effect_shufang=? where effect_name=?",
                new Object[]{effect.getEffect_shufang(),name});
    }
    public void addcanting(Effect effect,String name) {
        db.execSQL("update effect set effect_canting=? where effect_name=?",
                new Object[]{effect.getEffect_canting(),name});
    }
    public void addweishengjian(Effect effect,String name) {
        db.execSQL("update effect set effect_weishengjian=? where effect_name=?",
                new Object[]{effect.getEffect_weishengjian(),name});
    }
    public void addqita(Effect effect,String name) {
        db.execSQL("update effect set effect_qita=? where effect_name=?",
                new Object[]{effect.getEffect_qita(),name});
    }
    public void addDes(Effect effect,String name) {
        db.execSQL("update effect set effect_ketingDes=?,effect_woshiDes=?,effect_shufangDes=?," +
                        "effect_cantingDes=? ,effect_weishengjianDes=?,effect_qitaDes=? where effect_name=?",
                new Object[]{effect.getEffect_ketingDes(),effect.getEffect_woshiDes(),effect.getEffect_shufangDes(),
                       effect.getEffect_cantingDes(),effect.getEffect_weishengjianDes(), effect.getEffect_qitaDes(),name});
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
            String effect_keting = cursor.getString(5);
            String effect_woshi = cursor.getString(6);
            String effect_shufang = cursor.getString(7);
            String effect_canting = cursor.getString(8);
            String effect_weishengjian = cursor.getString(9);
            String effect_qita = cursor.getString(10);
            String effect_recommand = cursor.getString(11);
            String effect_UserSee = cursor.getString(12);
            String effect_PriceOne = cursor.getString(13);
            String effect_PriceTwo = cursor.getString(14);
            String effect_PriceThree = cursor.getString(15);
            String effect_PriceFour = cursor.getString(16);
            String effect_PriceFive = cursor.getString(17);
            String effect_PriceSum = cursor.getString(18);
            String effect_ketingDes = cursor.getString(19);
            String effect_woshiDes = cursor.getString(20);
            String effect_shufangDes = cursor.getString(21);
            String effect_cantingDes = cursor.getString(22);
            String effect_weishengjianDes = cursor.getString(23);
            String effect_qitaDes = cursor.getString(24);
            list.add(new Effect(effect_id,effect_name,effect_stytle,effect_area,effect_type,
                    effect_keting,effect_woshi,effect_shufang,effect_canting,effect_weishengjian,effect_qita,
                    effect_recommand,effect_UserSee,effect_PriceOne,effect_PriceTwo,effect_PriceThree,
                    effect_PriceFour,effect_PriceFive,effect_PriceSum,
                    effect_ketingDes,effect_woshiDes,effect_shufangDes,effect_cantingDes,effect_weishengjianDes,effect_qitaDes));
        }
        cursor.close();
        db.close();
        return  list;
    }

    /**
     * 根据id查找效果图信息
     *
     * @return
     * @param id
     */
    public Effect find(String id) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select * from effect where effect_id=? ",
                new String[] {id});// 根据编号查找支出信息，并存储到Cursor类中
        // 遍历查找到的支出信息
// 将遍历到的支出信息存储到Activity类中
        if (cursor.moveToNext()) {
            return new Effect( cursor.getInt(cursor.getColumnIndex("effect_id")),
                    cursor.getString(cursor.getColumnIndex("effect_name")),
                    cursor.getString(cursor.getColumnIndex("effect_stytle")),
                    cursor.getString(cursor.getColumnIndex("effect_area")),
                    cursor.getString(cursor.getColumnIndex("effect_type")),
                    cursor.getString(cursor.getColumnIndex("effect_keting")),
                    cursor.getString(cursor.getColumnIndex("effect_woshi")),
                    cursor.getString(cursor.getColumnIndex("effect_shufang")),
                    cursor.getString(cursor.getColumnIndex("effect_canting")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjian")),
                    cursor.getString(cursor.getColumnIndex("effect_qita")),
                    cursor.getString(cursor.getColumnIndex("effect_ketingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_woshiDes")),
                    cursor.getString(cursor.getColumnIndex("effect_shufangDes")),
                    cursor.getString(cursor.getColumnIndex("effect_cantingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjianDes")),
                    cursor.getString(cursor.getColumnIndex("effect_qitaDes")),
                    cursor.getString(cursor.getColumnIndex("effect_recommand")),
                    cursor.getString(cursor.getColumnIndex("effect_UserSee")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceOne")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceTwo")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceThree")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFour")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFive")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceSum")));
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
    public List<Effect> getScrollData(int start, int count) {

        List<Effect> effects = new ArrayList<Effect>();// 创建集合对象
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        // 获取所有收入信息
        Cursor cursor = db.rawQuery("select * from effect limit ? , ?",//limit表示范围
                new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()){// 遍历所有的收入信息
            // 将遍历到的收入信息添加到集合中
            effects.add(new Effect( cursor.getInt(cursor.getColumnIndex("effect_id")),
                    cursor.getString(cursor.getColumnIndex("effect_name")),
                    cursor.getString(cursor.getColumnIndex("effect_stytle")),
                    cursor.getString(cursor.getColumnIndex("effect_area")),
                    cursor.getString(cursor.getColumnIndex("effect_type")),
                    cursor.getString(cursor.getColumnIndex("effect_keting")),
                    cursor.getString(cursor.getColumnIndex("effect_woshi")),
                    cursor.getString(cursor.getColumnIndex("effect_shufang")),
                    cursor.getString(cursor.getColumnIndex("effect_canting")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjian")),
                    cursor.getString(cursor.getColumnIndex("effect_qita")),
                    cursor.getString(cursor.getColumnIndex("effect_ketingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_woshiDes")),
                    cursor.getString(cursor.getColumnIndex("effect_shufangDes")),
                    cursor.getString(cursor.getColumnIndex("effect_cantingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjianDes")),
                    cursor.getString(cursor.getColumnIndex("effect_qitaDes")),
                    cursor.getString(cursor.getColumnIndex("effect_recommand")),
                    cursor.getString(cursor.getColumnIndex("effect_UserSee")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceOne")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceTwo")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceThree")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFour")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFive")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceSum"))));

        }
        cursor.close();// 关闭游标
        return effects;// 返回集合
    }

    //验证是否有查询结果
    public boolean check(String fengge,String huxing,String mianji) {
        String sql = "select * from effect where effect_stytle=? and effect_type=? and effect_area=?";
        Cursor cursor = db.rawQuery(sql, new String[] {fengge, huxing,mianji});//游标
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
    public Effect find1(String fengge,String huxing,String mianji) {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select * from effect where  effect_stytle=? and effect_type=? and effect_area=?",
                new String[] {fengge, huxing,mianji});// 根据编号查找支出信息，并存储到Cursor类中
        // 遍历查找到的支出信息
// 将遍历到的支出信息存储到Activity类中
        if (cursor.moveToNext()) {
            return new Effect( cursor.getInt(cursor.getColumnIndex("effect_id")),
                    cursor.getString(cursor.getColumnIndex("effect_name")),
                    cursor.getString(cursor.getColumnIndex("effect_stytle")),
                    cursor.getString(cursor.getColumnIndex("effect_area")),
                    cursor.getString(cursor.getColumnIndex("effect_type")),
                    cursor.getString(cursor.getColumnIndex("effect_keting")),
                    cursor.getString(cursor.getColumnIndex("effect_woshi")),
                    cursor.getString(cursor.getColumnIndex("effect_shufang")),
                    cursor.getString(cursor.getColumnIndex("effect_canting")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjian")),
                    cursor.getString(cursor.getColumnIndex("effect_qita")),
                    cursor.getString(cursor.getColumnIndex("effect_ketingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_woshiDes")),
                    cursor.getString(cursor.getColumnIndex("effect_shufangDes")),
                    cursor.getString(cursor.getColumnIndex("effect_cantingDes")),
                    cursor.getString(cursor.getColumnIndex("effect_weishengjianDes")),
                    cursor.getString(cursor.getColumnIndex("effect_qitaDes")),
                    cursor.getString(cursor.getColumnIndex("effect_recommand")),
                    cursor.getString(cursor.getColumnIndex("effect_UserSee")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceOne")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceTwo")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceThree")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFour")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceFive")),
                    cursor.getString(cursor.getColumnIndex("effect_PriceSum")));
        }
        cursor.close();// 关闭游标
        return null;// 如果没有信息，则返回null
    }
}