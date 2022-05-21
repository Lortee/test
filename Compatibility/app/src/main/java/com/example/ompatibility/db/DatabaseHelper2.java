package com.example.ompatibility.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "value2.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "value2"; // название таблицы в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROCNAME = "procName";
    public static final String COLUMN_PROCSDESC = "procSDesc";
    public static final String COLUMN_PROCIM = "procIm";
    public static final String COLUMN_OHLNAME = "ohlName";
    public static final String COLUMN_OHLSDESC = "ohlSDesc";
    public static final String COLUMN_OHLIM = "ohlIm";
    public static final String COLUMN_MOMNAME = "momName";
    public static final String COLUMN_MOMSDESC = "momSDesc";
    public static final String COLUMN_MOMIM = "momIm";

    //конструктор
    public DatabaseHelper2(Context context){
        super(context, DATABASE_NAME, null, SCHEMA);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE value2 (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROCNAME + " TEXT, "
                + COLUMN_PROCSDESC + " TEXT, "
                + COLUMN_PROCIM + " INTEGER, "
                + COLUMN_OHLNAME + " TEXT, "
                + COLUMN_OHLSDESC + " TEXT, "
                + COLUMN_OHLIM + " INREGER, "
                + COLUMN_MOMNAME + " TEXT, "
                + COLUMN_MOMIM + " INTEGER, "
                + COLUMN_MOMSDESC + " TEXT);");


        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_PROCNAME + ", " + COLUMN_PROCSDESC + ", " + COLUMN_OHLNAME + ", "
                + COLUMN_OHLSDESC + ", " + COLUMN_MOMNAME + ", " + COLUMN_PROCIM + ", " + COLUMN_OHLIM + ", " + COLUMN_MOMIM + ", "
                + COLUMN_MOMSDESC  + ") VALUES ('', '', '', '', '', 0, 0, 0, '');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
