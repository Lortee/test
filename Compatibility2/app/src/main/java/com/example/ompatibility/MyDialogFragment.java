package com.example.ompatibility;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.window.SplashScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.ompatibility.db.DatabaseHelper;

public class MyDialogFragment extends DialogFragment {

    //значения для всплывающего окна
    public String title = "Итог:"; //главный текст
    public String message; //сообщение
    public String button1String = "Сброс"; //первая кнопка
    public String button2String = "Ок";  //вторая кнопка
    Context context;


    //при создании всплывающего окна
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title); //устанавливаем главный текст
        builder.setMessage(message); //устанавливаем сообщение


        //обработка нажатия на кнопку "сброс"
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //передаем интент
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

                //закрываем всплывающее окно
                dialogInterface.cancel();
            }
        });


        //обработка нажатия на кнопку "ок"
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //закрываем всплывающее окно
                dialogInterface.cancel();
            }
        });

        builder.setCancelable(true);

        return  builder.create();
    }
}