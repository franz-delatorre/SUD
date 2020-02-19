package com.franz.java.game.cartridge.rainbowsix;

import com.franz.java.game.platform.dungeoncrawler.DungeonCrawler;

public class RainbowSix implements DungeonCrawler {
    private final String name = "Rainbow Six";

    @Override
    public boolean finalBossIsAlive() {
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getGameName() {
        return name;
    }
}
