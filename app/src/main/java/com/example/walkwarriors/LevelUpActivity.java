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
    HeroStats mainCharacter;

    public LevelUpActivity(HeroStats mainCharacter){
        this.mainCharacter = mainCharacter;
    }

    private void updateHeroAndFinish() {
        Intent intent  = new Intent(LevelUpActivity.this, MainActivity.class);
        intent.putExtra("hero", mainCharacter);
        setResult(RESULT_OK, intent);
        finish();
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
        mainCharacter = (HeroStats)intent.getSerializableExtra("stats");

        strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mainCharacter.LevelUp();
               updateHeroAndFinish();
            }
        });
        hitPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp();
                updateHeroAndFinish();
            }
        });
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp();
                updateHeroAndFinish();
            }
        });
        intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp();
                updateHeroAndFinish();
            }
        });
        vitality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCharacter.LevelUp();
                updateHeroAndFinish();
            }
        });
    }
    private void openMainActivity() {
        Intent intent  = new Intent(this, MainActivity.class);
        intent.putExtra("stats", mainCharacter);
        startActivity(intent);
    }
}