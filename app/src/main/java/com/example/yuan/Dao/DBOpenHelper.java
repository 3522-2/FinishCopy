package com.example.yuan.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;


public class DBOpenHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;// 定义数据库版本号
    private static final String DBNAME = "test.db";// 定义数据库名

    public DBOpenHelper(Context context) {// 定义构造函数

        super(context, DBNAME, null, VERSION);// 重写基类的构造函数
    }
    public  DBOpenHelper(Context context,int VERSION){
        super(context, DBNAME, null, VERSION);// 重写基类的构造函数
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table scheme(scheme_id integer  PRIMARY KEY AUTOINCREMENT,\n" +
                "                scheme_houseType varchar(100) NOT NULL,\n" +
                "                scheme_houseArea varchar(100) NOT NULL,\n" +
                "                scheme_houseStyle varchar(100)NOT NULL,\n" +
                "                scheme_pirceOne varchar(100),\n" +
                "                scheme_pirceTwoWork varchar(100),\n" +
                "                scheme_pirceTwoMateria varchar(100),\n" +
                "                scheme_pirceThreeWork varchar(100),\n" +
                "                scheme_pirceThreeMaterial varchar(100),\n" +
                "                scheme_pirceFourWork varchar(100),\n" +
                "                scheme_pirceFourMaterial varchar(100),\n" +
                "                scheme_pirceFivework varchar(100),\n" +
                "                scheme_pirceFiveMaterial varchar(100),\n" +
                "                scheme_pirceSum varchar(100))");

        db.execSQL("create table material(material_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                material_name varchar(100) NOT NULL,\n" +
                "                material_type varchar(100),\n" +
                "                material_price varchar(100) ,\n" +
                "                material_provider varchar(100) ,\n" +
                "                material_brand varchar(100),\n" +
                "                material_photo blob)");

        db.execSQL("create table project(project_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                project_StartTime data,\n" +
                "                project_FinishTime data,\n" +
                "                proiect_photo blob,\n" +
                "                project_principle varchar(100) ,\n" +
                "                project_UserEvaluation varchar(100),\n" +
                "                project_UserAcceptance varchar(100),\n" +
                "                 project_address varchar(100))");

        db.execSQL("create table administrator(administrator_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                administrator_name varchar(100),\n" +
                "                administrator_password varchar(100) ,\n" +
                "                administrator_telephone varchar(100))");

        db.execSQL("create table activity(activity_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                activity_StartTime data,\n" +
                "                activity_FinishTime data,\n" +
                "                proiect_photo blob,\n" +
                "                activity_name varchar(100) ,\n" +
                "                activity_type varchar(100),\n" +
                "                activity_people varchar(100),\n" +
                "                activity_content varchar(100))");

        db.execSQL("create table information(information_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                information_user varchar(100),\n" +
                "                information_userTelephon varchar(100),\n" +
                "                information_address varchar(100),\n" +
                "                information_Area varchar(100) ,\n" +
                "                information_Type varchar(100),\n" +
                "                information_Stytle varchar(100))");

        db.execSQL("create table effect(effect_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                effect_name varchar(100) NOT NULL,\n" +
                "                effect_stytle varchar(100) NOT NULL,\n" +
                "                effect_area varchar(100)NOT NULL,\n" +
                "                effect_type varchar(100)NOT NULL,\n" +
                "                effect_photo blob,\n" +
                "                effect_recommand boolean,\n" +
                "                effect_UserSee boolean,\n" +
                "                effect_PriceOne varchar(100),\n" +
                "                effect_PriceTwo varchar(100),\n" +
                "                effect_PriceThree varchar(100),\n" +
                "                effect_PriceFour varchar(100),\n" +
                "                effect_PriceFive varchar(100),\n" +
                "                effect_PriceSum varchar(100))");

        db.execSQL("create table user(user_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "                user_name varchar(100),\n" +
                "                user_password varchar(100),\n" +
                "                user_telephone varchar(100),\n" +
                "                user_adr varchar(100) ,\n" +
                "                user_houseType varchar(100),\n" +
                "                user_houseArea varchar(100))");

        db.execSQL("create table communction(communction_id integer NOT NULL primary key autoincrement,\n" +
                "                communction_user varchar(100),\n" +
                "                communction_head varchar(100),\n" +
                "                communctions varchar(100),\n" +
                "                communction_isAccept boolean ,\n" +
                "                communction_time data)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private static DBOpenHelper penHelper;


}
//    private static final int VERSION = 1;// 定义数据库版本号
//    private static final String DBNAME = "account.db";// 定义数据库名
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {// 创建数据库
//
//        db.execSQL("create table tb_outaccount (_id integer primary key,money decimal,time varchar(10),"
//                + "type varchar(10),address varchar(100),mark varchar(200))");// 创建支出信息表
//        db.execSQL("create table tb_inaccount (_id integer primary key,money decimal,time varchar(10),"
//                + "type varchar(10),handler varchar(100),mark varchar(200))");// 创建收入信息表
//        db.execSQL("create table tb_pwd (password varchar(20))");// 创建密码表
//        db.execSQL("create table tb_flag (_id integer primary key,flag varchar(200))");// 创建便签信息表
//        db.execSQL("create table User(id integer primary key autoincrement,username varchar(10),userpwd varchar(10))");
//    }
//        public  DBOpenHelper(Context context,int VERSION){
//        super(context, DBNAME, null, VERSION);// 重写基类的构造函数
//    }
//    public DBOpenHelper(Context context) {// 定义构造函数
//
//        super(context, DBNAME, null, VERSION);// 重写基类的构造函数
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {// 覆写基类的onUpgrade方法，以便数据库版本更新
//    }
//
//    /**
//     * 获取SqliteDB实例
//     *
//     * @param
//     */
//    private static DBOpenHelper penHelper;
//
//    public synchronized static DBOpenHelper getInstance(Context context) {
//        if (penHelper == null) {
//            penHelper = new DBOpenHelper(context);
//        }
//        return penHelper;
//    }
//}