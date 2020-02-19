package com.franz.sud.java.game.platform.racing.components;

import com.franz.sud.java.game.platform.racing.Raceable;

public class RacingManager implements Raceable {
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
        return null;
    }
}
