package edu.estatuas.furnace.rooms;

public class Room {
    private double temperature;
    private static Room room = null;

    private Room(double initialTemperature){
        temperature = initialTemperature;
    }

    public static Room getInstance(double initialTemperature){
        if (room == null){
            room = new Room(initialTemperature);
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
