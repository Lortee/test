package com.example.ompatibility.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH; //полный путь к базе данных
    private static final String DB_NAME = "access.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE_PROC = "proc"; // название таблицы1 в бд
    public static final String TABLE_OHL = "ohl"; // название таблицы2 в бд
    public static final String TABLE_MOM = "mom"; // название таблицы3 в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id"; //id
    public static final String COLUMN_NAME = "name"; //название
    public static final String COLUMN_SDESC = "sDesc"; //краткое описание
    public static final String COLUMN_DESC = "desc"; //описание
    public static final String COLUMN_SOCK = "sock"; //сокет
    public static final String COLUMN_POWER = "power"; //мощность
    public final Context myContext;


    //конструктор
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        //получение пути к бд
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
    }

    //копирование бд из папки assets
    public  void create_db(){

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
    public SQLiteDatabase open() throws SQLException {
        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }


}