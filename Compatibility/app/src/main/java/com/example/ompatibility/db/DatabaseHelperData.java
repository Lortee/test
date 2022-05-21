package com.example.ompatibility.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperData extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "data"; // название таблицы в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROCPOWER = "procPower";
    public static final String COLUMN_PROCSOCK = "procSock";
    public static final String COLUMN_OHLPOWER = "ohlPower";
    public static final String COLUMN_MOMSOCK = "momSock";

    //конструктор
    public DatabaseHelperData(Context context){
        super(context, DATABASE_NAME, null, SCHEMA);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE data (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROCPOWER + " INTEGER, "
                + COLUMN_PROCSOCK + " INTEGER, "
                + COLUMN_OHLPOWER + " INTEGER, "
                + COLUMN_MOMSOCK + " INTEGER);");


        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_PROCPOWER + ", " + COLUMN_PROCSOCK + ", " + COLUMN_OHLPOWER + ", "
                + COLUMN_MOMSOCK  + ") VALUES (0, 0, 0, 0);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
