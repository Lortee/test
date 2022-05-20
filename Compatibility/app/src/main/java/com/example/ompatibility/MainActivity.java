package com.example.ompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ompatibility.db.DatabaseHelper;

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
        TextView txtProcSDesc = findViewById(R.id.textProcDescTotal);
        TextView txtOhlSDesc = findViewById(R.id.textOhlDescTotal);
        TextView txtMomSDesc = findViewById(R.id.textMomDescTotal);
        Button btnTotal = findViewById(R.id.buttonTotal);
        Button btnPlusProc = findViewById(R.id.btnPlusProc);
        Button btnPlusOhl = findViewById(R.id.btnPlusOhl);
        Button btnPlusMom = findViewById(R.id.btnPlusMom);


        //обработка нажатия на кнопку
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //создаем всплювающее окно
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();

                    myDialogFragment.message = "Пожалуйста, выберите комплектующие";
                    myDialogFragment.show(manager, "myDialog");

            }
        });


        //обрабатываем нажатия на кнопки
        btnPlusProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivityProc.class);
                startActivity(intent);


            }
        });

        btnPlusOhl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivityOhl.class);
                startActivity(intent);
            }
        });

        btnPlusMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivityMom.class);
                startActivity(intent);
            }
        });





   }



}