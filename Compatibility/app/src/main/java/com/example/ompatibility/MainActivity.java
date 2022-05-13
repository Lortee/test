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
        ImageView imProc = findViewById(R.id.imageProcTotal);
        ImageView imMom = findViewById(R.id.imageMomTotal);
        ImageView imOhl = findViewById(R.id.imageOhlTotal);
        TextView txtProcName = findViewById(R.id.textProcNameTotal);
        TextView txtOhlName = findViewById(R.id.textOhlNameTotal);
        TextView txtMomName = findViewById(R.id.textMomNameTotal);
        TextView txtProcDesc = findViewById(R.id.textProcDescTotal);
        TextView txtOhlDesc = findViewById(R.id.textOhlDescTotal);
        TextView txtMomDesc = findViewById(R.id.textMomDescTotal);
        TextView txtTotal = findViewById(R.id.txtTotal);
        Button btnTotal = findViewById(R.id.buttonTotal);
        Button btnPlusProc = findViewById(R.id.btnPlusProc);
        Button btnPlusOhl = findViewById(R.id.btnPlusOhl);
        Button btnPlusMom = findViewById(R.id.btnPlusMom);


        //обработка нажатия на кнопку
        btnTotal.setOnClickListener(new View.OnClickListener() {
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