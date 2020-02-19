package com.franz.java.game.cartridge.castlevania.io;

import com.franz.java.game.cartridge.castlevania.elements.item.AttributedItem;
import com.franz.java.game.cartridge.castlevania.elements.item.ConsumableItem;
import com.franz.java.game.cartridge.castlevania.elements.item.EquipmentType;
import com.franz.java.game.cartridge.castlevania.elements.item.EquippableItem;
import com.franz.java.game.cartridge.castlevania.elements.stats.GameStats;
import com.franz.java.game.cartridge.castlevania.elements.stats.StatType;
import com.franz.java.game.cartridge.castlevania.elements.unit.GameUnit;
import com.franz.java.game.cartridge.castlevania.elements.unit.Hero;
import com.franz.java.game.cartridge.castlevania.elements.unit.Skillable;
import com.franz.java.game.cartridge.castlevania.elements.unit.SkilledEnemy;
import com.franz.java.game.platform.dungeoncrawler.components.Item;
import com.franz.java.game.platform.dungeoncrawler.components.Skill;
import com.franz.java.game.platform.dungeoncrawler.components.Stats;
import com.franz.java.game.platform.dungeoncrawler.components.Unit;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Scanner;

import static com.franz.java.game.cartridge.castlevania.io.Sleep.sleep;

public final class IO {

    public static String userInput(HashMap<String, String> option) {
        Scanner sc = new Scanner(System.in);
        String ans = null;
        boolean o = false;
        do {
            for (String string : option.keySet())
                System.out.println("[" + string.toUpperCase() + "] " + option.get(string));

            while (!sc.hasNextLine());
            String opt = sc.nextLine();
            if (option.containsKey(opt.toLowerCase()) || option.containsKey(opt.toUpperCase())) {
                ans = opt.toLowerCase();
                o = true;
            }
        } while (!o);
        return ans;
    }

    public static void printFightersHealth(GameUnit hero, GameUnit enemy) {
        System.out.println();
        sleep(1);
        System.out.println();
        System.out.println(hero.getName() + " \t\t\t\t"+ enemy.getName());
        System.out.print(hero.getCurrentHealth() + "/" + hero.getMaxHealth());
        System.out.println("\t\t\t\t\t" + enemy.getCurrentHealth() + "/" + enemy.getMaxHealth());
    }

