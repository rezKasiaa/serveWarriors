package com.academy;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @org.junit.jupiter.api.Test
    void getHealth() {
        Assert.assertEquals(50, new Warrior().getHealth());
    }

    @org.junit.jupiter.api.Test
    void getAttack() {
        Assert.assertEquals(5, new Warrior().getAttack());
    }

    @org.junit.jupiter.api.Test
    void getAttackKnight() {
        Assert.assertEquals(7, new Knight().getAttack());
    }

    @org.junit.jupiter.api.Test
    void isAlive() {
        Assert.assertEquals(true, new Warrior().isAlive());
    }

    @org.junit.jupiter.api.Test
    void warrior_knight_first_fail() {
        Warrior ben = new Warrior();
        Warrior sem = new Knight();
        boolean fightResult = new Fight().fight(ben, sem);

        assertFalse(fightResult);
    }

    @org.junit.jupiter.api.Test
    void knight_warrior_first_win() {
        Warrior ben = new Knight();
        Warrior sem = new Warrior();
        boolean fightResult = new Fight().fight(ben, sem);

        assertTrue(fightResult);
    }

    @org.junit.jupiter.api.Test
    void warrior_warrior_first_warrior_win() {
        Warrior ben = new Warrior();
        Warrior sem = new Warrior();
        boolean fightResult = new Fight().fight(ben, sem);

        assertTrue(fightResult);
    }

    @org.junit.jupiter.api.Test
    void knight_knight_first_win() {
        Warrior ben = new Knight();
        Warrior sem = new Knight();
        boolean fightResult = new Fight().fight(ben, sem);

        assertTrue(fightResult);
    }


    @org.junit.jupiter.api.Test
    void warrior_knight_warrior_fail() {
        Army army1 = new Army();
        army1.setArmy(army1.addUnits(Warrior.class, 2));
        Army army2 = new Army();
        army2.setArmy(army2.addUnits(Knight.class, 2));

        boolean army1Fail = new Fight().armyFight(army1, army2);
        assertFalse(army1Fail);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_warrior_army_first_win() {
        Army army1 = new Army();
        army1.setArmy(army1.addUnits(Warrior.class, 2));
        Army army2 = new Army();
        army2.setArmy(army2.addUnits(Warrior.class, 2));

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }

    @org.junit.jupiter.api.Test
    void knight_army_knight_army_first_win() {
        Army army1 = new Army();
        army1.setArmy(army1.addUnits(Knight.class, 3));
        Army army2 = new Army();
        army2.setArmy(army2.addUnits(Knight.class, 3));

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_knight_army_first_fail() {
        Army army1 = new Army();
        army1.setArmy(army1.addUnits(Warrior.class, 3));
        Army army2 = new Army();
        army2.setArmy(army2.addUnits(Knight.class, 3));

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertFalse(army1Win);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_small_knight_army_first_win() {
        Army army1 = new Army();
        army1.setArmy(army1.addUnits(Warrior.class, 3));
        Army army2 = new Army();
        army2.setArmy(army2.addUnits(Knight.class, 2));

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }
}