package edu.estatuas.furnace.heaters;

public interface Heater {

    double heatUp(double currentTemp);
    double heatUp(double currentTemp, double desiredTemp);
}
