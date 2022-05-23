package com.example.ompatibility;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.ompatibility.db.DatabaseHelper;
import com.example.ompatibility.db.DatabaseHelper2;
import com.example.ompatibility.db.DatabaseHelperData;

public class MainActivity2 extends AppCompatActivity {

    ContentValues cv = new ContentValues();
    ContentValues cv2 = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);




        //связывание элементов по id
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
        ImageView imProc = findViewById(R.id.imageProc);
        ImageView imOhl = findViewById(R.id.imageOhl);
        ImageView imMom = findViewById(R.id.imageMom);







            DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(this);
            SQLiteDatabase db2 = databaseHelper2.getReadableDatabase();

            //список столбцов
            String[] projectionProcName = {DatabaseHelper2.COLUMN_PROCNAME};
            String[] projectionProcSDesc = {DatabaseHelper2.COLUMN_PROCSDESC};
            String[] projectionOhlName = {DatabaseHelper2.COLUMN_OHLNAME};
            String[] projectionOhlSDesc = {DatabaseHelper2.COLUMN_OHLSDESC};
            String[] projectionMomName = {DatabaseHelper2.COLUMN_MOMNAME};
            String[] projectionMomSDesc = {DatabaseHelper2.COLUMN_MOMSDESC};

            //список столбцов
        String[] projectionOhlIm = {DatabaseHelper2.COLUMN_OHLIM};
        String[] projectionMomIm = {DatabaseHelper2.COLUMN_MOMIM};
        String[] projectionProcIm = {DatabaseHelper2.COLUMN_PROCIM};

            //значение
            String selection = DatabaseHelper.COLUMN_ID + "=?";
            String[] selectionArgs = {"1"};

            // Делаем запрос
            Cursor cursorProcName = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionProcName,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorProcName.moveToFirst();

            // Делаем запрос
            Cursor cursorProcSDesc = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionProcSDesc,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorProcSDesc.moveToFirst();

        // Делаем запрос
        Cursor cursorProcIm = db2.query(
                DatabaseHelper2.TABLE,
                projectionProcIm,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        //ставим курсор на первую строку
        cursorProcIm.moveToFirst();

            // Делаем запрос
            Cursor cursorOhlName = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionOhlName,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorOhlName.moveToFirst();

            // Делаем запрос
            Cursor cursorOhlSDesc = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionOhlSDesc,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorOhlSDesc.moveToFirst();

        // Делаем запрос
        Cursor cursorOhlIm = db2.query(
                DatabaseHelper2.TABLE,
                projectionOhlIm,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        //ставим курсор на первую строку
        cursorOhlIm.moveToFirst();

            // Делаем запрос
            Cursor cursorMomName = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionMomName,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorMomName.moveToFirst();

            // Делаем запрос
            Cursor cursorMomSDesc = db2.query(
                    DatabaseHelper2.TABLE,
                    projectionMomSDesc,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null,
                    null);
            //ставим курсор на первую строку
            cursorMomSDesc.moveToFirst();

        // Делаем запрос
        Cursor cursorMomIm = db2.query(
                DatabaseHelper2.TABLE,
                projectionMomIm,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        //ставим курсор на первую строку
        cursorMomIm.moveToFirst();

            // Используем индекс для получения строки или числа
            int procNameIndex = cursorProcName.getColumnIndex(DatabaseHelper2.COLUMN_PROCNAME);
            String currentProcName = cursorProcName.getString(procNameIndex);
            int procSDescIndex = cursorProcSDesc.getColumnIndex(DatabaseHelper2.COLUMN_PROCSDESC);
            String currentProcSDesc = cursorProcSDesc.getString(procSDescIndex);
            int ohlNameIndex = cursorOhlName.getColumnIndex(DatabaseHelper2.COLUMN_OHLNAME);
            String currentOhlName = cursorOhlName.getString(ohlNameIndex);
            int ohlSDescIndex = cursorOhlSDesc.getColumnIndex(DatabaseHelper2.COLUMN_OHLSDESC);
            String currentOhlSDesc = cursorOhlSDesc.getString(ohlSDescIndex);
            int momNameIndex = cursorMomName.getColumnIndex(DatabaseHelper2.COLUMN_MOMNAME);
            String currentMomName = cursorMomName.getString(momNameIndex);
            int momSDescIndex = cursorMomSDesc.getColumnIndex(DatabaseHelper2.COLUMN_MOMSDESC);
            String currentMomSDesc = cursorMomSDesc.getString(momSDescIndex);
            int procImIndex = cursorProcIm.getColumnIndex(DatabaseHelper2.COLUMN_PROCIM);
            int currentProcIm = cursorProcIm.getInt(procImIndex);
            int ohlImIndex = cursorOhlIm.getColumnIndex(DatabaseHelper2.COLUMN_OHLIM);
            int currentOhlIm = cursorOhlIm.getInt(ohlImIndex);
            int momImIndex = cursorMomIm.getColumnIndex(DatabaseHelper2.COLUMN_MOMIM);
            int currentMomIm = cursorMomIm.getInt(momImIndex);

            //передаем значения в элементы
            txtProcName.setText(currentProcName);
            txtProcSDesc.setText(currentProcSDesc);
            txtOhlName.setText(currentOhlName);
            txtOhlSDesc.setText(currentOhlSDesc);
            txtMomName.setText(currentMomName);
            txtMomSDesc.setText(currentMomSDesc);

            switch (currentProcIm){
                case 0:
                    imProc.setImageResource(R.drawable.r);
                    break;
                case 1:
                    imProc.setImageResource(R.drawable.i5_11400f);
                    break;
                case 2:
                    imProc.setImageResource(R.drawable.i9_12900k);
                    break;
                case 3:
                    imProc.setImageResource(R.drawable.i3_10100f);
                    break;
                case 4:
                    imProc.setImageResource(R.drawable.ryzen_5_5600x);
                    break;
                case 5:
                    imProc.setImageResource(R.drawable.ryzen_9_5900x);
                    break;
            }

        switch (currentOhlIm){
            case 0:
                imOhl.setImageResource(R.drawable.r);
                break;
            case 1:
                imOhl.setImageResource(R.drawable.deep200t);
                break;
            case 2:
                imOhl.setImageResource(R.drawable.i250);
                break;
            case 3:
                imOhl.setImageResource(R.drawable.z50);
                break;
            case 4:
                imOhl.setImageResource(R.drawable.deep400);
                break;
            case 5:
                imOhl.setImageResource(R.drawable.assassin3);
                break;
        }

        switch (currentMomIm){
            case 0:
                imMom.setImageResource(R.drawable.r);
                break;
            case 1:
                imMom.setImageResource(R.drawable.h410m);
                break;
            case 2:
                imMom.setImageResource(R.drawable.b550);
                break;
            case 3:
                imMom.setImageResource(R.drawable.z690);
                break;
            case 4:
                imMom.setImageResource(R.drawable.b560m);
                break;
            case 5:
                imMom.setImageResource(R.drawable.b450a);
                break;
        }




            //закрываем курсоры и бд
            cursorProcName.close();
            cursorProcSDesc.close();
            cursorOhlName.close();
            cursorOhlSDesc.close();
            cursorMomName.close();
            cursorMomSDesc.close();
            db2.close();



        //обработка нажатия на кнопку получения итога
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //создаем всплювающее окно
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();

                DatabaseHelperData databaseHelperData = new DatabaseHelperData(getApplicationContext());
                SQLiteDatabase dbData = databaseHelperData.getReadableDatabase();

                //список столбцов
                String[] projectionProcPower = {DatabaseHelperData.COLUMN_PROCPOWER};
                String[] projectionProcSock = {DatabaseHelperData.COLUMN_PROCSOCK};
                String[] projectionOhlPower = {DatabaseHelperData.COLUMN_OHLPOWER};
                String[] projectionMomSock = {DatabaseHelperData.COLUMN_MOMSOCK};

                //значение
                String selection = DatabaseHelper.COLUMN_ID + "=?";
                String[] selectionArgs = {"1"};

                // Делаем запрос
                Cursor cursorProcPower = dbData.query(
                        DatabaseHelperData.TABLE,
                        projectionProcPower,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                //ставим курсор на первую строку
                cursorProcPower.moveToFirst();

                // Делаем запрос
                Cursor cursorProcSock = dbData.query(
                        DatabaseHelperData.TABLE,
                        projectionProcSock,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                //ставим курсор на первую строку
                cursorProcSock.moveToFirst();

                // Делаем запрос
                Cursor cursorOhlPower = dbData.query(
                        DatabaseHelperData.TABLE,
                        projectionOhlPower,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                //ставим курсор на первую строку
                cursorOhlPower.moveToFirst();

                // Делаем запрос
                Cursor cursorMomSock = dbData.query(
                        DatabaseHelperData.TABLE,
                        projectionMomSock,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null,
                        null);
                //ставим курсор на первую строку
                cursorMomSock.moveToFirst();

                int procPowerIndex = cursorProcPower.getColumnIndex(DatabaseHelperData.COLUMN_PROCPOWER);
                int currentProcPower = cursorProcPower.getInt(procPowerIndex);
                int procSockIndex = cursorProcSock.getColumnIndex(DatabaseHelperData.COLUMN_PROCSOCK);
                int currentProcSock = cursorProcSock.getInt(procSockIndex);
                int ohlPowerIndex = cursorOhlPower.getColumnIndex(DatabaseHelperData.COLUMN_OHLPOWER);
                int currentOhlPower = cursorOhlPower.getInt(ohlPowerIndex);
                int momSockIndex = cursorMomSock.getColumnIndex(DatabaseHelperData.COLUMN_MOMSOCK);
                int currentMomSock = cursorMomSock.getInt(momSockIndex);


                //делаем проверку на совместимость
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

                //закрываем курсоры и бд
                cursorProcPower.close();
                cursorProcSock.close();
                cursorOhlPower.close();
                cursorMomSock.close();
                dbData.close();
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
    }




    public void readProc(){

        //связываем по id
        ImageView imProc = findViewById(R.id.imageProc);

        TextView txtProcName = findViewById(R.id.textProcNameTotal);
        TextView txtProcSDesc = findViewById(R.id.textProcDescTotal);

        //получаем интент
        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("procDB1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(getApplicationContext());
        SQLiteDatabase db2 = databaseHelper2.getWritableDatabase();

        DatabaseHelperData databaseHelperData = new DatabaseHelperData(this);
        SQLiteDatabase dbData = databaseHelperData.getWritableDatabase();

        mDbHelper.create_db();
        db = mDbHelper.open();

        //делаем действия при переходе на этот экран
        switch (value) {
            case 1:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

                //передаем значения в элементы
                txtProcName.setText(currentName);
                txtProcSDesc.setText(currentSDesc);
                imProc.setImageResource(R.drawable.i5_11400f);


                //закрываем курсоры
                cursorName1.close();
                cursorSDesc1.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSocketProc1.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorPowerProc1.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex = cursorSocketProc1.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower1 = Integer.parseInt(cursorPowerProc1.getString(powerColumnIndex));
                int currentSock1 = Integer.parseInt(cursorSocketProc1.getString(socketColumnIndex));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower1);
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock1);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);


                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc);
                cv2.put(DatabaseHelper2.COLUMN_PROCIM, 1);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);




                //закрываем курсоры
                cursorSocketProc1.close();
                cursorPowerProc1.close();
                break;


            case 2:
            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);
                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                //передаем значения в элементы
                txtProcName.setText(currentName2);
                txtProcSDesc.setText(currentSDesc2);
                imProc.setImageResource(R.drawable.i9_12900k);

                //закрываем курсоры
                cursorName2.close();
                cursorSDesc2.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSocketProc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorPowerProc2.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex2 = cursorSocketProc2.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower2 = Integer.parseInt(cursorPowerProc2.getString(powerColumnIndex2));
                int currentSock2 = Integer.parseInt(cursorSocketProc2.getString(socketColumnIndex2));



                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower2);
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock2);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc2);
                cv2.put(DatabaseHelper2.COLUMN_PROCIM, 2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                //закрываем курсоры
                cursorSocketProc2.close();
                cursorPowerProc2.close();
                break;


            case 3:
            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                //передаем значения в элементы
                txtProcName.setText(currentName3);
                txtProcSDesc.setText(currentSDesc3);
                imProc.setImageResource(R.drawable.i3_10100f);


                //закрываем курсоры
                cursorName3.close();
                cursorSDesc3.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSocketProc3.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex3 = cursorPowerProc3.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex3 = cursorSocketProc3.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower3 = Integer.parseInt(cursorPowerProc3.getString(powerColumnIndex3));
                int currentSock3 = Integer.parseInt(cursorSocketProc3.getString(socketColumnIndex3));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower3);
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock3);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc3);
                cv2.put(DatabaseHelper2.COLUMN_PROCIM, 3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                //закрываем курсоры
                cursorSocketProc3.close();
                cursorPowerProc3.close();
                break;


            case 4:
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                //передаем значения в элементы
                txtProcName.setText(currentName4);
                txtProcSDesc.setText(currentSDesc4);
                imProc.setImageResource(R.drawable.ryzen_5_5600x);

                //закрываем курсоры
                cursorName4.close();
                cursorSDesc4.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSocketProc4.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex4 = cursorPowerProc4.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex4 = cursorSocketProc4.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower4 = Integer.parseInt(cursorPowerProc4.getString(powerColumnIndex4));
                int currentSock4 = Integer.parseInt(cursorSocketProc4.getString(socketColumnIndex4));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower4);
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock4);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc4);
                cv2.put(DatabaseHelper2.COLUMN_PROCIM, 4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);



                //закрываем курсоры
                cursorSocketProc4.close();
                cursorPowerProc4.close();
                break;


            case 5:
            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                //передаем значения в элементы
                txtProcName.setText(currentName5);
                txtProcSDesc.setText(currentSDesc5);
                imProc.setImageResource(R.drawable.ryzen_9_5900x);

                //закрываем курсоры
                cursorName5.close();
                cursorSDesc5.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSocketProc5.moveToFirst();

                // Используем индекс для получения строки или числа
                int powerColumnIndex5 = cursorPowerProc5.getColumnIndex(DatabaseHelper.COLUMN_POWER);
                int socketColumnIndex5 = cursorSocketProc5.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentPower5 = Integer.parseInt(cursorPowerProc5.getString(powerColumnIndex5));
                int currentSock5 = Integer.parseInt(cursorSocketProc5.getString(socketColumnIndex5));

                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_PROCPOWER, currentPower5);
                cv.put(DatabaseHelperData.COLUMN_PROCSOCK, currentSock5);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_PROCNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_PROCSDESC, currentSDesc5);
                cv2.put(DatabaseHelper2.COLUMN_PROCIM, 5);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);



                //закрываем курсоры
                cursorSocketProc5.close();
                cursorPowerProc5.close();
                break;
        }
        //закрываем бд
        db.close();
        dbData.close();
        db2.close();

    }

    public void readOhl() {

        //связываем по id
        ImageView imOhl = findViewById(R.id.imageOhl);
        TextView txtOhlName = findViewById(R.id.textOhlNameTotal);
        TextView txtOhlSDesc = findViewById(R.id.textOhlDescTotal);

        //получаем интент
        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("ohlDB1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(getApplicationContext());
        SQLiteDatabase db2 = databaseHelper2.getWritableDatabase();

        DatabaseHelperData databaseHelperData = new DatabaseHelperData(this);
        SQLiteDatabase dbData = databaseHelperData.getWritableDatabase();

        mDbHelper.create_db();
        db = mDbHelper.open();

        //делаем действия при переходе на этот экран
        switch (value) {
            case 1:
            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

                //передаем значения в элементы
                txtOhlName.setText(currentName);
                txtOhlSDesc.setText(currentSDesc);
                imOhl.setImageResource(R.drawable.deep200t);


                imOhl.setImageResource(R.drawable.i5_11400f);

                //закрываем курсоры
                cursorName1.close();
                cursorSDesc1.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorPowerOhl1.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorPowerOhl1.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower1 = Integer.parseInt(cursorPowerOhl1.getString(powerColumnIndex));

                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower1);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc);
                cv2.put(DatabaseHelper2.COLUMN_OHLIM, 1);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorPowerOhl1.close();
                break;


            case 2:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                //передаем значения в элементы
                txtOhlName.setText(currentName2);
                txtOhlSDesc.setText(currentSDesc2);
                imOhl.setImageResource(R.drawable.i250);

                //закрываем курсоры
                cursorName2.close();
                cursorSDesc2.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorPowerOhl2.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorPowerOhl2.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower2 = Integer.parseInt(cursorPowerOhl2.getString(powerColumnIndex2));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower2);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc2);
                cv2.put(DatabaseHelper2.COLUMN_OHLIM, 2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                //закрываем курсор
                cursorPowerOhl2.close();

                break;


            case 3:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                //передаем значения в элементы
                txtOhlName.setText(currentName3);
                txtOhlSDesc.setText(currentSDesc3);
                imOhl.setImageResource(R.drawable.z50);

                //закрываем курсоры
                cursorName3.close();
                cursorSDesc3.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorPowerOhl3.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex3 = cursorPowerOhl3.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower3 = Integer.parseInt(cursorPowerOhl3.getString(powerColumnIndex3));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower3);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc3);
                cv2.put(DatabaseHelper2.COLUMN_OHLIM, 3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);



                //закрываем курсор
                cursorPowerOhl3.close();

                break;


            case 4:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                //передаем значения в элементы
                txtOhlName.setText(currentName4);
                txtOhlSDesc.setText(currentSDesc4);
                imOhl.setImageResource(R.drawable.deep400);

                //закрываем курсоры
                cursorName4.close();
                cursorSDesc4.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorPowerOhl4.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex4 = cursorPowerOhl4.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower4 = Integer.parseInt(cursorPowerOhl4.getString(powerColumnIndex4));

                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower4);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc4);
                cv2.put(DatabaseHelper2.COLUMN_OHLIM, 4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorPowerOhl4.close();

                break;


            case 5:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                //передаем значения в элементы
                txtOhlName.setText(currentName5);
                txtOhlSDesc.setText(currentSDesc5);
                imOhl.setImageResource(R.drawable.assassin3);

                //закрываем курсоры
                cursorName5.close();
                cursorSDesc5.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorPowerOhl5.moveToFirst();


                // Используем индекс для получения строки или числа
                int powerColumnIndex5 = cursorPowerOhl5.getColumnIndex(DatabaseHelper.COLUMN_POWER);

                int currentPower5 = Integer.parseInt(cursorPowerOhl5.getString(powerColumnIndex5));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_OHLPOWER, currentPower5);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_OHLNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_OHLSDESC, currentSDesc5);
                cv2.put(DatabaseHelper2.COLUMN_OHLIM, 5);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                //закрываем курсор
                cursorPowerOhl5.close();

                break;


        }
        //закрываем бд
        db.close();
        dbData.close();
        db2.close();
    }

    public void readMom() {
        //связываем по id
        ImageView imMom = findViewById(R.id.imageMom);
        TextView txtMomName = findViewById(R.id.textMomNameTotal);
        TextView txtMomSDesc = findViewById(R.id.textMomDescTotal);

        //получаем интент
        Bundle arg1 = getIntent().getExtras();
        int value = arg1.getInt("momDB1");

        //создадим и откроем для чтения базу данных
        DatabaseHelper mDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(getApplicationContext());
        SQLiteDatabase db2 = databaseHelper2.getWritableDatabase();

        DatabaseHelperData databaseHelperData = new DatabaseHelperData(this);
        SQLiteDatabase dbData = databaseHelperData.getWritableDatabase();

        mDbHelper.create_db();
        db = mDbHelper.open();

        //делаем действия при переходе на этот экран
        switch (value) {
            case 1:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName1 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc1 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc1.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex1 = cursorName1.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex1 = cursorSDesc1.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName = cursorName1.getString(nameColumnIndex1);
                String currentSDesc = cursorSDesc1.getString(sDescColumnIndex1);

            //передаем значения в элементы
                txtMomName.setText(currentName);
                txtMomSDesc.setText(currentSDesc);
                imMom.setImageResource(R.drawable.h410m);

                //закрываем курсоры
                cursorName1.close();
                cursorSDesc1.close();

            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorSockMom1.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex = cursorSockMom1.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock1 = Integer.parseInt(cursorSockMom1.getString(powerColumnIndex));

                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock1);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc);
                cv2.put(DatabaseHelper2.COLUMN_MOMIM, 1);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);


                //закрываем курсор
                cursorSockMom1.close();
                break;


            case 2:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName2 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc2 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc2.moveToFirst();

                // Используем индекс для получения строки или числа
                int nameColumnIndex2 = cursorName2.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex2 = cursorSDesc2.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName2 = cursorName2.getString(nameColumnIndex2);
                String currentSDesc2 = cursorSDesc2.getString(sDescColumnIndex2);

                //передаем значения в элементы
                txtMomName.setText(currentName2);
                txtMomSDesc.setText(currentSDesc2);
                imMom.setImageResource(R.drawable.b550);

                //закрываем курсоры
                cursorName2.close();
                cursorSDesc2.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorSockMom2.moveToFirst();



                // Используем индекс для получения строки или числа
                int powerColumnIndex2 = cursorSockMom2.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock2 = Integer.parseInt(cursorSockMom2.getString(powerColumnIndex2));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock2);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName2);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc2);
                cv2.put(DatabaseHelper2.COLUMN_MOMIM, 2);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorSockMom2.close();

                break;


            case 3:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName3 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc3 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc3.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex3 = cursorName3.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex3 = cursorSDesc3.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName3 = cursorName3.getString(nameColumnIndex3);
                String currentSDesc3 = cursorSDesc3.getString(sDescColumnIndex3);

                //передаем значения в элементы
                txtMomName.setText(currentName3);
                txtMomSDesc.setText(currentSDesc3);
                imMom.setImageResource(R.drawable.z690);

                //закрываем курсоры
                cursorName3.close();
                cursorSDesc3.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorSockMom3.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex3 = cursorSockMom3.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock3 = Integer.parseInt(cursorSockMom3.getString(sockColumnIndex3));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock3);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName3);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc3);
                cv2.put(DatabaseHelper2.COLUMN_MOMIM, 3);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorSockMom3.close();

                break;


            case 4:

            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName4 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc4 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc4.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex4 = cursorName4.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex4 = cursorSDesc4.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName4 = cursorName4.getString(nameColumnIndex4);
                String currentSDesc4 = cursorSDesc4.getString(sDescColumnIndex4);

                //передаем значения в элементы
                txtMomName.setText(currentName4);
                txtMomSDesc.setText(currentSDesc4);
                imMom.setImageResource(R.drawable.b560m);

                //закрываем курсоры
                cursorName4.close();
                cursorSDesc4.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorSockMom4.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex4 = cursorSockMom4.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock4 = Integer.parseInt(cursorSockMom4.getString(sockColumnIndex4));


                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock4);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName4);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc4);
                cv2.put(DatabaseHelper2.COLUMN_MOMIM, 4);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorSockMom4.close();

                break;


            case 5:
            //получаем значения для передачи в элементы
                //список столбцов
                String[] projectionName5 = {DatabaseHelper.COLUMN_NAME};
                String[] projectionSDesc5 = {DatabaseHelper.COLUMN_SDESC};

                //значение
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
                //ставим курсор на первую строку
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
                //ставим курсор на первую строку
                cursorSDesc5.moveToFirst();


                // Используем индекс для получения строки или числа
                int nameColumnIndex5 = cursorName5.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int sDescColumnIndex5 = cursorSDesc5.getColumnIndex(DatabaseHelper.COLUMN_SDESC);

                String currentName5 = cursorName5.getString(nameColumnIndex5);
                String currentSDesc5 = cursorSDesc5.getString(sDescColumnIndex5);

                //передаем значения в элементы
                txtMomName.setText(currentName5);
                txtMomSDesc.setText(currentSDesc5);
                imMom.setImageResource(R.drawable.b450a);

                //закрываем курсоры
                cursorName5.close();
                cursorSDesc5.close();


            //получаем значения для реализации проверки
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
                //ставим курсор на первую строку
                cursorSockMom5.moveToFirst();


                // Используем индекс для получения строки или числа
                int sockColumnIndex5 = cursorSockMom5.getColumnIndex(DatabaseHelper.COLUMN_SOCK);

                int currentSock5 = Integer.parseInt(cursorSockMom5.getString(sockColumnIndex5));

                //кладем значения в бд
                cv.clear();
                cv.put(DatabaseHelperData.COLUMN_MOMSOCK, currentSock5);

                dbData.update(DatabaseHelperData.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + 1, null);

                cv2.clear();
                cv2.put(DatabaseHelper2.COLUMN_MOMNAME, currentName5);
                cv2.put(DatabaseHelper2.COLUMN_MOMSDESC, currentSDesc5);
                cv2.put(DatabaseHelper2.COLUMN_MOMIM, 5);

                db2.update(DatabaseHelper2.TABLE, cv2, DatabaseHelper2.COLUMN_ID + "=" + 1, null);

                //закрываем курсор
                cursorSockMom5.close();

                break;


        }
        //закрываем бд
        db.close();
        dbData.close();
        db2.close();
    }
}