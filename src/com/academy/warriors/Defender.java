package com.academy.warriors;

import com.academy.warriors.Warrior;

public class Defender extends Warrior {
    public static final int MAX_HEALTH = 60;
    public static final int ATTACK = 3;
    public static final int DEFENSE = 2;

    private int defense = 2;

    public Defender() {super(60, 3);}

    protected int getDefaultHealth() {
        return MAX_HEALTH;
    }

    protected int getDefaultAttack() {
        return ATTACK;
    }

    protected int getDefaultDefense() {
        return DEFENSE;
    }

    @Override
    public void getKick(Warrior warrior){
        setHealth(getHealth() - warrior.getAttack() - getDefaultDefense());
    }
}
