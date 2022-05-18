package com.example.ompatibility;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ompatibility.db.DatabaseHelper;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {

    ArrayList<Recycler> recyclers = new ArrayList<Recycler>();
    /*ListView userList;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        //ListView listView = findViewById(R.id.list);
        ImageView imageView = findViewById(R.id.im);
        Button btnDesc = findViewById(R.id.btnDesc);
        Button btnPlus = findViewById(R.id.btnPlus);
        TextView txtDesc = findViewById(R.id.txtDesc);
        TextView txtName = findViewById(R.id.txtName);


        //userList = findViewById(R.id.list);

        //databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        //databaseHelper.create_db();


        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        RecyclerAdapter adapter = new RecyclerAdapter(this, recyclers);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }



    private void setInitialData(){
        /*db = databaseHelper.open();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
        String[] from = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_SDESC};
        int[] to = new int[] {R.id.txtName, R.id.txtDesc, R.id.im};
        userAdapter = new SimpleCursorAdapter(this, R.layout.recycler, userCursor, from, to);
        userList.setAdapter(userAdapter);

        registerForContextMenu(userList);*/



        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));
        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));
        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));


    }
}
