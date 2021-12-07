package com.academy;

public class Warrior {
    private int health = 50;
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

//    public static Warrior of(String classOf) {
//        return switch (classOf) {
//            case "Warrior" -> new Warrior();
//            case "Knight" -> new Knight();
//            case "Defender" -> new Defender();
//            case "Vampire" -> new Vampire();
//            case "Lancer" -> new Lancer();
//            default: throw new IllegalArgumentException();
//        };
//    }

    protected Warrior getWarriorBehind() {
        return warriorBehind;
    }

    protected void setWarriorBehind(Warrior warriorBehind) {
        this.warriorBehind = warriorBehind;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getHealth() {
        return health;
    }

    protected int getAttack() {
        return attack;
    }

    public void attack(Warrior defender) {
        defender.setHealth(defender.getHealth() - getAttack());
    }

    public boolean isAlive() { return health > 0; }

    protected void getKick(Warrior warrior) {
        setHealth(getHealth() - warrior.getAttack());
    }

    protected void getSecondKick(int damage) {
        setHealth(getHealth() - damage);
    }
}
