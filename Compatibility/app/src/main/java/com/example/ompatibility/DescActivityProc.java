package com.example.ompatibility;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ompatibility.db.DatabaseHelper;

public class DescActivityProc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        //связывание элементов по id
        TextView txtName = findViewById(R.id.textNameDesc);
        TextView txtSDesc = findViewById(R.id.textShortDesc);
        TextView txtDesc = findViewById(R.id.textFullDesc);
        ImageView imImage = findViewById(R.id.imageDesc);
        Button btnBack = findViewById(R.id.buttonBackDesc);

        //обработка нажатия на кнопку
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescActivityProc.this, ChoiceActivityProc.class);
                startActivity(intent);
            }
        });


        Bundle arg = getIntent().getExtras();
        int value = arg.getInt("proc1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        mDbHelper.create_db();
        db = mDbHelper.open();

        switch (value){
            case 1:

                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};
                String[] projectionDesc1 = {DatabaseHelper.COLUMN_DESC};

                String selection = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs = {"1"};

                // Делаем запрос
                Cursor cursorName = db.query(
                DatabaseHelper.TABLE_PROC,
                projectionName1,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
                cursorName.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc1,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc.moveToFirst();

                // Делаем запрос
                Cursor cursorDesc = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionDesc1,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorDesc.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex = cursorName.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex = cursorSDesc.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                int descColumnIndex = cursorDesc.getColumnIndex(DatabaseHelper.COLUMN_DESC);

                String currentName = cursorName.getString(nameColumnIndex);
                String currentSDesc = cursorSDesc.getString(sDescColumnIndex);
                String currentDesc = cursorDesc.getString(descColumnIndex);

                txtName.setText(currentName);
                txtSDesc.setText(currentSDesc);
                txtDesc.setText(currentDesc);
                imImage.setImageResource(R.drawable.i5_11400f);

                cursorName.close();
                cursorSDesc.close();
                cursorDesc.close();

                break;


            case 2:

                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};
                String[] projectionDesc2 = {DatabaseHelper.COLUMN_DESC};

                String selection2 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs2 = {"2"};

                // Делаем запрос
                Cursor cursorName2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorName2.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc2.moveToFirst();

                // Делаем запрос
                Cursor cursorDesc2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionDesc2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                int descColumnIndex2 = cursorDesc2.getColumnIndex(DatabaseHelper.COLUMN_DESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);
                String currentDesc2 = cursorDesc2.getString(descColumnIndex2);

                txtName.setText(currentName2);
                txtSDesc.setText(currentSDesc2);
                txtDesc.setText(currentDesc2);
                imImage.setImageResource(R.drawable.i9_12900k);

                cursorName2.close();
                cursorSDesc2.close();
                cursorDesc2.close();

                break;


            case 3:
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};
                String[] projectionDesc3 = {DatabaseHelper.COLUMN_DESC};

                String selection3 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs3 = {"3"};

                // Делаем запрос
                Cursor cursorName3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorName3.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc3.moveToFirst();

                // Делаем запрос
                Cursor cursorDesc3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionDesc3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorDesc3.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                int descColumnIndex3 = cursorDesc3.getColumnIndex(DatabaseHelper.COLUMN_DESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);
                String currentDesc3 = cursorDesc3.getString(descColumnIndex3);

                txtName.setText(currentName3);
                txtSDesc.setText(currentSDesc3);
                txtDesc.setText(currentDesc3);
                imImage.setImageResource(R.drawable.i3_10100f);

                cursorName3.close();
                cursorSDesc3.close();
                cursorDesc3.close();

                break;


            case 4:
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};
                String[] projectionDesc4 = {DatabaseHelper.COLUMN_DESC};

                String selection4 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs4 = {"4"};

                // Делаем запрос
                Cursor cursorName4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorName4.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc4.moveToFirst();

                // Делаем запрос
                Cursor cursorDesc4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionDesc4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorDesc4.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                int descColumnIndex4 = cursorDesc4.getColumnIndex(DatabaseHelper.COLUMN_DESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);
                String currentDesc4 = cursorDesc4.getString(descColumnIndex4);

                txtName.setText(currentName4);
                txtSDesc.setText(currentSDesc4);
                txtDesc.setText(currentDesc4);
                imImage.setImageResource(R.drawable.ryzen_5_5600x);

                cursorName4.close();
                cursorSDesc4.close();
                cursorDesc4.close();

                break;


            case 5:
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};
                String[] projectionDesc5 = {DatabaseHelper.COLUMN_DESC};

                String selection5 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs5 = {"5"};

                // Делаем запрос
                Cursor cursorName5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorName5.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc5.moveToFirst();

                // Делаем запрос
                Cursor cursorDesc5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionDesc5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorDesc5.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                int descColumnIndex5 = cursorDesc5.getColumnIndex(DatabaseHelper.COLUMN_DESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);
                String currentDesc5 = cursorDesc5.getString(descColumnIndex5);

                txtName.setText(currentName5);
                txtSDesc.setText(currentSDesc5);
                txtDesc.setText(currentDesc5);
                imImage.setImageResource(R.drawable.ryzen_9_5900x);


                cursorName5.close();
                cursorSDesc5.close();
                cursorDesc5.close();

                break;
        }

        db.close();

    }
}