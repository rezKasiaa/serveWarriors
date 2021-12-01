package com.academy;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @org.junit.jupiter.api.Test
    void getHealth() {
    }

    @org.junit.jupiter.api.Test
    void getAttack() {
    }

    @org.junit.jupiter.api.Test
    void isAlive() {
    }

    @org.junit.jupiter.api.Test
    void fightTestWarriorKnight() {
        Warrior ben = new Warrior();
        Warrior sem = new Knight();
        boolean fightResult = new Fight().fight(ben, sem);

        assertFalse(fightResult);
    }
}