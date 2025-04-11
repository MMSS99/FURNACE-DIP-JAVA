package edu.estatuas.furnace.thermometers;

import edu.estatuas.furnace.rooms.Room;

import java.util.Locale;
import java.util.Optional;

public class DigitalThermo implements Thermometer {

    private double temperature;
    private double MAX_TEMP = 99.99d;
    private Optional<Room> linkedRoom = Optional.empty();

    public DigitalThermo(double temperature) {
        this.temperature = temperature;
    }

    public DigitalThermo(Room room) {
        linkedRoom = Optional.of(room);
        temperature = room.getTemperature();
    }

    public void updateTemp(double temperature){
        this.temperature = temperature;
    }

    public void linkRoom(Room room){
        linkedRoom = Optional.of(room);
    }

    @Override
    public void readTemp(){
        double currentTemperature;
        if(linkedRoom.isPresent()){
            currentTemperature = linkedRoom.get().getTemperature();
        } else {
            currentTemperature = temperature;
        }

        if (currentTemperature <= MAX_TEMP) {
            System.out.printf(Locale.US,"Current temperature: %.2fºC", currentTemperature);
        } else {
            System.out.println("ERROR: MAXIMUM TEMPERATURE EXCEEDED");
        }

        System.out.println("\n ");
    }
}
