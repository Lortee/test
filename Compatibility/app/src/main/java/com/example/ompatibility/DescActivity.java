package com.example.ompatibility;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        //связывание элементов по id
        TextView name = findViewById(R.id.textNameDesc);
        TextView sDesc = findViewById(R.id.textShortDesc);
        TextView desc = findViewById(R.id.textFullDesc);
        ImageView image = findViewById(R.id.imageDesc);
        Button back = findViewById(R.id.buttonBackDesc);

        //обработка нажатия на кнопку
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescActivity.this, ChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
