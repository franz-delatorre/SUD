package com.franz.java.game.cartridge.nfs;

import com.franz.java.game.platform.racing.Raceable;

public class NeedForSpeed implements Raceable {
    private final String name = "Need for Speed";

    @Override
    public boolean reachedFinishLine() {
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
