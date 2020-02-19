package com.franz.java.game.cartridge.castlevania.elements.skill;

import com.franz.java.game.cartridge.castlevania.elements.unit.GameUnit;
import com.franz.java.game.cartridge.castlevania.io.IO;
import com.franz.java.game.platform.dungeoncrawler.components.Skill;

public class ChaosStrike extends Skill {
    public ChaosStrike(String name) {
        this.name = name;
    }

    /**
     * Deals 4 times the maximum damage of the user.
     * @param user
     * @param victim
     */
    @Override
    public void skillEffect(GameUnit user, GameUnit victim) {
        int damage = user.getDamage() * 4;
        victim.takeDamage(damage);
        IO.printDamage(damage);
    }
}
