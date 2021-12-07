package com.academy;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Army extends Warrior {
    List<Warrior> army;

    public Army() {}

    protected List<Warrior> getArmy() {
        return List.copyOf(army);
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

    public Warrior getFirst() {
        return army.get(0);
    }

    public void getBehind() {
        for (int i = 0; i < army.size(); i++) {
            if (i == army.size()){
                army.get(i).setWarriorBehind(null);
            } else {
                army.get(i).setWarriorBehind(army.get(i++));
            }
        }
    }


    public void setArmy(List<Warrior> ... army) {
        List<Warrior> mixedTypesArmy = new LinkedList<>();
        if (army.length != 0) {
            Arrays.stream(army).forEach(x -> mixedTypesArmy.addAll(x));
            this.army = mixedTypesArmy;
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
