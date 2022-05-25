package com.example.ompatibility;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ompatibility.db.DatabaseHelper;

import java.util.ArrayList;

public class ChoiceActivityOhl extends AppCompatActivity {


    SQLiteDatabase db;
    ArrayList<Recycler> recyclers = new ArrayList<Recycler>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choiceohl);

        //связывание элементов по id
        ImageView imageView = findViewById(R.id.im);
        Button btnDesc = findViewById(R.id.btnDesc);
        Button btnPlus = findViewById(R.id.btnPlus);
        TextView txtDesc = findViewById(R.id.txtDesc);
        TextView txtName = findViewById(R.id.txtName);
        Button buttonBack = findViewById(R.id.buttonBackOhl);




        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.listohl);
        // создаем адаптер
        RecyclerAdapterOhl adapter = new RecyclerAdapterOhl(this, recyclers);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);


        //обрабатываем нажатие на кнопку возврата на главный экран
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivityOhl.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //разрешить навигацию вверх с помощью значка приложения на верхней панели
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    //обработка нажатия кнопки назад
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    //заполнение recyclerView
    private void setInitialData(){
        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        mDbHelper.create_db();
        db = mDbHelper.open();

        //список столбцов
        String[] projection = {DatabaseHelper.COLUMN_NAME};

        // Делаем запрос
        Cursor cursor = db.query(
                DatabaseHelper.TABLE_OHL,
                projection,
                null,
                null,
                null,
                null,
                null,
                null);

        //перемещаем курсор на первую строку
        cursor.moveToFirst();

        //список столбцов
        String[] projection1 = {DatabaseHelper.COLUMN_SDESC};

        // Делаем запрос
        Cursor cursor1 = db.query(
                DatabaseHelper.TABLE_OHL,
                projection1,
                null,
                null,
                null,
                null,
                null,
                null);

        //перемещаем курсор на первую строку
        cursor1.moveToFirst();

        //считывание данных из бд в recyclerView
        int nameColumnIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int sDescColumnIndex = cursor1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
        String currentName = cursor.getString(nameColumnIndex);
        String currentSDesc = cursor1.getString(sDescColumnIndex);
        recyclers.add(new Recycler(currentName, currentSDesc, R.drawable.deep200t));


        cursor.moveToNext();
        cursor1.moveToNext();

        int nameColumnIndex2 = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int sDescColumnIndex2 = cursor1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
        String currentName2 = cursor.getString(nameColumnIndex2);
        String currentSDesc2 = cursor1.getString(sDescColumnIndex2);
        recyclers.add(new Recycler(currentName2, currentSDesc2, R.drawable.i250));


        cursor.moveToNext();
        cursor1.moveToNext();

        int nameColumnIndex3 = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int sDescColumnIndex3 = cursor1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
        String currentName3 = cursor.getString(nameColumnIndex3);
        String currentSDesc3 = cursor1.getString(sDescColumnIndex3);
        recyclers.add(new Recycler(currentName3, currentSDesc3, R.drawable.z50));


        cursor.moveToNext();
        cursor1.moveToNext();

        int nameColumnIndex4 = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int sDescColumnIndex4 = cursor1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
        String currentName4 = cursor.getString(nameColumnIndex4);
        String currentSDesc4 = cursor1.getString(sDescColumnIndex4);
        recyclers.add(new Recycler(currentName4, currentSDesc4, R.drawable.deep400));


        cursor.moveToNext();
        cursor1.moveToNext();

        int nameColumnIndex5 = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int sDescColumnIndex5 = cursor1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
        String currentName5 = cursor.getString(nameColumnIndex5);
        String currentSDesc5 = cursor1.getString(sDescColumnIndex5);
        recyclers.add(new Recycler(currentName5, currentSDesc5, R.drawable.assassin3));

        cursor.close();
        cursor1.close();;


    }
}
