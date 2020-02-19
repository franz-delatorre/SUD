package com.franz.java.game.platform.dungeoncrawler;

import com.franz.java.game.Cartridge;
import com.franz.java.game.GameManager;

public class DCManager implements GameManager {
    private DungeonCrawler game;

    public DCManager() {
        game = null;
    }

    @Override
    public void setGame(Cartridge cartridge) {
        if (cartridge instanceof DungeonCrawler) {
            game = (DungeonCrawler) cartridge;
        } else {
            System.out.println("Cartridge is not a Dungeon Crawler type");
        }
    }

    public void startGame() {
        if (game == null) {
            System.out.println("Please set the game cartridge");
            return;
        }
        game.init();
        game.start();

        if (game.finalBossIsAlive()) {
            System.out.println("Game Over!!");
        } else {
            System.out.println("Congratulations! You completed " + game.getGameName());
        }
    }
}
