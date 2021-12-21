package com.academy.warriors;

public class Warlord extends Defender {
    public static final int MAX_HEALTH = 100;
    public static final int ATTACK = 4;
    public static final int DEFENSE = 2;

    @Override
    protected int getDefaultHealth() {
        return MAX_HEALTH;
    }

    @Override
    protected int getDefaultAttack() {
        return ATTACK;
    }

    @Override
    protected int getDefaultDefense() {
        return DEFENSE;
    }
}
