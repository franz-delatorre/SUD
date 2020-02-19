package com.franz.java;

import com.franz.java.game.GameManager;
import com.franz.java.game.cartridge.rainbowsix.RainbowSix;
import com.franz.java.game.platform.racing.Raceable;
import com.franz.java.game.platform.racing.RacingManager;
import com.franz.java.game.Cartridge;
import com.franz.java.game.cartridge.castlevania.Castlevania;
import com.franz.java.game.cartridge.nfs.NeedForSpeed;
import com.franz.java.game.platform.dungeoncrawler.DCManager;
import com.franz.java.game.platform.dungeoncrawler.DungeonCrawler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final GameManager dcManager = new DCManager();
    private static final GameManager racingManager = new RacingManager();

    public static void main(String[] args) {
        ArrayList<DungeonCrawler> dc = new ArrayList<>();
        ArrayList<Raceable> rc = new ArrayList<>();

        dc.add(new Castlevania());
        dc.add(new RainbowSix());
        rc.add(new NeedForSpeed());

        boolean exitLoop = false;
        do {
            System.out.println("Select a gaminng platform");
            System.out.println("[Q] Quit");
            System.out.println("[R] Racing");
            System.out.println("[D] Dungeon Crawler");
            Scanner sc = new Scanner(System.in);

            while (!sc.hasNextLine());
            switch (sc.nextLine().toLowerCase()) {
                case "r":
                    platformMenu(racingManager, rc);
                    break;
                case "d":
                    platformMenu(dcManager, dc);
                    break;
                case "q":
                    exitLoop = true;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        } while (!exitLoop);
    }

    private static <T extends Cartridge>void platformMenu(GameManager manager, ArrayList<T> list) {
        boolean inLoop = true;
        do {
            switch (getUserInput()) {
                case "s":
                    manager.setGame(selectGame(list));
                    break;
                case "g":
                    manager.startGame();
                    break;
                case "e":
                    inLoop = false;
                    break;
            }
        } while (inLoop);

    }

    private static <T extends Cartridge> T selectGame(ArrayList<T> items){
        T game = null;
        int index = 1;
        for (T cartridge : items) {
            System.out.println(index++ + ". " + cartridge.getGameName());
        }
        System.out.println("Select game no:");

        boolean exitLoop = false;
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt());
            int opt = sc.nextInt();
            if (opt > index - 1) {
                System.out.println("Invalid input Try Again");
            } else {
                game = items.get(opt - 1);
                System.out.println("Game is set, enjoy.");
                exitLoop = true;
            }
        } while (!exitLoop);
        return game;
    }

    private static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        boolean inLoop = true;
        String z = null;

        do {
            System.out.println("[E] Exit Platform");
            System.out.println("[S] Select Game");
            System.out.println("[G] Start Game");
            while (!sc.hasNextLine());
            switch (sc.nextLine()) {
                case "e":
                    z = "e";
                    inLoop = false;
                    break;
                case "s":
                    z = "s";
                    inLoop = false;
                    break;
                case "g":
                    z = "g";
                    inLoop = false;
                    break;
            }
        } while (inLoop);
        return z;
    }
}


