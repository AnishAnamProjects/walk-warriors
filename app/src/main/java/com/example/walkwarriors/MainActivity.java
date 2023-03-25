package com.example.walkwarriors;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.Steps);
        String texto = "yolo";
        text.setText(texto);
    }
}