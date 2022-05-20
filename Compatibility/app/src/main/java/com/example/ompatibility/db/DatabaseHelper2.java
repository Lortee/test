package com.example.ompatibility.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static String DB_PATH; //полный путь к базе данных
    private static final String DB_NAME = "accData.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "table"; // название таблицы с данными в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROCNAME = "procName"; //сокет процессора
    public static final String COLUMN_PROCSDESC = "procSDesc"; //сокет процессора
    public static final String COLUMN_OHLNAME = "ohlName"; //сокет процессора
    public static final String COLUMN_OHLSDESC = "ohlSDesc"; //сокет процессора
    public static final String COLUMN_MOMNAME = "momName"; //сокет процессора
    public static final String COLUMN_MOMSDESC = "momSDesc"; //сокет процессора




    //конструктор
    public DatabaseHelper2(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE data (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROCNAME + " TEXT, "
                + COLUMN_PROCSDESC + " TEXT, "
                + COLUMN_MOMNAME + " TEXT, "
                + COLUMN_MOMSDESC + " TEXT, "
                + COLUMN_OHLNAME + " TEXT, "
                + COLUMN_OHLSDESC + " TEXT);");

        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_PROCNAME
                + ", " + COLUMN_PROCSDESC  + ", " + COLUMN_OHLNAME + ", " + COLUMN_OHLSDESC  + ", "
                + COLUMN_MOMNAME + ", " + COLUMN_MOMSDESC + ") VALUES ( ,  ,  ,  ,  ,  );");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }



}
