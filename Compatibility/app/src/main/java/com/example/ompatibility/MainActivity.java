package com.example.ompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ompatibility.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {


    private DatabaseHelper mDbHelper;

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
        Button btnTotal = findViewById(R.id.buttonTotal);
        Button btnPlusProc = findViewById(R.id.btnPlusProc);
        Button btnPlusOhl = findViewById(R.id.btnPlusOhl);
        Button btnPlusMom = findViewById(R.id.btnPlusMom);



        //обработка нажатия на кнопку
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();

                Data data = new Data();
                if (data.socketProc == data.socketMom && data.powerOhl - data.powerProc >=35){
                    //Toast toast = Toast.makeText(getApplicationContext(), "Все совместимо!", Toast.LENGTH_LONG);
                    //toast.show();
                    //txtTotal.setText("Все совместимо!");
                    //txtTotal.setTextColor(Color.parseColor("#00FF00"));
                    myDialogFragment.message = "Все совместимо!";
                    myDialogFragment.show(manager, "myDialog");
                }
                else if(data.socketProc != data.socketMom && !(data.powerOhl - data.powerProc >=35)){
                    //Toast toast = Toast.makeText(getApplicationContext(), "Несовместимые коплектующие", Toast.LENGTH_LONG);
                    //toast.show();
                    //txtTotal.setText("Несовместимые коплектующие");
                    //txtTotal.setTextColor(Color.parseColor("#FF0000"));
                    myDialogFragment.message = "Несовместимые коплектующие";
                    myDialogFragment.show(manager, "myDialog");
                }
                else if (data.socketProc!= data.socketMom && data.powerOhl - data.powerProc >=35){
                    //Toast toast = Toast.makeText(getApplicationContext(), "Процессор и материнская плата несовместимы", Toast.LENGTH_LONG);
                    //toast.show();
                    //txtTotal.setText("Процессор и материнская плата несовместимы");
                    //txtTotal.setTextColor(Color.parseColor("#FF0000"));
                    myDialogFragment.message = "Процессор и материнская плата несовместимы";
                    myDialogFragment.show(manager, "myDialog");
                }
                else {
                    //Toast toast = Toast.makeText(getApplicationContext(), "Кулер и процессор несовместимы", Toast.LENGTH_LONG);
                    //toast.show();
                    //txtTotal.setText("Кулер и процессор несовместимы");
                    //txtTotal.setTextColor(Color.parseColor("#FF0000"));
                    myDialogFragment.message = "Кулер и процессор несовместимы";
                    myDialogFragment.show(manager, "myDialog");
                }
            }
        });



        // Создадим и откроем для чтения базу данных
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        /*// Cписок столбцов
        String[] projection = {DatabaseHelper.COLUMN_NAME};

        String selection = DatabaseHelper.COLUMN_ID + "=?";
        String[] selectionArgs = {"1"};

        /// Делаем запрос
        Cursor cursor = db.query(
                DatabaseHelper.TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

        txtProcName.setText(cursor.getCount());*/


        btnPlusProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });

        btnPlusOhl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });

        btnPlusMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });

    }


}