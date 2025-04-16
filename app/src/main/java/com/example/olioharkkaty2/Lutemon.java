package com.example.olioharkkaty2;


public class Lutemon {
    private int id;
    private String name;
    private String color;
    private int attack;
    private int defense;
    private int experience;
    private int health;
    private int maxHealth;

    public Lutemon(int id, String name, String color, int attack, int defense, int health) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = health;
        this.experience = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public int getAttack() { return attack + experience; }
    public int getDefense() { return defense; }
    public int getHealth() { return health; }
    public int getExperience() { return experience; }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void heal() {
        this.health = maxHealth;
    }

    public void addExperience() {
        this.experience++;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
