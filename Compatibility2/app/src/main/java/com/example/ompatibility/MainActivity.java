package com.example.ompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ompatibility.db.DatabaseHelper;
import com.example.ompatibility.db.DatabaseHelper2;
import com.example.ompatibility.db.DatabaseHelperData;
import com.jakewharton.processphoenix.ProcessPhoenix;

public class MainActivity extends AppCompatActivity {

    ContentValues cv = new ContentValues();
    ContentValues cv2 = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //связывание кнопки с id
        Button buttonGo = findViewById(R.id.buttonGo);
        Button buttonExit = findViewById(R.id.buttonExit);

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //выходим из приложения по нажатию на кнопку

                finishAffinity();
            }
        });


    //обработка нажатия на кнопку
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("int", 2);
                startActivity(intent);

                //очищаем все значения

                    DatabaseHelperData databaseHelperData = new DatabaseHelperData(getApplicationContext());
                    SQLiteDatabase dbData = databaseHelperData.getWritableDatabase();
                    MainActivity2 mainActivity2 = new MainActivity2();



                    cv.clear();
                    cv.put(DatabaseHelperData.COLUMN_PROCSOCK, 0);
                    cv.put(DatabaseHelperData.COLUMN_PROCPOWER, 0);
                    cv.put(DatabaseHelperData.COLUMN_MOMSOCK, 0);
                    cv.put(DatabaseHelperData.COLUMN_OHLPOWER, 0);

                    dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                    DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(getApplicationContext());
                    SQLiteDatabase db2 = databaseHelper2.getWritableDatabase();

                    cv2.clear();
                    cv2.put(DatabaseHelper2.COLUMN_PROCNAME, " ");
                    cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, " ");
                    cv2.put(DatabaseHelper2.COLUMN_MOMNAME, " ");
                    cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, " ");
                    cv2.put(DatabaseHelper2.COLUMN_OHLNAME, " ");
                    cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, " ");
                    cv2.put(DatabaseHelper2.COLUMN_MOMIM, 0);
                    cv2.put(DatabaseHelper2.COLUMN_OHLIM, 0);
                    cv2.put(DatabaseHelper2.COLUMN_PROCIM, 0);

                    db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                    db2.close();
                    dbData.close();
            }
        });


   }

}