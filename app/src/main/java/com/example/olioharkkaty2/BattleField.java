package com.example.olioharkkaty2;

public class BattleField {
    public String fight(Lutemon lutemon1, Lutemon lutemon2) {
        StringBuilder log = new StringBuilder();

        while (lutemon1.isAlive() && lutemon2.isAlive()) {
            log.append(lutemon1.getName())
                    .append(" attacks ")
                    .append(lutemon2.getName())
                    .append("\n");
            int damage = Math.max(0, (lutemon1.getAttack() + lutemon1.getExperience()) - lutemon2.getDefense());
            lutemon2.takeDamage(damage);

            if (!lutemon2.isAlive()) {
                log.append(lutemon2.getName()).append(" has died.\n");
                lutemon1.addExperience();
                break;
            }

            log.append(lutemon2.getName())
                    .append(" counterattacks ")
                    .append(lutemon1.getName())
                    .append("\n");
            damage = Math.max(0, (lutemon2.getAttack() + lutemon2.getExperience()) - lutemon1.getDefense());
            lutemon1.takeDamage(damage);

            if (!lutemon1.isAlive()) {
                log.append(lutemon1.getName()).append(" has died.\n");
                lutemon2.addExperience();
            }
        }

        return log.toString();
    }
}
