package com.example.ompatibility;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ompatibility.db.DatabaseHelper;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {

    ArrayList<Recycler> recyclers = new ArrayList<Recycler>();

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        RecyclerAdapter adapter = new RecyclerAdapter(this, recyclers);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }



    private void setInitialData(){
        db = databaseHelper.getReadableDatabase();
        /*cursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_NAME, null);
        String[] headers = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_SDESC};
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
               cursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);*/
        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));
    }
}
