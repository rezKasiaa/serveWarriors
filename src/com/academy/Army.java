package com.academy;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Army extends Warrior {
    List<Warrior> army;

    public Army() {}

    public List<Warrior> getArmy() {
        return army;
    }

    public List<Warrior> addUnits(Class<? extends Warrior> warrior, int amountOfUnits) {
        List<Warrior> army = null;
        if (warrior.getName().equals(Warrior.class.getName())) {
            army = IntStream.rangeClosed(0, amountOfUnits - 1).mapToObj(j -> new Warrior()).collect(Collectors.toList());
        } else if (warrior.getName().equals(Knight.class.getName())) {
            army = IntStream.rangeClosed(0, amountOfUnits - 1).mapToObj(j -> new Knight()).collect(Collectors.toList());
        }

        return army;
    }

    @Override
    public boolean isAlive() { return !army.isEmpty(); }


    public void setArmy(List<Warrior> army) {
        if (!army.isEmpty()) {
            this.army = army;
        } else {
            throw new ArgumentAccessException("the army is empty!");
        }
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
