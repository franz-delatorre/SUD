package com.franz.java.game.cartridge.castlevania.elements.skill;

import com.franz.java.game.cartridge.castlevania.elements.unit.GameUnit;
import com.franz.java.game.cartridge.castlevania.io.IO;
import com.franz.java.game.platform.dungeoncrawler.components.Skill;

public class HealSkill extends Skill {
    private int healValue;

    public HealSkill(String name, int healValue) {
        this.healValue = healValue;
        this.name = name;
    }

    /**
     * Replenishes the user's current health by the healValue set.
     * @param user
     * @param victim
     */
    @Override
    public void skillEffect(GameUnit user, GameUnit victim) {
        IO.printHeal(healValue);
        user.heal(healValue);
    }
}
