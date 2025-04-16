package com.example.olioharkkaty2;

import java.util.HashMap;

public class Storage {
    private static Storage instance;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private HashMap<Integer, String> lutemonLocations = new HashMap<>();  // Sijaintien tallentaminen
    private int idCounter = 0;

    private Storage() {}

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public void removeLutemon(int id) {
        lutemons.remove(id);
        lutemonLocations.remove(id);  // Poistetaan myös sijainti
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public HashMap<Integer, Lutemon> getAllLutemons() {
        return lutemons;
    }

    public int generateId() {
        return idCounter++;
    }

    // Poista Lutemon nykyisestä sijainnista
    public void removeLutemonFromCurrentLocation(int lutemonId) {
        lutemonLocations.remove(lutemonId);  // Poistetaan sijainti
    }

    // Määrittele Lutemon uusi sijainti
    public void setLutemonLocation(int lutemonId, String location) {
        lutemonLocations.put(lutemonId, location);  // Tallennetaan sijainti
    }

    // Hae Lutemonin sijainti
    public String getLutemonLocation(int lutemonId) {
        return lutemonLocations.get(lutemonId);  // Palauttaa sijainnin
    }

    // Siirrä Lutemon "Kotiin"
    public void moveToHome(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Koti");
    }

    // Siirrä Lutemon "Treeniin"
    public void moveToTrainingArea(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Treeni");
    }

    // Siirrä Lutemon "Areenalle"
    public void moveToBattleField(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Areena");
    }
}
