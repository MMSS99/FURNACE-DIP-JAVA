package edu.estatuas.furnace.rooms;

import java.util.Locale;
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

    public void coolOff(){
        double targetTemperature = ThreadLocalRandom.current().nextInt(0, 22);
        double currentTemperature = getTemperature();

        while (currentTemperature > targetTemperature){
            currentTemperature -= 1*(Math.random()+1);
            System.out.printf(Locale.US, "The temperature has dropped to %.1fºC%n", currentTemperature);
        }

        System.out.printf(Locale.US, "The room has stopped cooling off at %.1fºC", currentTemperature);
        System.out.println("\n");
        room.updateTemperature(currentTemperature);
    }

    public void coolOff(double targetTemperature){
        double currentTemperature = getTemperature();

        while (currentTemperature > targetTemperature){
            currentTemperature -= 1*(Math.random()+1);
            System.out.printf(Locale.US, "The temperature has dropped to %.1fºC%n", currentTemperature);
        }

        System.out.printf(Locale.US, "The room has stopped cooling off at %.1fºC", currentTemperature);
        System.out.println("\n");
        room.updateTemperature(currentTemperature);
    }
}
