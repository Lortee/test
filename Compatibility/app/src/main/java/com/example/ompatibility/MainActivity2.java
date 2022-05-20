package com.example.ompatibility;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.ompatibility.db.DatabaseHelper;
import com.example.ompatibility.db.DatabaseHelper2;
import com.example.ompatibility.db.DatabaseHelperData;

public class MainActivity2 extends AppCompatActivity {


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


        DatabaseHelperData mDbHelperData = new DatabaseHelperData(getApplicationContext());
        SQLiteDatabase dbData = mDbHelperData.getReadableDatabase();
        DatabaseHelper2 mDbHelper2 = new DatabaseHelper2(getApplicationContext());
        SQLiteDatabase db2 = mDbHelper2.getReadableDatabase();



        String[] projectionProcName = {DatabaseHelper2.COLUMN_PROCNAME};
        String[] projectionProcSDesc = {DatabaseHelper2.COLUMN_PROCSDESC};
        String[] projectionOhlName = {DatabaseHelper2.COLUMN_OHLNAME};
        String[] projectionOhlSDesc = {DatabaseHelper2.COLUMN_OHLSDESC};
        String[] projectionMomName = {DatabaseHelper2.COLUMN_MOMNAME};
        String[] projectionMomSDesc = {DatabaseHelper2.COLUMN_MOMSDESC};



        String selection = DatabaseHelper.COLUMN_ID + "=?";
        String[] selectionArgs = {"1"};


