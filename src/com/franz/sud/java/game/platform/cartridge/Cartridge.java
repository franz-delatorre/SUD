package com.franz.sud.java.game.platform.cartridge;

public interface Cartridge {
    void init();
    void start();
    boolean isFinished();
    String getGameName();
}
