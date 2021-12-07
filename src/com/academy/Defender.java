package com.academy;

public class Defender extends Warrior {
    private int defense = 2;

    public Defender() {super(60, 3);}

    protected int getDefense() {
        return defense;
    }

    @Override
    protected void getKick(Warrior warrior){
        setHealth(getHealth() - warrior.getAttack() - getDefense());
    }
}
