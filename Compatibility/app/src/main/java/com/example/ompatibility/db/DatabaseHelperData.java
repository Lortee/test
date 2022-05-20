package com.example.ompatibility.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelperData extends SQLiteOpenHelper {

    private static String DB_PATH; //полный путь к базе данных
    private static final String DB_NAME = "accData.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE_DATA = "data"; // название таблицы с данными в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROCSOCK = "procSock"; //сокет процессора
    public static final String COLUMN_PROCPOWER = "procPower"; //мощность процессора
    public static final String COLUMN_OHLPOWER = "ohlPower"; //мощность кулера
    public static final String COLUMN_MOMSOCK = "momSock"; //сокет материнской платы




    //конструктор
    public DatabaseHelperData(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE data (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROCSOCK + " INTEGER, "
                + COLUMN_PROCPOWER + " INTEGER, "
                + COLUMN_MOMSOCK + " INTEGER, "
                + COLUMN_OHLPOWER + " INTEGER);");

        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE_DATA +" (" + COLUMN_PROCSOCK
                + ", " + COLUMN_PROCPOWER  + ", " + COLUMN_MOMSOCK + ", " + COLUMN_OHLPOWER + ") VALUES ('0', '0', '0', '0');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DATA);
        onCreate(db);
    }



}
