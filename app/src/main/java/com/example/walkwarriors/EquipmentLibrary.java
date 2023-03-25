package com.example.walkwarriors;

import java.util.ArrayList;

public class EquipmentLibrary {
    private ArrayList<Equipment> equipments;

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public EquipmentLibrary() {
        equipments = new ArrayList<>();
        equipments.add(new Equipment("Sword", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 1, 0));
        equipments.add(new Equipment("Spear", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 2, 0));
        equipments.add(new Equipment("Axe", Rarity.COMMON, Element.ATTACK, Type.WEAPON, 3, 0));
        equipments.add(new Equipment("Claymore", Rarity.RARE, Element.ATTACK, Type.WEAPON, 5, 0));
        equipments.add(new Equipment("Zweihander", Rarity.EPIC, Element.ATTACK, Type.WEAPON, 10, 0));

    }
}

