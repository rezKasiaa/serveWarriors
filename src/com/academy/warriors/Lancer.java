package com.academy.warriors;

import com.academy.warriors.Warrior;

public class Lancer extends Warrior {
    private int weakening = 50;

    public Lancer() {super(6);}

    @Override
    public void attack(Warrior defender) {
        int healthScore = defender.getHealth();
        super.attack(defender);
        healthScore = healthScore - Math.max(0, defender.getHealth());
        int secondAttack = healthScore * weakening / 100;
        defender.getSecondKick(secondAttack);
    }
}
