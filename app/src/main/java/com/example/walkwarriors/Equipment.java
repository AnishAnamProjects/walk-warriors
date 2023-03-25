package com.example.walkwarriors;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

enum Rarity {
    COMMON,
    RARE,
    EPIC
}

enum Element {
    ATTACK,
    HEALTH,
    DEFENSE,
    SPEED,
    INTELLIGENCE
}

enum Type {
    WEAPON,
    ARMOR
}

public class Equipment implements Serializable {
    private String name;
    private Rarity rarity;
    private Element element;
    private  Type type;
    private int boostValue;

    private int  image;

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Element getElement() {
        return element;
    }

    public Type getType() {
        return type;
    }

    public int getBoostValue() {
        return boostValue;
    }

    public int getImage() {
        return image;
    }

    public Equipment(String name, Rarity rarity, Element element, Type type, int boostValue, int image) {
        // https://stackoverflow.com/questions/62343576/is-it-possible-to-add-an-image-as-a-class-attribute
        this.name = name;
        this.rarity = rarity;
        this.element = element;
        this.type = type;
        this.boostValue = boostValue;
        this.image = image;
    }

    public String getEquipmentString(){
        String equipString = "Name: " + name + "\n"+
                "Rarity: " + rarity + "\n"+
                "Element: " + element + "\n"+
                "BoostValue: " + boostValue + "\n";
        return equipString;
    }
}
