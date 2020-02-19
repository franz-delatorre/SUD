package com.franz.sud.java;

import com.franz.sud.java.game.cartridge.castlevania.Castlevania;
import com.franz.sud.java.game.platform.dungeon_crawler.DCManager;
import com.franz.sud.java.game.cartridge.castlevania.DungeonCrawler;

public class Main {

    public static void main(String[] args) {
        DungeonCrawler castlevania = new Castlevania();
        DCManager dcManager = new DCManager();

        dcManager.setGame(castlevania);
        dcManager.startGame();
    }
}


