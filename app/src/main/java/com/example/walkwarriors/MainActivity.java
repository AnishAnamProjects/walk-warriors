package com.example.walkwarriors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;

   private TextView heroStats;
   private ImageView sprite;
   private ImageView weapon;
   private TextView dailySteps;
   private Button switchSprites;
    private Button equipmentButton;
    private ProgressBar levelBar;
    private Hero mainCharacter;

    private TextView steps;

    private int stepsTakenAtTheStart;
    private int progressSteps;

    private boolean running = false;

//    SharedPreferences setting = getApplicationContext().getSharedPreferences("main character", 0);
////    SharedPreferences.Editor editor = setting.edit();
////    editor.putInt("Startsets",(int)stepsTakenAtTheStart);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainCharacter = new Hero("HeroA");
        heroStats = (TextView)findViewById(R.id.heroStats);
        levelBar = (ProgressBar)findViewById(R.id.levelTracker);
        // Hero Stats
        heroStats.setText(mainCharacter.getHeroString());
        steps = (TextView) findViewById(R.id.steps);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        dailySteps = (TextView)findViewById(R.id.dailySteps);
        weapon = (ImageView) findViewById(R.id.weapon);
        weapon.setImageResource(mainCharacter.weapon.getImage());
    }
    // Equipment Selection
    private void openEquipmentActivity() {
        Intent intent  = new Intent(this, EquipmentActivity.class);
        intent.putExtra("equipmentID", mainCharacter.weapon.getImage());
        startActivity(intent);
    }
    // Level Up
    private void openLevelUpActivity() {
        Intent intent  = new Intent(this, LevelUpActivity.class);
        intent.putExtra("hero", mainCharacter);
        Intent i = getIntent();
        mainCharacter = (Hero)intent.getSerializableExtra("hero");
        startActivity(intent);
    }
    // Equipment Summon
    private void openEquipmentSummonActivity() {
        Intent intent  = new Intent(this, EquipmentSummon.class);
        startActivity(intent);
    }

    // Get Hero
    private Hero getMainCharacter(){
        return mainCharacter;
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(this, countSensor,SensorManager.SENSOR_DELAY_FASTEST);
        }else{
            Toast.makeText(this,"sensor not found!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        running = false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(stepsTakenAtTheStart == 0){
            stepsTakenAtTheStart = (int)sensorEvent.values[0];
        }
        if(running){
            progressSteps = ((int)sensorEvent.values[0]-stepsTakenAtTheStart);
            mainCharacter.setSteps(mainCharacter.getSteps()+progressSteps);
        }
        steps.setText(String.valueOf(mainCharacter.getSteps()) );
        stepsTakenAtTheStart = (int)sensorEvent.values[0];
        levelBar.setProgress((int)mainCharacter.getSteps());
        if(levelBar.getProgress() == 100){
            openLevelUpActivity();
            levelBar = (ProgressBar)findViewById(R.id.levelTracker);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.spriteSwitch:
                if(mainCharacter.heroSprite == 0){
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_girl);
                    mainCharacter.heroSprite = 1;
                } else {
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_boy);
                    mainCharacter.heroSprite = 0;
                }
                return true;
            case R.id.equipment:
                openEquipmentActivity();

                return true;
            case R.id.weaponSummon:
                openEquipmentSummonActivity();
                return true;
            case R.id.weekly_goals:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}