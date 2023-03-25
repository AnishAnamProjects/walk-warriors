package com.example.walkwarriors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

   private TextView heroStats;
   private ImageView sprite;
   private Button switchSprites;
    private Button equipmentButton;
    private ProgressBar levelBar;
    private Hero mainCharacter;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sprite_switch:
                return true;
            case R.id.equipment:
                return true;
            case R.id.weapon_summon:
                return true;
            case R.id.weekly_goals:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}