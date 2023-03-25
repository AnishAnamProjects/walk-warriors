package com.example.walkwarriors;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class EquipmentActivity extends AppCompatActivity {
    private ImageView weapon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        Intent intent = getIntent();
        int mainWeapon = (int)intent.getSerializableExtra("equipmentID");
        weapon = (ImageView)findViewById(R.id.weaponView);
        weapon.setImageResource(mainWeapon);

    }

}