package edu.estatuas.furnace.rooms;

import java.util.concurrent.ThreadLocalRandom;

public class Room {
    private double temperature;
    private static Room room = null;

    private Room(){
        temperature = ThreadLocalRandom.current().nextInt(0, 22);;
    }

    public static Room getInstance(){
        if (room == null){
            room = new Room();
        }
        return room;
    }

    public double getTemperature(){
        return temperature;
    }

    public void updateTemperature(double newTemperature){
        temperature = newTemperature;
    }
}
