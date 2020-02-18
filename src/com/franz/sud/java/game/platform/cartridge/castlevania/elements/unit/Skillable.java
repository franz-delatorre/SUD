package com.franz.sud.java.game.platform.cartridge.castlevania.elements.unit;

public interface Skillable {
    void useSkill(GameUnit victim);
    boolean skillOnCooldown();
    void setCooldown(int cd);
    String getSkillName();
    String getUserName();
}
