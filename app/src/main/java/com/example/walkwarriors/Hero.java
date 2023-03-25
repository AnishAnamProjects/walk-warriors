package com.example.walkwarriors;


public class Hero {
    //hero states.
    //This is the health.
    private double HP;
    //This is the Raw attack damage.
    private double Attack;
    //This is a percent for defense.
    private double Defense;
    //This is to decide how goes first.
    private double Speed;
    //This is crit damage multiplier.
    private double Intelligence;
    //This is the exp for levels and the chests.
    private long Steps;
    //Hero's current level.
    private int Level;
    //Steps threshold to level up.
    private long threshold;
    //Holds equipped skill.
    private Skill heroSkill;


    //base stats hero will be spawned with.
    public Hero(){
        HP = 100;
        Attack = 20;
        Defense = 10;
        Speed = 40;
        Intelligence = 1.2;
        Steps = 0;
        Level = 0;
        threshold = 10000;

    }

    //Updates the exp of the hero to level up.
    public void UpdateSteps(long steps){
        this.Steps = steps;
    }

    //Updates the stats when hero reaches the
    // level threshold level up.
    public boolean LevelUp(String stat){

        if (Level != 100 && threshold == Steps) {
            switch (stat) {
                case "HP":
                    //This updates the value of the health with the curve (x-1)^2 when 1 => x >= 0.
                    HP = HP + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) * 100);
                    break;
                case "Attack":
                    //This updates the value of the attack.
                    Attack = Attack + ((((((Level / 100.00)) / 3.00) * (((Level / 100.00)) / 3.00)) + 0.2)) * Attack;
                    break;
                case "Defense":
                    //This updates the Defense of the hero.
                    Defense = Defense + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) / 2.00) * Defense;
                    break;
                case "Speed":
                    //This updates the speed based on the level.
                    Speed = Speed + 1.00;
                    break;
                case "Intelligence":
                    //This updates the intelligence for higher crit chance.
                    Intelligence = Intelligence + ((((Level / 100.00) - 1.00) * ((Level / 100.00) - 1.00)) / 2.00);
                    break;
            }
            Level++;
            Steps = 0;
            threshold = (long) Math.pow(1.03, Level);
            return true;
        }
        return false;
    }

    public long getThreshold() {
        return threshold;
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

    public int getLevel() {
        return Level;
    }

    public long getSteps() {
        return Steps;
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

    public void setLevel(int level) {
        Level = level;
    }

    public void setSteps(long steps) {
        Steps = steps;
    }

    public Skill getHeroSkill() {
        return heroSkill;
    }

    public void setHeroSkill(Skill heroSkill) {
        this.heroSkill = heroSkill;
    }
}
