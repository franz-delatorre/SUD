package com.franz.sud.java.game;

public interface Cartridge {
    void init();
    void start();
    boolean isFinished();
    String getGameName();
}
