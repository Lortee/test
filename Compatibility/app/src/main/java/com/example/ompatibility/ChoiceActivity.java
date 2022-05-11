package com.example.ompatibility;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {

    ArrayList<Recycler> recyclers = new ArrayList<Recycler>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);


        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        RecyclerAdapter adapter = new RecyclerAdapter(this, recyclers);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));
        recyclers.add(new Recycler ("название", "краткое описание", R.drawable.r));
    }
}
