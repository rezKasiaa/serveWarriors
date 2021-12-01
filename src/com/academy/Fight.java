package com.academy;

public class Fight {
    public boolean fight(Warrior a, Warrior b) {
      boolean flag = true;

      while (a.getHealth() > 0 && b.getHealth() > 0) {
          if (flag) {
              b.getKick(a.attack());
              flag = false;
          } else {
              a.getKick(b.attack());
              flag = true;
          }
      }

        return a.isAlive();
    }
}
