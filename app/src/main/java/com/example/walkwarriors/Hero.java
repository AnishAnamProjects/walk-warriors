package com.example.walkwarriors;


import java.io.Serializable;

public class Hero implements Serializable {
    private Skill heroSkill;
    private String name;
    HeroStats heroStats = new HeroStats();
    //HeroSprite Gender
    protected int heroSprite;
    protected EquipmentLibrary equipmentLibrary = new EquipmentLibrary();
    protected Equipment weapon;


    //base stats hero will be spawned with.
    public Hero(String heroName){
        name = heroName;
        heroSprite = 0;
        weapon = equipmentLibrary.getEquipments().get(0);
    }



    public Skill getHeroSkill() {
        return heroSkill;
    }

    public void setHeroSkill(Skill heroSkill) {
        this.heroSkill = heroSkill;
    }
}
