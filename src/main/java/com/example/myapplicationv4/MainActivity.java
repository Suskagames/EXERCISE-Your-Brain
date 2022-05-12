package com.example.myapplicationv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton = findViewById(R.id.iB1);
        ImageButton imageButton2 = findViewById(R.id.iB2);
        ImageButton imageButton3 = findViewById(R.id.iB3);

        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Sudoku.class);
            startActivity(intent);
        });
        imageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Memory.class);
            startActivity(intent);
        });
        imageButton3.setOnClickListener(v -> {
            Intent intent = new Intent(this, Mat.class);
            startActivity(intent);
        });
    }
}