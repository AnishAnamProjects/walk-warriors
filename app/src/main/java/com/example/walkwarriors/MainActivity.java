package com.example.walkwarriors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;

   private TextView heroStats;
   private ImageView sprite;
   private TextView dailySteps;
   private Button switchSprites;
    private Button equipmentButton;
    private ProgressBar levelBar;
    private Hero mainCharacter;

    private TextView steps;

    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainCharacter = new Hero();
        switchSprites = (Button)findViewById(R.id.switchSprites);
        equipmentButton = (Button)findViewById(R.id.equipmentButton);
        heroStats = (TextView)findViewById(R.id.heroStats);
        levelBar = (ProgressBar)findViewById(R.id.levelTracker);
        // Hero Stats
        heroStats.setText(mainCharacter.getHeroString());
        steps = (TextView) findViewById(R.id.steps);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        dailySteps = (TextView)findViewById(R.id.dailySteps);

        // Switch Genders
        switchSprites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainCharacter.heroSprite == 0){
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_girl);
                    mainCharacter.heroSprite = 1;
                } else {
                    sprite = (ImageView)findViewById(R.id.heroSprite);
                    sprite.setImageResource(R.drawable.sprite_boy);
                    mainCharacter.heroSprite = 0;
                }
            }
        });



        // Equipment Button
        equipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEquipmentActivity();
            }
        });
    }

    private void openEquipmentActivity() {
        Intent intent  = new Intent(this, EquipmentActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(this, countSensor,SensorManager.SENSOR_DELAY_FASTEST);
            steps.setText(countSensor.getName());
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
        steps.setText("+100 bing chilling");
        if(running){
            steps.setText(String.valueOf(sensorEvent.values[0]));
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
                return true;
            case R.id.equipment:
                return true;
            case R.id.weaponSummon:
                return true;
            case R.id.weekly_goals:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}