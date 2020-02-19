package com.franz.java.game.cartridge.castlevania.elements.stats;

import com.franz.java.game.cartridge.castlevania.helper.StatHelper;
import com.franz.java.game.platform.dungeoncrawler.components.Stats;

public class CriticalChance extends Stats {
    private boolean canCrit;

    public CriticalChance(int statValue) {
        super(statValue);
        name = "Critical Chance";
    }

    public boolean canCrit() {
        statEffect();
        return canCrit;
    }

    /**
     * Sets canCrit to true if the attack can inflict twice the damage.
     */
    @Override
    protected void statEffect() {
        canCrit = StatHelper.statEffectSuccessful(statValue);
    }
}