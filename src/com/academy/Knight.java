package com.academy;

public class Knight extends Warrior {
    private int attack = 7;

    @Override
    public int getAttack() {
        return attack;
    }

    public int attack(){
        return attack;
    }

    public void getKick(int attack){
        setHealth(getHealth() - attack);
    }
}
