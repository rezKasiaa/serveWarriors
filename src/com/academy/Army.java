package com.academy;

import com.academy.warriors.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Army extends Warrior {
    List<Warrior> army = new ArrayList<>();

    public Army() {}

    protected List<Warrior> getArmy() {
        return List.copyOf(army);
    }

    Army addUnits(String warrior, int amountOfUnits) {
        for (int i = 0; i < amountOfUnits; i++) {
            army.add(Warrior.of(warrior));
            if (i > 0 && i < amountOfUnits - 1) {
                army.get(i - 1).setWarriorBehind(army.get(i));
            }
        }
        return this;
    }

    @Override
    public boolean isAlive() { return !army.isEmpty(); }

    public Warrior getFirst() {
        return army.get(0);
    }

    public void getDead(){
        if (!army.isEmpty()) {
            army.remove(0);
        }
    }

    @Override
    public void getKick(Warrior warrior) {
        if (!army.isEmpty()) {
            army.get(0).getKick(warrior);
        }
    }
}
