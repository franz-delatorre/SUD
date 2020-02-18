package com.franz.sud.java.game.platform.cartridge.castlevania.elements.unit;

import com.franz.sud.java.game.platform.components.Skill;

public class SkilledEnemy extends Enemy implements Skillable {
    private Skill skill;

    public static class Builder extends GameUnit.Builder<Builder> {
        private Skill skill;

        public Builder(String name) {
            super(name);
            skill = null;
        }

        public Builder skill(Skill skill) {
            this.skill = skill;
            return self();
        }

        @Override
        public SkilledEnemy build() {
            return new SkilledEnemy(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private SkilledEnemy(Builder builder) {
        super(builder);
        skill = builder.skill;
    }

    @Override
    public String getSkillName() {
        return skill.getName();
    }

    @Override
    public void useSkill(GameUnit victim) {
        skill.skillEffect(this, victim);
    }

    @Override
    public void setCooldown(int cd) {
        skill.setCooldown(cd);
    }

    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public boolean skillOnCooldown() {
        return skill.getCooldown() > 0;
    }

    public Skill getSkill() {
        return skill;
    }
}
