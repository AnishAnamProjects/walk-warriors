package com.example.walkwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChangeEquipmentActivity extends AppCompatActivity {
    ListView listView;
    String currentlyEquipped;
    ArrayList<Equipment> equipments;
    String[] equipmentStrings;
    int wid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_equipment);
        Intent intent = getIntent();
        equipments = (ArrayList<Equipment>) intent.getSerializableExtra("equipments");
        equipmentStrings = new String[equipments.size()];
        for (int index = 0; index < equipments.size(); index++) {
            equipmentStrings[index] = equipments.get(index).getName();
        }
        this.currentlyEquipped = currentlyEquipped;

        listView = findViewById(R.id.equipmentsListView);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                equipmentStrings);
        listView.setAdapter(arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                wid = (int)position;
                Log.i("ChangeEquipmentActivity", "You clicked Item: " + id + " at position:" + position);
            }
        });

        Button button = (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openEquipmentActivity();
            }
        });
    }
    private void openEquipmentActivity() {
        Intent intent  = new Intent(this, EquipmentActivity.class);
        intent.putExtra("currentlyEquipped", equipments.get(wid));
        setResult(RESULT_OK, intent);
        finish();
    }
}