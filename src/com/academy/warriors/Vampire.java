package com.academy.warriors;

import com.academy.warriors.Warrior;

public class Vampire extends Warrior {
    private int vampirism = 50;

    public Vampire() {
        super(40, 4);
    }

    @Override
    public void attack(Warrior defender) {
       int healthScore = defender.getHealth();
       defender.getKick(this);
       healthScore = healthScore - defender.getHealth();
       setHealth(healthScore * vampirism / 100);
    }
}
