package com.example.olioharkkaty2;

import java.util.HashMap;

public class Storage {
    private static Storage instance;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private HashMap<Integer, String> lutemonLocations = new HashMap<>();
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
        lutemonLocations.put(lutemon.getId(), "Koti");
    }


    public void removeLutemonFromAllPlaces(int lutemonId) {
        lutemons.remove(lutemonId);
        lutemonLocations.remove(lutemonId);
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

    public void removeLutemonFromCurrentLocation(int lutemonId) {
        lutemonLocations.remove(lutemonId);
    }


    public void setLutemonLocation(int lutemonId, String location) {
        lutemonLocations.put(lutemonId, location);
        Lutemon lutemon = lutemons.get(lutemonId);
        if (lutemon != null) {
            lutemon.setLocation(location);
        }
    }

    public String getLutemonLocation(int lutemonId) {
        String location = lutemonLocations.get(lutemonId);
        if (location == null) {
            Lutemon lutemon = lutemons.get(lutemonId);
            return lutemon != null ? lutemon.getLocation() : "Tuntematon";
        }
        return location;
    }

    public void moveToHome(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Koti");
        lutemon.heal();
    }

    public void moveToTrainingArea(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Treeni");
        lutemon.addExperience();
    }

    public void moveToBattleField(Lutemon lutemon) {
        setLutemonLocation(lutemon.getId(), "Areena");
    }
}
