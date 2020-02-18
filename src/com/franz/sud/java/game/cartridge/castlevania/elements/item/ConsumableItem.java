package com.franz.sud.java.game.cartridge.castlevania.elements.item;

public class ConsumableItem  extends AttributedItem{
    private int count;

    public static class Builder extends AttributedItem.Builder<Builder> {
        private ConsumableItemTier tier;

        public Builder(String name) {
            super(name);
        }

        public Builder tier(ConsumableItemTier tier) {
            this.tier = tier;
            return self();
        }

        @Override
        public ConsumableItem build() {
            return new ConsumableItem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    
    private ConsumableItem(Builder builder) {
        super(builder);
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count--;
    }
}
