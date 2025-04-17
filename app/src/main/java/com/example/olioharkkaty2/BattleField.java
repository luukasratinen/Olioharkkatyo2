package com.example.olioharkkaty2;

public class BattleField {

    public String fight(Lutemon lutemon1, Lutemon lutemon2) {
        StringBuilder log = new StringBuilder();

        log.append("1: ")
                .append(getLutemonStats(1, lutemon1))
                .append("\n")
                .append("2: ")
                .append(getLutemonStats(2, lutemon2))
                .append("\n");

        while (lutemon1.isAlive() && lutemon2.isAlive()) {
            log.append(lutemon1.getName()).append(" attacks ").append(lutemon2.getName()).append("\n");
            int damage = Math.max(0, lutemon1.getAttack() - lutemon2.getDefense());
            lutemon2.takeDamage(damage);

            if (!lutemon2.isAlive()) {
                log.append(lutemon2.getName()).append(" gets killed.\n");
                lutemon1.addExperience();
                break;
            } else {
                log.append(lutemon2.getName()).append(" manages to escape death.\n");
            }

            log.append("2: ").append(getLutemonStats(2, lutemon2)).append("\n")
                    .append("1: ").append(getLutemonStats(1, lutemon1)).append("\n");

            log.append(lutemon2.getName()).append(" attacks ").append(lutemon1.getName()).append("\n");
            damage = Math.max(0, lutemon2.getAttack() - lutemon1.getDefense());
            lutemon1.takeDamage(damage);

            if (!lutemon1.isAlive()) {
                log.append(lutemon1.getName()).append(" gets killed.\n");
                lutemon2.addExperience();
                break;
            } else {
                log.append(lutemon1.getName()).append(" manages to escape death.\n");
            }

            log.append("1: ").append(getLutemonStats(1, lutemon1)).append("\n")
                    .append("2: ").append(getLutemonStats(2, lutemon2)).append("\n");
        }

        log.append("The battle is over.\n");
        return log.toString();
    }

    private String getLutemonStats(int number, Lutemon lutemon) {
        return number + ": " +
                lutemon.getColor() + "(" + lutemon.getName() + ") " +
                "att: " + lutemon.getAttack() + "; " +
                "def: " + lutemon.getDefense() + "; " +
                "exp: " + lutemon.getExperience() + "; " +
                "health: " + lutemon.getHealth() + "/" + lutemon.getMaxHealth();
    }
}
