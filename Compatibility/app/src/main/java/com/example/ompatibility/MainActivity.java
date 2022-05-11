package com.example.ompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //связывание элементов по id
        Button buttonProcMain = findViewById(R.id.buttonProcMain);
        Button buttonOhlMain = findViewById(R.id.buttonOhlMain);
        Button buttonMomMain = findViewById(R.id.buttonMomMain);

        //обработка нажатия на кнопку
        buttonProcMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });

        buttonOhlMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });

        buttonMomMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });


    }
}