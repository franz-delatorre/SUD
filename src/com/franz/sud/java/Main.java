package com.franz.sud.java;

import com.franz.sud.java.game.platform.cartridge.castlevania.Castlevania;
import com.franz.sud.java.game.platform.GameManager;

public class Main {

    public static void main(String[] args) {
        Castlevania castlevania = new Castlevania();
        GameManager gm = new GameManager();

        gm.setGame(castlevania);
        gm.startGame();
    }
}