        Cursor cursorProcName = db2.query(
                DatabaseHelper2.TABLE,
                projectionProcName,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorProcName.moveToFirst();

        Cursor cursorProcSDesc = db2.query(
                DatabaseHelper2.TABLE,
                projectionProcSDesc,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorProcSDesc.moveToFirst();

        Cursor cursorOhlName = db2.query(
                DatabaseHelper2.TABLE,
                projectionOhlName,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorOhlName.moveToFirst();

        Cursor cursorOhlSDesc = db2.query(
                DatabaseHelper2.TABLE,
                projectionOhlSDesc,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorOhlSDesc.moveToFirst();

        Cursor cursorMomName = db2.query(
                DatabaseHelper2.TABLE,
                projectionMomName,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorMomName.moveToFirst();

        Cursor cursorMomSDesc = db2.query(
                DatabaseHelper2.TABLE,
                projectionMomSDesc,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        cursorMomSDesc.moveToFirst();


        int columnProcNameIndex = cursorProcName.getColumnIndex(DatabaseHelper2.COLUMN_PROCNAME);
        int columnProcSDescIndex = cursorProcSDesc.getColumnIndex(DatabaseHelper2.COLUMN_PROCSDESC);
        int columnMomNameIndex = cursorMomName.getColumnIndex(DatabaseHelper2.COLUMN_MOMNAME);
        int columnMomSDescIndex = cursorMomSDesc.getColumnIndex(DatabaseHelper2.COLUMN_MOMSDESC);
        int columnOhlNameIndex = cursorOhlName.getColumnIndex(DatabaseHelper2.COLUMN_OHLNAME);
        int columnOhlSDescIndex = cursorOhlSDesc.getColumnIndex(DatabaseHelper2.COLUMN_OHLSDESC);

        int currentProcName = cursorProcName.getInt(columnProcNameIndex);
        int currentProcSDesc = cursorProcSDesc.getInt(columnProcSDescIndex);
        int currentOhlName = cursorOhlName.getInt(columnOhlNameIndex);
        int currentOhlSDesc = cursorOhlSDesc.getInt(columnOhlSDescIndex);
        int currentMomName = cursorMomName.getInt(columnMomNameIndex);
        int currentMomSDesc = cursorMomSDesc.getInt(columnMomSDescIndex);


        txtProcName.setText(currentProcName);
        txtProcSDesc.setText(currentProcSDesc);
        txtOhlName.setText(currentOhlName);
        txtOhlSDesc.setText(currentOhlSDesc);
        txtMomName.setText(currentMomName);
        txtMomSDesc.setText(currentMomSDesc);

        db2.close();
        dbData.close();

        cursorProcName.close();
        cursorProcSDesc.close();
        cursorMomName.close();
        cursorMomSDesc.close();
        cursorOhlName.close();
        cursorOhlSDesc.close();









        //обработка нажатия на кнопку
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //создаем всплювающее окно
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();





                String[] projectionOhlPower = {DatabaseHelperData.COLUMN_OHLPOWER};
                String[] projectionMomSock = {DatabaseHelperData.COLUMN_MOMSOCK};
                String[] projectionProcPower = {DatabaseHelperData.COLUMN_PROCPOWER};
                String[] projectionProcSock = {DatabaseHelperData.COLUMN_PROCSOCK};



                String selection = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs = {"1"};


                Cursor cursorOhlPower = dbData.query(
                        DatabaseHelperData.TABLE_DATA,
                        projectionOhlPower,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorOhlPower.moveToFirst();

                Cursor cursorMomSock = dbData.query(
                        DatabaseHelperData.TABLE_DATA,
                        projectionMomSock,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorMomSock.moveToFirst();


                Cursor cursorProcPower = dbData.query(
                        DatabaseHelperData.TABLE_DATA,
                        projectionProcPower,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorProcPower.moveToFirst();

                Cursor cursorProcSock = dbData.query(
                        DatabaseHelperData.TABLE_DATA,
                        projectionProcSock,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                cursorProcSock.moveToFirst();


                int columnOhlPowerIndex = cursorOhlPower.getColumnIndex(DatabaseHelperData.COLUMN_OHLPOWER);
                int columnMomSockIndex = cursorMomSock.getColumnIndex(DatabaseHelperData.COLUMN_MOMSOCK);
                int columnProcPowerIndex = cursorProcPower.getColumnIndex(DatabaseHelperData.COLUMN_PROCPOWER);
                int columnProcSockIndex = cursorProcSock.getColumnIndex(DatabaseHelperData.COLUMN_PROCSOCK);

                int currentOhlPower = cursorOhlPower.getInt(columnOhlPowerIndex);
                int currentMomSock = cursorMomSock.getInt(columnMomSockIndex);
                int currentProcPower = cursorProcPower.getInt(columnProcPowerIndex);
                int currentProcSock = cursorProcSock.getInt(columnProcSockIndex);

                if (currentProcSock == currentMomSock && currentOhlPower - currentProcPower >= 35) {
                    myDialogFragment.message = "Все совместимо!";
                    myDialogFragment.show(manager, "myDialog");
                } else if (currentProcSock != currentMomSock && !(currentOhlPower - currentProcPower >= 35)) {
                    myDialogFragment.message = "Несовместимые коплектующие";
                    myDialogFragment.show(manager, "myDialog");
                } else if (currentProcSock != currentMomSock && currentOhlPower - currentProcPower >= 35) {
                    myDialogFragment.message = "Процессор и материнская плата несовместимы";
                    myDialogFragment.show(manager, "myDialog");
                } else if (currentProcSock == 0 || currentMomSock == 0 || currentOhlPower == 0 || currentProcPower == 0) {
                    myDialogFragment.message = "Пожалуйста, выберите комплектующие";
                    myDialogFragment.show(manager, "myDialog");

                } else {
                    myDialogFragment.message = "Кулер и процессор несовместимы";
                    myDialogFragment.show(manager, "myDialog");
                }

                cursorProcSock.close();
                cursorMomSock.close();
                cursorOhlPower.close();
                cursorProcPower.close();




            }
        });


        //обрабатываем нажатия на кнопки
        btnPlusProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, ChoiceActivityProc.class);
                startActivity(intent);


            }
        });

        btnPlusOhl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, ChoiceActivityOhl.class);
                startActivity(intent);
            }
        });

        btnPlusMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, ChoiceActivityMom.class);
                startActivity(intent);
            }
        });

        readProc();
        readOhl();
        readMom();
        nullData();
    }

    public void nullData(){
        Bundle arg = getIntent().getExtras();
        int value = arg.getInt("int");

        if (value == 2){
            DatabaseHelperData mDbHelperData = new DatabaseHelperData(getApplicationContext());
            DatabaseHelper2 mDbHelper2 = new DatabaseHelper2(getApplicationContext());
            SQLiteDatabase dbData = mDbHelperData.getWritableDatabase();
            SQLiteDatabase db2 = mDbHelper2.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.clear();
            cv.put(DatabaseHelper.COLUMN_PROCSOCK, 0);
            cv.put(DatabaseHelper.COLUMN_PROCPOWER, 0);
            cv.put(DatabaseHelper.COLUMN_MOMSOCK, 0);
            cv.put(DatabaseHelper.COLUMN_OHLPOWER, 0);

            ContentValues cv2 = new ContentValues();
            cv2.clear();
            cv2.put(DatabaseHelper2.COLUMN_PROCNAME, "");
            cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, "");
            cv2.put(DatabaseHelper2.COLUMN_MOMNAME, "");
            cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, "");
            cv2.put(DatabaseHelper2.COLUMN_OHLNAME, "");
            cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, "");

            dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });
            db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });




        }

    }

    public void readProc(){

        ImageView imProc = findViewById(R.id.imageProcTotal);
        TextView txtProcName = findViewById(R.id.textProcNameTotal);
        TextView txtProcSDesc = findViewById(R.id.textProcDescTotal);


        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("procDB1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        DatabaseHelper2 mDbHelper2 = new DatabaseHelper2(this);
        DatabaseHelperData mDbHelperData = new DatabaseHelperData(getApplicationContext());
        SQLiteDatabase db2 = mDbHelper2.getWritableDatabase();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        SQLiteDatabase dbData = mDbHelperData.getWritableDatabase();
        mDbHelper.create_db();
        db = mDbHelper.open();
        ContentValues cv = new ContentValues();
        ContentValues cv2 = new ContentValues();

        switch (value) {
            case 1:


                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                String selection1 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs1 = {"1"};

                // Делаем запрос
                Cursor cursorName1 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorName1.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc1 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

                txtProcName.setText(currentName);
                txtProcSDesc.setText(currentSDesc);
                imProc.setImageResource(R.drawable.i5_11400f);

                cursorName1.close();
                cursorSDesc1.close();


                //список столбцов
                String[] projectionProcPower1 = {DatabaseHelper.COLUMN_POWER};
                String[] projectionProcSocket1 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorPowerProc1 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcPower1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorPowerProc1.moveToFirst();

                // Делаем запрос
                Cursor cursorSocketProc1 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcSocket1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorSocketProc1.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorPowerProc1.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex = cursorSocketProc1.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower1 = Integer.parseInt(cursorPowerProc1.getString(powerColumnIndex));
                int currentSock1 = Integer.parseInt(cursorSocketProc1.getString(socketColumnIndex));

                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock1);
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower1);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });



                cursorSocketProc1.close();
                cursorPowerProc1.close();
                break;


            case 2:

                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                String selection2 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs2 = {"2"};

                // Делаем запрос
                Cursor cursorName2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorName2.moveToFirst();


                // Делаем запрос
                Cursor cursorSDesc2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                txtProcName.setText(currentName2);
                txtProcSDesc.setText(currentSDesc2);
                imProc.setImageResource(R.drawable.i9_12900k);

                cursorName2.close();
                cursorSDesc2.close();


                //список столбцов
                String[] projectionProcPower2 = {DatabaseHelper.COLUMN_POWER};
                String[] projectionProcSocket2 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorPowerProc2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcPower2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorPowerProc2.moveToFirst();

                // Делаем запрос
                Cursor cursorSocketProc2 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcSocket2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSocketProc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorPowerProc2.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex2 = cursorSocketProc2.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower2 = Integer.parseInt(cursorPowerProc2.getString(powerColumnIndex2));
                int currentSock2 = Integer.parseInt(cursorSocketProc2.getString(socketColumnIndex2));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock2);
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower2);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSocketProc2.close();
                cursorPowerProc2.close();
                break;


            case 3:
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                String selection3 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs3 = {"3"};

                // Делаем запрос
                Cursor cursorName3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorName3.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                txtProcName.setText(currentName3);
                txtProcSDesc.setText(currentSDesc3);
                imProc.setImageResource(R.drawable.i3_10100f);

                cursorName3.close();
                cursorSDesc3.close();

                //список столбцов
                String[] projectionProcPower3 = {DatabaseHelper.COLUMN_POWER};
                String[] projectionProcSocket3 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorPowerProc3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcPower3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorPowerProc3.moveToFirst();

                // Делаем запрос
                Cursor cursorSocketProc3 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcSocket3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSocketProc3.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex3 = cursorPowerProc3.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex3 = cursorSocketProc3.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower3 = Integer.parseInt(cursorPowerProc3.getString(powerColumnIndex3));
                int currentSock3 = Integer.parseInt(cursorSocketProc3.getString(socketColumnIndex3));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock3);
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower3);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSocketProc3.close();
                cursorPowerProc3.close();
                break;


            case 4:
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                String selection4 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs4 = {"4"};

                // Делаем запрос
                Cursor cursorName4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorName4.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                txtProcName.setText(currentName4);
                txtProcSDesc.setText(currentSDesc4);
                imProc.setImageResource(R.drawable.ryzen_5_5600x);

                cursorName4.close();
                cursorSDesc4.close();


                //список столбцов
                String[] projectionProcPower4 = {DatabaseHelper.COLUMN_POWER};
                String[] projectionProcSocket4 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorPowerProc4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcPower4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorPowerProc4.moveToFirst();

                // Делаем запрос
                Cursor cursorSocketProc4 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcSocket4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSocketProc4.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex4 = cursorPowerProc4.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex4 = cursorSocketProc4.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower4 = Integer.parseInt(cursorPowerProc4.getString(powerColumnIndex4));
                int currentSock4 = Integer.parseInt(cursorSocketProc4.getString(socketColumnIndex4));

                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock4);
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower4);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });


                cursorSocketProc4.close();
                cursorPowerProc4.close();
                break;


            case 5:
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                String selection5 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs5 = {"5"};

                // Делаем запрос
                Cursor cursorName5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionName5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorName5.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionSDesc5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                txtProcName.setText(currentName5);
                txtProcSDesc.setText(currentSDesc5);
                imProc.setImageResource(R.drawable.ryzen_9_5900x);

                cursorName5.close();
                cursorSDesc5.close();


                //список столбцов
                String[] projectionProcPower5 = {DatabaseHelper.COLUMN_POWER};
                String[] projectionProcSocket5 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorPowerProc5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcPower5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorPowerProc5.moveToFirst();

                // Делаем запрос
                Cursor cursorSocketProc5 = db.query(
                        DatabaseHelper.TABLE_PROC,
                        projectionProcSocket5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSocketProc5.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex5 = cursorPowerProc5.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex5 = cursorSocketProc5.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower5 = Integer.parseInt(cursorPowerProc5.getString(powerColumnIndex5));
                int currentSock5 = Integer.parseInt(cursorSocketProc5.getString(socketColumnIndex5));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock5);
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower5);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc5);

                db2.update(DatabaseHelper2.TABLE, cv, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSocketProc5.close();
                cursorPowerProc5.close();
                break;
        }
        db.close();
        dbData.close();
        db2.close();

    }

    public void readOhl() {
        ImageView imOhl = findViewById(R.id.imageOhlTotal);
        TextView txtOhlName = findViewById(R.id.textOhlNameTotal);
        TextView txtOhlSDesc = findViewById(R.id.textOhlDescTotal);


        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("ohlDB1");

        //создадим и откроем для чтения базу данных

        DatabaseHelper2 mDbHelper2 = new DatabaseHelper2(this);
        SQLiteDatabase db2 = mDbHelper2.getWritableDatabase();
        ContentValues cv2 = new ContentValues();

        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        DatabaseHelperData mDbHelperData = new DatabaseHelperData(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        SQLiteDatabase dbData = mDbHelperData.getWritableDatabase();
        ContentValues cv = new ContentValues();
        mDbHelper.create_db();
        db = mDbHelper.open();

        switch (value) {
            case 1:

                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                String selection1 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs1 = {"1"};

                // Делаем запрос
                Cursor cursorName1 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionName1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorName1.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc1 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionSDesc1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

                txtOhlName.setText(currentName);
                txtOhlSDesc.setText(currentSDesc);

                imOhl.setImageResource(R.drawable.deep200t);

                cursorName1.close();
                cursorSDesc1.close();


                //список столбцов
                String[] projectionOhlPower1 = {DatabaseHelper.COLUMN_POWER};

                // Делаем запрос
                Cursor cursorPowerOhl1 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionOhlPower1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorPowerOhl1.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorPowerOhl1.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower1 = Integer.parseInt(cursorPowerOhl1.getString(powerColumnIndex));



                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower1);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                cursorPowerOhl1.close();
                break;


            case 2:

                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                String selection2 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs2 = {"2"};

                // Делаем запрос
                Cursor cursorName2 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionName2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorName2.moveToFirst();


                // Делаем запрос
                Cursor cursorSDesc2 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionSDesc2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                txtOhlName.setText(currentName2);
                txtOhlSDesc.setText(currentSDesc2);
                imOhl.setImageResource(R.drawable.i250);

                cursorName2.close();
                cursorSDesc2.close();


                //список столбцов
                String[] projectionOhlPower2 = {DatabaseHelper.COLUMN_POWER};

                // Делаем запрос
                Cursor cursorPowerOhl2 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionOhlPower2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorPowerOhl2.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorPowerOhl2.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower2 = Integer.parseInt(cursorPowerOhl2.getString(powerColumnIndex2));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower2);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                cursorPowerOhl2.close();
                break;


            case 3:
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                String selection3 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs3 = {"3"};

                // Делаем запрос
                Cursor cursorName3 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionName3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorName3.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc3 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionSDesc3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                txtOhlName.setText(currentName3);
                txtOhlSDesc.setText(currentSDesc3);
                imOhl.setImageResource(R.drawable.z50);

                cursorName3.close();
                cursorSDesc3.close();

                //список столбцов
                String[] projectionOhlPower3 = {DatabaseHelper.COLUMN_POWER};

                // Делаем запрос
                Cursor cursorPowerOhl3 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionOhlPower3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorPowerOhl3.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex3 = cursorPowerOhl3.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower3 = Integer.parseInt(cursorPowerOhl3.getString(powerColumnIndex3));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower3);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                cursorPowerOhl3.close();
                break;


            case 4:
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                String selection4 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs4 = {"4"};

                // Делаем запрос
                Cursor cursorName4 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionName4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorName4.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc4 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionSDesc4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                txtOhlName.setText(currentName4);
                txtOhlSDesc.setText(currentSDesc4);
                imOhl.setImageResource(R.drawable.deep400);

                cursorName4.close();
                cursorSDesc4.close();


                //список столбцов
                String[] projectionOhlPower4 = {DatabaseHelper.COLUMN_POWER};

                // Делаем запрос
                Cursor cursorPowerOhl4 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionOhlPower4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorPowerOhl4.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex4 = cursorPowerOhl4.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower4 = Integer.parseInt(cursorPowerOhl4.getString(powerColumnIndex4));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower4);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                cursorPowerOhl4.close();
                break;


            case 5:
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                String selection5 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs5 = {"5"};

                // Делаем запрос
                Cursor cursorName5 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionName5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorName5.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc5 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionSDesc5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                txtOhlName.setText(currentName5);
                txtOhlSDesc.setText(currentSDesc5);
                imOhl.setImageResource(R.drawable.assassin3);

                cursorName5.close();
                cursorSDesc5.close();


                //список столбцов
                String[] projectionOhlPower5 = {DatabaseHelper.COLUMN_POWER};

                // Делаем запрос
                Cursor cursorPowerOhl5 = db.query(
                        DatabaseHelper.TABLE_OHL,
                        projectionOhlPower5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorPowerOhl5.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex5 = cursorPowerOhl5.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower5 = Integer.parseInt(cursorPowerOhl5.getString(powerColumnIndex5));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower5);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc5);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                cursorPowerOhl5.close();
                break;


        }
        db.close();
        db2.close();
        dbData.close();
    }

    public void readMom() {
        ImageView imMom = findViewById(R.id.imageMomTotal);
        TextView txtMomName = findViewById(R.id.textMomNameTotal);
        TextView txtMomSDesc = findViewById(R.id.textMomDescTotal);


        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("momDB1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper2 mDbHelper2 = new DatabaseHelper2(this);
        SQLiteDatabase db2 = mDbHelper2.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        DatabaseHelperData mDbHelperData = new DatabaseHelperData(getApplicationContext());
        SQLiteDatabase dbData = mDbHelperData.getWritableDatabase();
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        mDbHelper.create_db();
        db = mDbHelper.open();

        switch (value) {
            case 1:

                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                String selection1 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs1 = {"1"};

                // Делаем запрос
                Cursor cursorName1 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionName1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorName1.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc1 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionSDesc1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

                txtMomName.setText(currentName);
                txtMomSDesc.setText(currentSDesc);
                imMom.setImageResource(R.drawable.h410m);

                cursorName1.close();
                cursorSDesc1.close();


                //список столбцов
                String[] projectionMomSock1 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorSockMom1 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionMomSock1,
                        selection1,
                        selectionArgs1,
                        null,
                        null,
                        null,
                        null);
                cursorSockMom1.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorSockMom1.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock1 = Integer.parseInt(cursorSockMom1.getString(powerColumnIndex));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock1);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSockMom1.close();
                break;


            case 2:

                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                String selection2 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs2 = {"2"};

                // Делаем запрос
                Cursor cursorName2 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionName2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorName2.moveToFirst();


                // Делаем запрос
                Cursor cursorSDesc2 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionSDesc2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                txtMomName.setText(currentName2);
                txtMomName.setText(currentSDesc2);
                imMom.setImageResource(R.drawable.b550);

                cursorName2.close();
                cursorSDesc2.close();


                //список столбцов
                String[] projectionMomSock2 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorSockMom2 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionMomSock2,
                        selection2,
                        selectionArgs2,
                        null,
                        null,
                        null,
                        null);
                cursorSockMom2.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorSockMom2.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock2 = Integer.parseInt(cursorSockMom2.getString(powerColumnIndex2));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock2);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSockMom2.close();
                break;


            case 3:
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                String selection3 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs3 = {"3"};

                // Делаем запрос
                Cursor cursorName3 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionName3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorName3.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc3 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionSDesc3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                txtMomName.setText(currentName3);
                txtMomSDesc.setText(currentSDesc3);
                imMom.setImageResource(R.drawable.z690);

                cursorName3.close();
                cursorSDesc3.close();

                //список столбцов
                String[] projectionMomSock3 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorSockMom3 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionMomSock3,
                        selection3,
                        selectionArgs3,
                        null,
                        null,
                        null,
                        null);
                cursorSockMom3.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex3 = cursorSockMom3.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock3 = Integer.parseInt(cursorSockMom3.getString(sockColumnIndex3));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock3);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSockMom3.close();
                break;


            case 4:
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                String selection4 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs4 = {"4"};

                // Делаем запрос
                Cursor cursorName4 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionName4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorName4.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc4 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionSDesc4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                txtMomName.setText(currentName4);
                txtMomSDesc.setText(currentSDesc4);
                imMom.setImageResource(R.drawable.b560m);

                cursorName4.close();
                cursorSDesc4.close();


                //список столбцов
                String[] projectionMomSock4 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorSockMom4 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionMomSock4,
                        selection4,
                        selectionArgs4,
                        null,
                        null,
                        null,
                        null);
                cursorSockMom4.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex4 = cursorSockMom4.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock4 = Integer.parseInt(cursorSockMom4.getString(sockColumnIndex4));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock4);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSockMom4.close();
                break;


            case 5:
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                String selection5 = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs5 = {"5"};

                // Делаем запрос
                Cursor cursorName5 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionName5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorName5.moveToFirst();

                // Делаем запрос
                Cursor cursorSDesc5 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionSDesc5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                txtMomName.setText(currentName5);
                txtMomSDesc.setText(currentSDesc5);
                imMom.setImageResource(R.drawable.b450a);

                cursorName5.close();
                cursorSDesc5.close();


                //список столбцов
                String[] projectionMomSock5 = {DatabaseHelper.COLUMN_SOCK};

                // Делаем запрос
                Cursor cursorSockMom5 = db.query(
                        DatabaseHelper.TABLE_MOM,
                        projectionMomSock5,
                        selection5,
                        selectionArgs5,
                        null,
                        null,
                        null,
                        null);
                cursorSockMom5.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex5 = cursorSockMom5.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentSock5 = Integer.parseInt(cursorSockMom5.getString(sockColumnIndex5));


                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock5);

                dbData.update(DatabaseHelperData.TABLE_DATA, cv, DatabaseHelperData.COLUMN_ID + "= ?", new String[] { "1" });


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc5);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "= ?", new String[] { "1" });

                cursorSockMom5.close();
                break;


        }
        db.close();
        db2.close();
        dbData.close();
    }
}