package com.example.walkwarriors;

import java.io.Serializable;

public class HeroStats  implements Serializable {
    private double HP;
    //This is the Raw attack damage.
    private double Attack;
    //This is a percent for defense.
    private double Defense;
    //This is to decide how goes first.
    private double Speed;
    //This is crit damage multiplier.
    private double Intelligence;
    private long Steps;
    //Hero's current level.
    private int Level;
    //Steps threshold to level up.
    private long threshold;

    public HeroStats(){
        HP = 100;
        Attack = 20;
        Defense = 10;
        Speed = 40;
        Intelligence = 1.2;
        Steps = 0;
        Level = 0;
        threshold = 10;
    }

    public String getHeroString(){
        String heroData = "Hero Stats:\n" +
                "Level: " + getLevel() + "\n" +
                "Health: " + getHP() + "\n" +
                "Attack: " + getAttack() + "\n" +
                "Defense: " + getDefense() + "\n" +
                "Speed: " + getSpeed() + "\n" +
                "Intelligence: " + getIntelligence() + "\n";
        return heroData;
    }
    public long getThreshold() {
        return threshold;
    }

    public int getLevel() {
        return Level;
    }

    public long getSteps() {
        return Steps;
    }


    public void setLevel(int level) {
        Level = level;
    }

    public void setSteps(long steps) {
        Steps = steps;
    }


    //Updates the exp of the hero to level up.
    public void UpdateSteps(long steps){
        this.Steps = steps;
    }

    //Updates the stats when hero reaches the
    // level threshold level up.
    public boolean LevelUp() {

        if (Level != 100 && threshold <= Steps) {
            HP = HP + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) * 100);
            //This updates the value of the attack.
                    Attack = Attack + ((((((Level / 100.00)) / 3.00) * (((Level / 100.00)) / 3.00)) + 0.2)) * Attack;
                    //This updates the Defense of the hero.
                    Defense = Defense + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) / 2.00) * Defense;
                    //This updates the speed based on the level.
                    Speed = Speed + 1.00;
                    //This updates the intelligence for higher crit chance.
                    Intelligence = Intelligence + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) / 2.00);
            Level++;
            Steps = 0;
            threshold = threshold + 15;
            return true;
            }
        return false;
    }
    public double getAttack() {
        return Attack;
    }

    public double getHP() {
        return HP;
    }

    public double getDefense() {
        return Defense;
    }

    public double getIntelligence() {
        return Intelligence;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setAttack(double attack) {
        Attack = attack;
    }

    public void setHP(double hp) {
        HP = hp;
    }

    public void setDefense(double defense) {
        Defense = defense;
    }

    public void setIntelligence(double intelligence) {
        Intelligence = intelligence;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }
}