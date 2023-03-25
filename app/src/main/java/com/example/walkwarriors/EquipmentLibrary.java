package com.example.walkwarriors;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class EquipmentLibrary {
    private ArrayList<Equipment> equipments;

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public EquipmentLibrary()  {
        equipments = new ArrayList<>();
        equipments.add(new Equipment("Poison Sword", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 1, R.drawable.sword));
        equipments.add(new Equipment("Steel Trident", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 2, R.drawable.trident_2));
        equipments.add(new Equipment("Duelling Daggers", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 3, R.drawable.dagger));
        equipments.add(new Equipment("Inferno Trident", Rarity.RARE, Element.ATTACK, Type.WEAPON, 5, R.drawable.trident));
        equipments.add(new Equipment("The Last Sword", Rarity.EPIC, Element.ATTACK, Type.WEAPON, 10, R.drawable.sword));
    }
}

