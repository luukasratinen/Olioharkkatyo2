package com.example.olioharkkaty2;

import java.util.ArrayList;

public class Home {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