    public static void printAttack(Unit unit) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_RESET + unit.getName() + " used normal attack." + TextColor.ANSI_BLACK);
    }

    public static void printSkillName(String userName, String skillName) {
        System.out.println();
//        sleep(1);
        System.out.println(TextColor.ANSI_PURPLE + userName + " used " + TextColor.ANSI_RED + skillName + TextColor.ANSI_BLACK);
    }

    public static void printCrit() {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_PURPLE + "Critical HIT" + TextColor.ANSI_BLACK);
    }

    public static void printEvade(Unit unit) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_PURPLE + unit.getName() + " evaded the attack" + TextColor.ANSI_BLACK);
    }

    public static void printLifesteal(int ls) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_PURPLE + ls + " lifesteal" + TextColor.ANSI_BLACK);
    }

    public static void printDamage(int damage) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_RED + damage + " damage" + TextColor.ANSI_BLACK);
    }

    public static void printStatBoost(GameStats stats) {
        System.out.println();
        for (StatType statType : StatType.values()) {
            Stats s = stats.getStat(statType);
            if (s.getStatValue() > 0) {
                sleep(1);
                System.out.println(TextColor.ANSI_BLUE + "+ " + s.getStatValue() + statType.toString() + TextColor.ANSI_BLACK);
            }
        }
    }

    public static void printWinner(Unit hero, Unit enemy) {
        System.out.println();
        sleep(1);
        if (hero.getHealth().getCurrentHealth() > 0) {
            System.out.println(TextColor.ANSI_GREEN + "You have slain " + enemy.getName() + TextColor.ANSI_BLACK);
            return;
        }

        System.out.println(TextColor.ANSI_RED + "You have been slain by " + enemy.getName() + TextColor.ANSI_BLACK);
    }

    public static void printHeal(int heal) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_GREEN + "+ " + heal + " health" + TextColor.ANSI_BLACK);
    }

    public static void printSkillCooldown(Skill skill, GameUnit enemy) {
        System.out.print("Cd: " + skill.getCooldown() + " \t\t\t\t\t");
        if (enemy instanceof Skillable) {
            System.out.print("Cd: " + ((SkilledEnemy) enemy).getSkill().getCooldown());
        }
        System.out.println();
    }

    public static <T extends AttributedItem> void showInventory(ArrayList<T> items) {
        int index = 1;
        System.out.println();
        sleep(1);
        if (items.get(0) instanceof ConsumableItem) System.out.println("Name\t\t\tAmount:");
        for (Item item : items) {
            if (item instanceof ConsumableItem) {
                int count = ((ConsumableItem) item).getCount();
                System.out.println(index++ + ". " + item.getName() + "\t\t" + count);
            } else {
                System.out.println(index++ + ". " + item.getName());
            }

        }
    }

    public static int getItemIndex(int index) {
        System.out.println();
        sleep(1);
        System.out.println("Please select an item number: ");
        Scanner s = new Scanner(System.in);

        while (!s.hasNextInt());
        int opt = s.nextInt();
        if (opt < 1 && opt > index) {
            System.out.println();
            sleep(1);
            System.out.println(TextColor.ANSI_RED + "Index is out of bounds." + TextColor.ANSI_BLACK);
            getItemIndex(index);
        }
        return opt;
    }

    public static void showItemAttributes(AttributedItem item) {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_CYAN + item.getName() + TextColor.ANSI_BLACK);
        printItemAttributes(item);
    }

    public static void printItemAttributes(AttributedItem item) {
        sleep(1);
        if (item.getDamage() > 0) {
            sleep(1);
            System.out.println(TextColor.ANSI_GREEN + "+ " + item.getDamage() + " Damage" + TextColor.ANSI_BLACK);
        }
        if (item.getHealth() > 0) {
            sleep(1);
            System.out.println(TextColor.ANSI_GREEN + "+ " + item.getHealth() + " Health" + TextColor.ANSI_BLACK);
        }

        GameStats stats = item.getItemStats();
        for (StatType statType : StatType.values()) {
            Stats s = stats.getStat(statType);
            if (s.getStatValue() > 0) {
                sleep(1);
                System.out.println(TextColor.ANSI_GREEN + "+ " + s.getStatValue() + " " + s.getName() + TextColor.ANSI_BLACK);
            }
        }
    }

    public static String pickupItem() {
        boolean exitLoop = false;
        String s = null;

        System.out.println("You found an item, pick it up?");
        do {
        System.out.println();
        sleep(1);
        System.out.println("[Y] Yes");
        System.out.println("[N] No");

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLine());
            s = sc.nextLine().toLowerCase();
            if (s.equals("y") || s.equals("n")) {
                exitLoop = true;
            } else {
                System.out.println(TextColor.ANSI_RED + "Invalid input" + TextColor.ANSI_BLACK);
            }
        } while (!exitLoop);
        if (s.equals("y")) System.out.println(TextColor.ANSI_GREEN + "Item is added to your inventory" + TextColor.ANSI_BLACK);
        return s;
    }

    public static void showCharacter(Hero hero) {
        System.out.println();
        sleep(1);
        System.out.println(hero.getName());
        System.out.println(TextColor.ANSI_RESET + "Skill:" + hero.getSkill().getName());
        System.out.println("Health: " + hero.getMaxHealth());

        int minDamage = hero.getMinDamage();
        System.out.println("Damage: " + minDamage + "-" + hero.getDamage() + TextColor.ANSI_BLACK);

        for (StatType statType : StatType.values()) {
            System.out.println(TextColor.ANSI_CYAN + statType.toString() + ": " + hero.getStat(statType).getStatValue() + TextColor.ANSI_BLACK);
        }
    }

    public static void itemAlreadyEquipped() {
        System.out.println();
        sleep(1);
        System.out.println(TextColor.ANSI_RED + "Item is already equipped!" + TextColor.ANSI_BLACK);
    }

    public static void printNarrative(String[] strings) {
        System.out.println();
        for (String string : strings) {
            sleep(2);
            System.out.println(TextColor.ANSI_BLUE + string + TextColor.ANSI_BLACK);
        }
    }

    public static void printDroppedConsumable(String itemName, String enemyName) {
        System.out.println(enemyName + " dropped " + itemName);
        System.out.println(itemName + " is added in your consumables inventory");
    }

    public static void showEquippedItem(EnumMap<EquipmentType, EquippableItem> equippedItems) {
        for (EquipmentType type : EquipmentType.values()) {
            if (equippedItems.containsKey(type)) {
                System.out.println(type.toString() + ": " + equippedItems.get(type));
            } else {
                System.out.println(type.toString() + ": ");
            }
        }
    }

    public static void printStatBoostDeactivate(GameStats stats) {
        for (StatType stat: StatType.values()) {
            int statValue = stats.getStat(stat).getStatValue();
            if (statValue > 0)
                System.out.println(TextColor.ANSI_RED + "- " + statValue + TextColor.ANSI_BLACK);
        }
    }
}
