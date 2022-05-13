package com.example.ompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //связывание элементов по id
        TextView nameProc = findViewById(R.id.textProcNameTotal);
        TextView descProc = findViewById(R.id.textProcDescTotal);
        ImageView imageProc = findViewById(R.id.imageProcTotal);
        TextView nameOhl = findViewById(R.id.textOhlNameTotal);
        TextView descOhl = findViewById(R.id.textOhlDescTotal);
        ImageView imageOhl = findViewById(R.id.imageOhlTotal);
        TextView nameMom = findViewById(R.id.textMomNameTotal);
        TextView descMom = findViewById(R.id.textMomDescTotal);
        ImageView imageMom = findViewById(R.id.imageMomTotal);
        Button total = findViewById(R.id.buttonTotal);

        //обработка нажатия на кнопку
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data();
                if (data.socketProc == data.socketMom && data.powerOhl - data.powerProc >=35){
                    Toast toast = Toast.makeText(getApplicationContext(), "Все совместимо!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if(data.socketProc != data.socketMom && !(data.powerOhl - data.powerProc >=35)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Несовместимые коплектующие", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (data.socketProc!= data.socketMom && data.powerOhl - data.powerProc >=35){
                    Toast toast = Toast.makeText(getApplicationContext(), "Процессор и материнская плата несовместимы", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Кулер и процессор несовместимы", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}