package com.academy;

public class Defender extends Warrior {
    private int defense = 2;
    private int health = 60;
    private int attack = 3;

    @Override
    public void getKick(Warrior warrior){
        health -= warrior.getAttack() - defense;
    }
}
