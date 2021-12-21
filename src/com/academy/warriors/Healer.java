package com.academy.warriors;

import com.academy.warriors.Warrior;

public class Healer extends Warrior {
    int heal = 2;
    int attack = 0;

    public Healer() {super(60, 0);}

    public int getHeal() {
        return heal;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void handleSignal(Warrior warrior) {
        heal(warrior);
        super.transmitSignal();
    }

    private void heal(Warrior warrior) {
        warrior.setHealth((warrior.getHealth() + heal > health) ? health :  warrior.getHealth() + heal);

    }
}
