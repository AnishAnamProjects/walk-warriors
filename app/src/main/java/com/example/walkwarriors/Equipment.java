package com.example.walkwarriors;


import android.media.Image;

import androidx.annotation.DrawableRes;

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

public class Equipment {
    private String name;
    private Rarity rarity;
    private Element element;
    private  Type type;
    private int boostValue;
    @DrawableRes
    private int image;

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

    @DrawableRes
    public int getImage() {
        return image;
    }

    public Equipment(String name, Rarity rarity, Element element, Type type, int boostValue, @DrawableRes int image) {
        // https://stackoverflow.com/questions/62343576/is-it-possible-to-add-an-image-as-a-class-attribute
        this.name = name;
        this.rarity = rarity;
        this.element = element;
        this.type = type;
        this.boostValue = boostValue;
        this.image = image;
    }
}
