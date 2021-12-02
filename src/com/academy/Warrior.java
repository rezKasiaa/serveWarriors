package com.academy;

public class Warrior {
    private int health = 50;
    private int attack = 5;

    private void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }

    public boolean isAlive() { return health > 0; }

    public int attack(){
        return attack;
    }

    public void getKick(Warrior warrior){
        health -= warrior.getAttack();
    }
}
