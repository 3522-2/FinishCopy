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

    public DBOpenHelper(Context context, int VERSION) {
        super(context, DBNAME, null, VERSION);// 重写基类的构造函数
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table scheme(scheme_id integer  PRIMARY KEY AUTOINCREMENT,\n" +
                "                scheme_houseType varchar(100),\n" +
                "                scheme_houseArea varchar(100) ,\n" +
                "                scheme_houseStyle varchar(100),\n" +
                "                scheme_pirceOne varchar(100),\n" +
                "                scheme_pirceTwoWork varchar(100),\n" +
                "                scheme_pirceTwoMaterial varchar(100),\n" +
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
                "                project_Name varchar(100),\n" +
                "                project_StartTime varchar(100),\n" +
                "                project_FinishTime varchar(100),\n" +
                "                proiect_photo blob,\n" +
                "                project_principle varchar(100) ,\n" +
                "                project_UserEvaluation varchar(100),\n" +
                "                project_UserAcceptance varchar(100),\n" +
                "                 project_address varchar(100),\n" +
                "                 project_Des varchar(100))");

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
                "                effect_describe varchar(100),\n" +
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

}