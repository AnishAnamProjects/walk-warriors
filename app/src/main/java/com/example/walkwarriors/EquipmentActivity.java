package com.example.walkwarriors;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EquipmentActivity extends AppCompatActivity {
    private ImageView weapon;
    private Equipment currentEquipment;
    private TextView weaponInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        Intent intent = getIntent();
        int mainWeapon;
        try {
            currentEquipment = (Equipment) intent.getSerializableExtra("equipmentID");
            mainWeapon = currentEquipment.getImage();
        } catch (Exception e) {
            mainWeapon = (int) currentEquipment.getImage();
        }
        weapon = (ImageView) findViewById(R.id.weaponView);
        weaponInfo = (TextView) findViewById(R.id.EquipmentData);
        weaponInfo.setText(currentEquipment.getEquipmentString());
        weapon.setImageResource(mainWeapon);

        Button button = (Button) findViewById(R.id.changeButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                openChangeEquipmentActivity();
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipmentActivity.this, ChangeEquipmentActivity.class);
                intent.putExtra("equipments", new EquipmentLibrary().getEquipments());
                changeEquipmentActivityResultLauncher.launch(intent);
            }
        });
    }

    private ActivityResultLauncher<Intent> changeEquipmentActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        // Do something with data
                        currentEquipment = (Equipment) data.getSerializableExtra("currentlyEquipped");
                        int mainWeapon = (int) currentEquipment.getImage();
//                        weapon = (ImageView) findViewById(R.id.weaponView);
                        weapon.setImageResource(mainWeapon);
                        weaponInfo.setText(currentEquipment.getEquipmentString());
                        Intent intent  = new Intent(EquipmentActivity.this, MainActivity.class);
                        intent.putExtra("currentlyEquipped", currentEquipment);
                        setResult(RESULT_OK, intent);
                    }
                }
            });
}