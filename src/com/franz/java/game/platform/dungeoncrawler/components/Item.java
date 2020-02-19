package com.franz.java.game.platform.dungeoncrawler.components;

public abstract class Item {
    private String name;
    private boolean isUsed;

    public Item(String name) {
        isUsed = false;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
