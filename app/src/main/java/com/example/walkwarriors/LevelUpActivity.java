package com.example.walkwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;

public class LevelUpActivity extends AppCompatActivity {

    private Button strength;
    private Button hitPoints;
    private Button speed;
    private Button intelligence;
    private Button vitality;
    Hero mainCharacter;

    public LevelUpActivity(Hero mainCharacter){
        this.mainCharacter = mainCharacter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);
        strength = (Button)findViewById(R.id.Strength);
        hitPoints = (Button)findViewById(R.id.HitPoint);
        speed = (Button)findViewById(R.id.Speed);
        intelligence = (Button)findViewById(R.id.Intelligence);
        vitality = (Button)findViewById(R.id.Vitality);
        Intent intent = getIntent();
        mainCharacter = (Hero)intent.getSerializableExtra("hero");
        strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mainCharacter.LevelUp("Attack");
            }
        });
        hitPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp("HP");
            }
        });
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp("Speed");
            }
        });
        intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp("Intelligence");
            }
        });
        vitality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp("Defense");
            }
        });
    }
    private void openMainActivity() {
        Intent intent  = new Intent(this, MainActivity.class);
        intent.putExtra("hero", mainCharacter);
        startActivity(intent);
    }
}