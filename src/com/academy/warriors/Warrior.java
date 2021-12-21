package com.academy.warriors;

import java.util.Objects;

public class Warrior {
    protected int health = 50;
    private int attack = 5;
    private Warrior warriorBehind;

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public Warrior(int attack) {
        this.attack = attack;
    }

    public Warrior() {this(50, 5);}

    public static Warrior of(String classType) {
        Warrior warrior = null;
            if (classType.equals("Warrior"))
             warrior = new Warrior();
            else if (classType.equals("Knight"))
                warrior = new Knight();
            else if (classType.equals("Defender"))
                warrior = new Defender();
            else if (classType.equals("Vampire"))
                warrior = new Vampire();
            else if (classType.equals("Lancer"))
                warrior = new Lancer();
            else if (classType.equals("Warlord"))
                warrior = new Warlord();
            else if (classType.equals("Healer"))
                warrior = new Healer();
            else
                throw new IllegalArgumentException("Incorrect warrior type : " + classType);

            return warrior;
    }

    protected Warrior getWarriorBehind() {
        return warriorBehind;
    }

    public void setWarriorBehind(Warrior warriorBehind) {
        this.warriorBehind = warriorBehind;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(Warrior defender) {defender.getKick(this);}

    public boolean isAlive() { return health > 0; }

    public void getKick(Warrior warrior) {
        setHealth(getHealth() - warrior.getAttack());
    }

    protected void getSecondKick(int damage) {
        setHealth(getHealth() - damage);
    }

    public void handleSignal(Warrior warrior) {
        if(Objects.nonNull(this.getWarriorBehind())) {
            this.getWarriorBehind().transmitSignal();
        }
    }

    public void transmitSignal(){
        if (Objects.nonNull(this.getWarriorBehind())) {
            this.getWarriorBehind().handleSignal(this);
        }
    }
}
