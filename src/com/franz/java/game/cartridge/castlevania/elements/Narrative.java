package com.franz.java.game.cartridge.castlevania.elements;

import java.util.ArrayList;

public class Narrative {
    private ArrayList<String[]> narrative = new ArrayList<>();
    private boolean isNarrated = false;

    public void addNarrative(String[] s) {
        narrative.add(s);
    }

    public String[] getNarrative(int index) {
        if (index > narrative.size() - 1) {
            narrative.add(new String[]{});
        }
        if (index == 1) isNarrated = true;
        return narrative.get(index);
    }

    public boolean isNarrated() {
        return isNarrated;
    }
}
