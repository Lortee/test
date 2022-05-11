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

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "acc.db"; // название бд
    private static final String TABLE_NAME = "acc"; // название таблицы в бд
    private static final int SCHEMA = 1; // версия базы данных
    private static String DB_PATH;
    //удаление таблицы
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    // названия столбцов
    private static final String COLUMN_ID = "_id"; //id
    private static final String COLUMN_NAME = "name"; //название
    private static final String COLUMN_SDESC = "sDesc"; //краткое описание
    private static final String COLUMN_DESC = "desc"; //описание
    private static final String COLUMN_SOCK = "sock"; //сокет
    private static final String COLUMN_POWER = "power"; //мощность
    private Context myContext;

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
    }

    //копирование бд из папки assets
    void create_db(){

        File file = new File(DB_PATH);
        if (!file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput = myContext.getAssets().open(DB_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }

    //метод открытия базы данных
    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}