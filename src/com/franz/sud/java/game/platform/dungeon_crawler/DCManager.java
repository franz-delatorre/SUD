package com.franz.sud.java.game.platform.dungeon_crawler;

import com.franz.sud.java.game.Cartridge;
import com.franz.sud.java.game.GameManager;
import com.franz.sud.java.game.cartridge.castlevania.DungeonCrawler;

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
