package com.academy;

public class Fight {
    public boolean fight(Warrior a, Warrior b) {
      boolean flag = true;
        System.out.println("a health :" + a.getHealth() + " b health: " + b.getHealth());

      while (a.getHealth() > 0 && b.getHealth() > 0) {
          if (flag) {
              b.getKick(a);
              System.out.println("a health :" + a.getHealth() + " b health: " + b.getHealth());
              flag = false;
          } else {
              a.getKick(b);
              System.out.println("a health :" + a.getHealth() + " b health: " + b.getHealth());
              flag = true;
          }
      }

        return a.isAlive();
    }

    public boolean armyFight(Army a, Army b) {
        System.out.println("a army : " + a.getArmy().size() + " b army : " + b.getArmy().size());
        while (a.isAlive() && b.isAlive()) {
            boolean isAWon = fight(a.getArmy().get(0), b.getArmy().get(0));
                if (isAWon) {
                    b.getDead();
                    System.out.println("a army : " + a.getArmy().size() + " b army : " + b.getArmy().size());
                } else {
                    a.getDead();
                    System.out.println("a army : " + a.getArmy().size() + " b army : " + b.getArmy().size());
                }
        }

        return a.isAlive();
    }
}
