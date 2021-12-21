package com.academy;

import com.academy.warriors.Knight;
import com.academy.warriors.Warrior;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


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
        boolean fightResult = Fight.fight(ben, sem);

        assertFalse(fightResult);
    }

    @org.junit.jupiter.api.Test
    void knight_warrior_first_win() {
        Warrior ben = new Knight();
        Warrior sem = new Warrior();
        boolean fightResult = Fight.fight(ben, sem);

        assertTrue(fightResult);
    }

    @org.junit.jupiter.api.Test
    void warrior_warrior_first_warrior_win() {
        Warrior ben = new Warrior();
        Warrior sem = new Warrior();
        boolean fightResult = Fight.fight(ben, sem);

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
        army1.addUnits("Warrior", 2);
        Army army2 = new Army();
        army2.addUnits("Knight", 2);

        boolean army1Fail = new Fight().armyFight(army1, army2);
        assertFalse(army1Fail);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_warrior_army_first_win() {
        Army army1 = new Army();
        army1.addUnits("Warrior", 2);
        Army army2 = new Army();
        army2.addUnits("Warrior", 2);

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }

    @org.junit.jupiter.api.Test
    void knight_army_knight_army_first_win() {
        Army army1 = new Army();
        army1.addUnits("Knight", 3);
        Army army2 = new Army();
        army2.addUnits("Knight", 3);

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_knight_army_first_fail() {
        Army army1 = new Army();
        army1.addUnits("Warrior", 40);
        Army army2 = new Army();
        army2.addUnits("Knight", 37);

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertFalse(army1Win);
    }

    @org.junit.jupiter.api.Test
    void warrior_army_small_knight_army_first_win() {
        Army army1 = new Army();
        army1.addUnits("Warrior", 3);
        Army army2 = new Army();
        army2.addUnits("Knight", 2);

        boolean army1Win = new Fight().armyFight(army1, army2);
        assertTrue(army1Win);
    }

    @ParameterizedTest
    @MethodSource("WarriorKnightDefender")
    void parametrizedFight_1(Army army1, Army army2, boolean expectedResult) {
        assertEquals(expectedResult, Fight.armyFight(army1,army2));
    }

    @ParameterizedTest
    @MethodSource("VampireLancer")
    void parametrizedFight_2(Army army1, Army army2, boolean expectedResult) {
        assertEquals(expectedResult, Fight.armyFight(army1,army2));
    }

    private static Stream<Arguments> VampireLancer() {
        return Stream.of(
                Arguments.of(new Army().addUnits("Vampire", 6)
                                .addUnits("Warrior", 7)
                                .addUnits("Defender", 1),
                        new Army().addUnits("Warrior", 6)
                                .addUnits("Defender", 6)
                                .addUnits("Vampire", 6)
                        , false),

                Arguments.of(new Army().addUnits("Vampire", 3)
                                .addUnits("Warrior", 4),
                        new Army().addUnits("Warrior", 4)
                                .addUnits("Defender", 4)
                                .addUnits("Vampire", 3)
                        , false),

                Arguments.of(new Army().addUnits("Defender", 11)
                                .addUnits("Vampire", 3)
                                .addUnits("Warrior", 4),
                        new Army().addUnits("Warrior", 4)
                                .addUnits("Defender", 4)
                                .addUnits("Vampire", 13)
                        , true),

                Arguments.of(new Army().addUnits("Vampire", 3)
                                .addUnits("Warrior", 8),
                        new Army().addUnits("Warrior", 4)
                                .addUnits("Defender", 4)
                                .addUnits("Vampire", 13)
                        , true)
        );
    }


    private static Stream<Arguments> WarriorKnightDefender() {
        return Stream.of(
           Arguments.of(new Army().addUnits("Warrior", 11),
                   new Army().addUnits("Warrior", 7), true),

                Arguments.of(new Army().addUnits("Warrior", 10),
                        new Army().addUnits("Warrior", 11), true),

                Arguments.of(new Army().addUnits("Warrior", 5)
                                .addUnits("Defender", 4),
                        new Army().addUnits("Warrior", 7), true),

                Arguments.of(new Army().addUnits("Defender", 7),
                        new Army().addUnits("Vampire", 5), true),

                Arguments.of(new Army().addUnits("Warrior", 5)
                                .addUnits("Defender", 4)
                                .addUnits("Defender", 5),
                        new Army().addUnits("Warrior", 4)
                        , true),

                Arguments.of(new Army().addUnits("Defender", 5)
                                .addUnits("Warrior", 20)
                                .addUnits("Defender", 5)
                                .addUnits("Defender", 4),
                        new Army().addUnits("Warrior", 21)
                        , true),

                Arguments.of(new Army().addUnits("Warrior", 10)
                                .addUnits("Defender", 5)
                                .addUnits("Defender", 10),
                        new Army().addUnits("Warrior", 5)
                        , true),

                Arguments.of(new Army().addUnits("Defender", 2)
                                .addUnits("Warrior", 1)
                                .addUnits("Defender", 1),
                        new Army().addUnits("Warrior", 5)
                        , false)
        );
    }
}