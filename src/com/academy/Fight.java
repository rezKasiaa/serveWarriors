package com.academy;

import com.academy.warriors.Warrior;

public class Fight {
    public static boolean fight(Warrior a, Warrior b) {
      boolean flag = true;

      while (a.isAlive() && b.isAlive()) {
          if (flag) {
              a.attack(b);
              flag = false;
          } else {
              b.attack(a);
              flag = true;
          }
      }

        return a.isAlive();
    }

    public static boolean armyFight(Army a, Army b) {
        while (a.isAlive() && b.isAlive()) {
            boolean isAWon = fight(a.getFirst(), b.getFirst());
                if (isAWon) {
                    b.getDead();
                } else {
                    a.getDead();
                }
        }
        return a.isAlive();
    }
}
